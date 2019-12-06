package com.dennis.demo01;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.nio.ByteBuffer;

public class UpdataClient {
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

        test01Collection.updateMany(Filters.eq("likes", 100), new Document("$set", new Document("likes", 200)));


    }
}
