package com.ex;
import java.util.Scanner;

import javax.swing.text.Document;

import org.bson.*;//org.bson.Document
import org.bson.conversions.*;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoJAvaTest {
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		String db="mydb";
		MongoClient mongoClient=null;
		MongoDatabase mongodb;
		MongoCollection<Document> collection=null;
		String collectionName="posts";//author, title, kind
		
		mongoClient=MongoClients.create("mongodb://localhost:27017");
		mongodb=mongoClient.getDatabase(db);//use mydb
		//db.createCollection("post")
		//db.posts.find()...
		collection=mongodb.getCollection(collectionName);
		
		/insertOne(collection);
		
		mongoClient.close();
	}//
	
	public static void select(MongoCollection<Document> collections) {
		FindIterable<Document> cursor=collection.find();
		fo(Document doc:curosr){
			System.out.println(doc.toJason);
		}
	}
	
	
	public static void insertOne(MongoCollection<Document> col) {
		System.out.println("kind: ");
		String kind=sc.nextLine();
		
		System.out.println("author: ");
		String author=sc.nextLine();
		
		System.out.println("Title: ");
		String title=sc.nextLine();
		
		//System.out.println(kind+", "+author+", "+title);
		
		Document doc=new Document("kind", kind)//key(필드명), value(데이터)
				.append("author", author)
				.append("title", title);
		InsertOneResult res=col.insertOne(doc);
		System.out.println(res.getInsertId()+"+ id로 posts컬렉션 저장됨");
	}

}
