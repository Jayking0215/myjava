package com.ex;
///////////////////////////////////
//static import  (static�޼���,static���� �տ� Ŭ�������� �����ϰ� ����� �� �ִ�)
import static com.mongodb.client.model.Filters.eq;
import static java.lang.System.out;
import static com.mongodb.client.model.Updates.*;
////////////////////////////////////
import java.util.Scanner;

//org.bson.Document
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
/////////////////////////////////
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
public class MongoJavaTest {
	
	static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		String db="mydb";
		MongoClient mongoClient=null;
		MongoDatabase mongodb;
		MongoCollection<Document> collection=null;
		String collectionName="posts";//author, title, kind
		
		mongoClient=MongoClients.create("mongodb://localhost:27017");
		mongodb=mongoClient.getDatabase(db);//use mydb
		//db.createCollection('posts')
		//db.posts.find()...
		collection=mongodb.getCollection(collectionName);
		
		//insertOne(collection);
		select(collection);
		//find(collection);
		//delete(collection);
		
		update(collection);
		out.println("----���� ��-------------");
		select(collection);
		mongoClient.close();
	}//-------------------------------
	
	private static void update(MongoCollection<Document> collection) {
		out.println("������ ���� ����(Author) : ");
		String author=sc.nextLine();
		
		out.println("������ �Խ��� ����(Kind): ");
		String kind=sc.nextLine();
		
		System.out.println("������ Title: ");
		String title=sc.nextLine();
		out.printf("%s, %s, %s", author, kind, title);
		out.println("---------------------------");
		
		Bson filter=eq("author", author);//where���� �ش�
		
		//Bson edit=Updates.combine(Updates.set("title", title), Updates.set("kind", kind) );//set���� �ش�
		Bson edit=combine(set("title",title), set("kind",kind));
				
		//UpdateResult res=collection.updateOne(filter, edit);
		UpdateResult res=collection.updateMany(filter, edit);
		
		long cnt=res.getModifiedCount();
		out.println(cnt+"���� posts�÷����� ��ť��Ʈ ������");
		
	}//-------------------------------

	private static void delete(MongoCollection<Document> collection) {
		out.println("������ ���� author: ");
		String author=sc.nextLine();
		
		//DeleteResult res=collection.deleteOne(Filters.eq("author",author));
		DeleteResult res=collection.deleteMany(eq("author",author));
		
		long cnt=res.getDeletedCount();
		out.println(cnt+"���� posts�÷����� ��ť��Ʈ ������");
	}//------------------------------------------------


	private static void find(MongoCollection<Document> collection) {
		System.out.println("�˻��� author: ");
		String author=sc.nextLine();
		
		Bson filter=Filters.eq("author",author);
		
		FindIterable<Document> cursor=collection.find(filter);
		MongoCursor<Document> mc=cursor.iterator();
		while(mc.hasNext()) {		
			Document doc=mc.next();
			String kind=doc.getString("kind");
			String title=doc.getString("title");
			
			String author2=(String)doc.get("author");
			
			//Object id=doc.get("_id");			
			ObjectId oid=doc.getObjectId("_id");
			
			System.out.println(kind+"\t\t"+title+"\t\t\t"+author2+"\t"+oid);
		}
		mc.close();
	}//-----------------------------------------


	private static void select(MongoCollection<Document> collection) {
		FindIterable<Document> cursor=collection.find();
		/*
		for(Document doc:cursor) {
			System.out.println(doc.toJson());
		}
		*/
		MongoCursor<Document> mc=cursor.iterator();
		while(mc.hasNext()) {
			Document doc=mc.next();
			String kind=doc.getString("kind");
			String title=doc.getString("title");
			
			String author=(String)doc.get("author");
			
			//Object id=doc.get("_id");			
			ObjectId oid=doc.getObjectId("_id");
			
			System.out.println(kind+"\t\t"+title+"\t\t\t"+author+"\t"+oid);
		}
		mc.close();
		System.out.println("====������ �÷��� ��ȸ ����===============");
	}//------------------------------------




	public static void insertOne(MongoCollection<Document> col) {
		System.out.println("Kind: ");
		String kind=sc.nextLine();
		
		System.out.println("Author: ");
		String author=sc.nextLine();
		
		System.out.println("Title: ");
		String title=sc.nextLine();
	
		//System.out.println(kind+", "+author+", "+title);
		
		Document doc=new Document("kind", kind) //key(�ʵ��), value(������)
				.append("author", author)
				.append("title", title);
		InsertOneResult res=col.insertOne(doc);
		System.out.println(res.getInsertedId()+" id�� posts�÷��� ������");
		
	}

}



