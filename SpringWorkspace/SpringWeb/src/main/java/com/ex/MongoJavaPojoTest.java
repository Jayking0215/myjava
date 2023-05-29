package com.ex;

////////////////////////////////////////////////////////////
//static import
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/////////////////////////////////////////////////////////////////
import java.util.Scanner;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertManyResult;
import com.mongodb.client.result.InsertOneResult;

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
		//app.insertOne();
		//app.insertMany();
		List<PostsVO> arr=app.selectAll();
		System.out.println("------------------------");
		for(PostsVO vo:arr)
			System.out.println(vo);
		System.out.println("------------------------");
	}
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
