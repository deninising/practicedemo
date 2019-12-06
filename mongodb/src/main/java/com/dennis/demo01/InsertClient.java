package com.dennis.demo01;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;

public class InsertClient {
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

        // 获取集合
        MongoCollection<Document> test01Collection = db01.getCollection("test01Collection");
        System.out.println("++++++++获取集合成功+++++++++");

        //插入文档
        /**
         * 1. 创建文档 org.bson.Document 参数为key-value的格式
         * 2. 创建文档集合List<Document>
         * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
         * */
        Document document = new Document("title", "mongoDB");
        document.append("description", "mongodatabase");
        document.append("likes", 100);
        document.append("by", "dennis");
        ArrayList<Document> documents = new ArrayList<>();
        documents.add(document);
        test01Collection.insertMany(documents);
        System.out.println("++++++++++插入文档成功++++++++++");
    }
}
