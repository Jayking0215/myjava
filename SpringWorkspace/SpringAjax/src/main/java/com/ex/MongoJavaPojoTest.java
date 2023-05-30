package com.ex;

//eq(), gt(), gte(), lt(), lte(), or(), not(),....
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.not;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
////////////////////////////////////////////////////////////
//static import
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.util.regex.Pattern;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;

public class MongoJavaPojoTest {
	
	String db="mydb";
	String colName="posts";
	MongoClient mClient;
	MongoDatabase mdb;
	MongoCollection<PostsVO> collection;
	Scanner sc=new Scanner(System.in);
	public MongoJavaPojoTest() {
		
		mappingPojo();
	}
	/**�ڵ� ������Ʈ���� ����ؼ� Bson Document�� Java Pojo�� �����ϴ� �޼���
	 * Bson�����͸� �ڹ� POJO��ü�� ���ڵ�,���ڵ��ϴ� ����� �ϵ��� �����ϴ� �޼���
	 * */
	public void mappingPojo() {
		ConnectionString conStr=new ConnectionString("mongodb://localhost:27017");
		CodecRegistry pojoCodecResgistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
		CodecRegistry codecRegistry= fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecResgistry);
		
		MongoClientSettings clientSettings=MongoClientSettings.builder()
											.applyConnectionString(conStr)
											.codecRegistry(codecRegistry)
											.build();
		
		mClient=MongoClients.create(clientSettings);
		mdb=mClient.getDatabase(db);//use mydb
	}//------------------------------------
	
	public List<PostsVO> selectAll() {
		collection=mdb.getCollection(colName,PostsVO.class);
		FindIterable<PostsVO> cursor=collection.find();
		List<PostsVO> arr=makeList(cursor);
		return arr;
	}//---------------------------------
	
	private List<PostsVO> makeList(FindIterable<PostsVO> cursor) {
		List<PostsVO> arr=new ArrayList<>();
		if(cursor!=null) {
			MongoCursor<PostsVO> mc=cursor.iterator();
			while(mc.hasNext()) {
				PostsVO vo=mc.next();
				arr.add(vo);
			}
		}		
		return arr;
	}
	private void insertOne() {
		collection=mdb.getCollection(colName, PostsVO.class);
		System.out.println("Kind: ");
		String kind=sc.nextLine();
		
		System.out.println("Author: ");
		String author=sc.nextLine();
		
		System.out.println("Title: ");
		String title=sc.nextLine();
		
		PostsVO vo=new PostsVO(null,author,kind,title);
		InsertOneResult res=collection.insertOne(vo);
		System.out.println(res.getInsertedId()+" Insert OK!!");
	}

	public static void main(String[] args) {
		MongoJavaPojoTest app=new MongoJavaPojoTest();
		app.insertOne();
		//app.insertMany();
		List<PostsVO> arr=app.selectAll();
		app.printPosts(arr);
		//app.deleteOne();
		//app.deleteMany();
		//System.out.println("---������ posts ------------");
		//arr=app.selectAll();
		//System.out.println(arr);
		
		//app.updateOne();
		//app.updateReplace();
		//app.updateMany();
		//List<PostsVO> arr2=app.selectAll();
		//app.printPosts(arr2);
		
		app.searchMany();
		
	}//------------------------------------
	
	private void searchMany() {
		System.out.println("�˻�� �Է��ϼ���");
		String key=sc.nextLine();
		collection=mdb.getCollection(colName, PostsVO.class);
		Pattern pattern=Pattern.compile(key, Pattern.CASE_INSENSITIVE);
		Bson filter=Filters.regex("title", pattern);
		
		FindIterable<PostsVO> cursor=collection.find(filter);		
		List<PostsVO> arr=makeList(cursor);
		printPosts(arr);		
	}//---------------------------------------
	public void printPosts(List<PostsVO> arr) {
		
		System.out.println("------------------------");
		for(PostsVO vo:arr)
			System.out.println(vo);
		System.out.println("------------------------");
	}
	
	// kind�� �����Խ����� �ƴ� posts���� kind�� QnA�� �����ϼ���
	private void updateMany() {
		collection=mdb.getCollection(colName,PostsVO.class);
		UpdateResult res=collection.updateMany(not(eq("kind","�����Խ���")), set("kind","QnA"));
		System.out.println(res.getModifiedCount()+"���� posts���� �����߾��");
	}//------------------------------------
	private void updateReplace() {
		System.out.println("������ ���� Author: ");
		String author=sc.nextLine();
		System.out.println("������ ���� Title : ");
		String title=sc.nextLine();
		System.out.println("������ ���� Kind: ");
		String kind=sc.nextLine();
		
		PostsVO vo=new PostsVO(null, author, kind, title);
		
		collection=mdb.getCollection(colName, PostsVO.class);
		long cnt=collection.replaceOne(eq("author", author), vo).getModifiedCount();
		System.out.println(cnt+"���� posts ���� ��ü�߾��");
	}//------------------------------------
	private void updateOne() {
		System.out.println("������ ���� Author: ");
		String author=sc.nextLine();
		System.out.println("������ ���� Title : ");
		String title=sc.nextLine();
		System.out.println("������ ���� Kind: ");
		String kind=sc.nextLine();
		
			
		collection=mdb.getCollection(colName,PostsVO.class);
		UpdateResult res=collection.updateOne(eq("author", author), combine(set("title", title), set("kind", kind)));
		System.out.println(res.getModifiedCount()+"���� posts���� �����߾��");
	}//------------------------------------
	private void deleteMany() {
		System.out.println("������ ���� author�� �Է��ϼ���");
		String author=sc.nextLine();
		collection=mdb.getCollection(colName, PostsVO.class);
		DeleteResult res=collection.deleteMany(eq("author", author));
		System.out.println(res.getDeletedCount()+"���� posts���� �����߾��");		
	}//---------------------------------------
	private void deleteOne() {
		System.out.println("������ ���� author�� �Է��ϼ���");
		String author=sc.nextLine();
		Bson filter=eq("author", author);
		collection=mdb.getCollection(colName,PostsVO.class);
		
		DeleteResult res=collection.deleteOne(filter);
		System.out.println(res.getDeletedCount()+"���� posts���� �����߾��");
	}//---------------------------------------
	
	
	
	private void insertMany() {
		collection=mdb.getCollection(colName, PostsVO.class);
		List<PostsVO> posts=Arrays.asList(
				new PostsVO(null,"������","�����Խ���","�����Ӱ� ���� ���ϴ�"),
				new PostsVO(null,"�̹ξ�","�����Խ���","Have a nice day!!!"),
				new PostsVO(null,"ȫ�浿","�����Խ���","���� �����Ӱ� ���� ���ϴ�")				
				);
		InsertManyResult res=collection.insertMany(posts);
		
		System.out.println(res.getInsertedIds()+" Insert OK~~");
		
	}


	

}
