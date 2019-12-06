package com.dennis.demo01;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class QueryClient {
    public static void main(String[] args) {
        MongoDatabase db01 = null;

        try {
            // 创建并连接数据库
            System.out.println("+++++++++++创建并连接数据库+++++++++++");
            MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
            db01 = mongoClient.getDatabase("db01");
            System.out.println("database creating successfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getClass().getName() + ":" + e.getMessage());
        }

        MongoCollection<Document> test01Collection = db01.getCollection("test01Collection");
        System.out.println("++++++++获取集合成功+++++++++");

        FindIterable<Document> documents = test01Collection.find();
        MongoCursor<Document> iterator = documents.iterator();
        if (iterator.hasNext()) {
            Document next = iterator.next();
            System.out.println(next.toJson());
        }

    }
}
