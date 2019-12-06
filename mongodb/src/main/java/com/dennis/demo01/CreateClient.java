package com.dennis.demo01;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class CreateClient {
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

        // 创建集合
        try {
            System.out.println("+++++++++++创建集合+++++++++++");
            db01.createCollection("test01Collection");
            System.out.println("cellection creating successfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getClass().getName() + ":" + e.getMessage());
        }
    }
}
