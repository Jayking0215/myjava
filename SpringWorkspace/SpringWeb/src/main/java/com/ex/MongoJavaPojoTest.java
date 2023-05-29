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
	/**코덱 레지스트리를 사용해서 Bson Document를 Java Pojo로 매핑하는 메서드
	 * Bson데이터를 자바 POJO객체로 인코딩,디코딩하는 기능을 하도록 설정하는 메서드
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
				new PostsVO(null,"김작자","자유게시판","자유롭게 글을 씁니다"),
				new PostsVO(null,"이민아","자유게시판","Have a nice day!!!"),
				new PostsVO(null,"홍길동","자유게시판","저도 자유롭게 글을 씁니다")				
				);
		InsertManyResult res=collection.insertMany(posts);
		
		System.out.println(res.getInsertedIds()+" Insert OK~~");
		
	}


	

}
