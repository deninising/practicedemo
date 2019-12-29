package com.dennis.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class HttpClientTest {

    @Test
    public void testHttpClient() throws IOException, InterruptedException, ExecutionException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "admin");
        String jsonString = JSONObject.toJSONString(map);
        System.out.println(jsonString);
        String[] strings = {"Content-Type","application/json","platformName","groove-portal"};

        HttpRequest request = HttpRequest.newBuilder(URI.create("http://localhost:8088/v2/ssoserver/listUserPerms"))
                .headers(strings)
                .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                .build();

        HttpRequest.Builder builder = HttpRequest.newBuilder();


        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        CompletableFuture<JSONObject> json = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(body -> {
                    try {
                        System.out.println(body);
                        return JSON.parseObject(body);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return new JSONObject();
                    }
                });

        System.out.println(JSON.toJSONString(json.get(), SerializerFeature.WriteMapNullValue));
        System.out.println("==================================================");
        System.out.println(response.body());

    }


}
