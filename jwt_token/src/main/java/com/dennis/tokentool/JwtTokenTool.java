package com.dennis.tokentool;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenTool {
    public static String readResourceKey(String fileName) {
        String key = null;
        try {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            assert inputStream != null;
            key = IOUtils.toString(inputStream, String.valueOf(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return key;
    }

    public static String createToken() throws Exception {
        // 签发时间
        Date iatDate = new Date();

        // 过期时间 1分钟过期
        Calendar nowTime = Calendar.getInstance();
        System.out.println(nowTime);
        nowTime.add(Calendar.MINUTE,3);
        Date expiresDate = nowTime.getTime();

        // 设置header满足json数据格式的map 键必须为String，值为Object类型
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("slg","RS256");
        headerMap.put("typ","JTW");

        String privateKey = readResourceKey("static/rsa_private_key.pem");
        System.out.println("私钥为："+privateKey);

        // 生成token
        // param backups {iss:Service, aud:APP}
        String token = JWT.create().withHeader(headerMap) // header
                .withClaim("username", "zhangsan") // payload
                .withClaim("companyName", "guotie")
                .withIssuedAt(iatDate) // sign time
                .withExpiresAt(expiresDate) // expire time
                .sign(Algorithm.HMAC256(privateKey)); // signature
        return token;
    }



    /**
     * 解密Token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        String publicKey=readResourceKey("static/rsa_public_key.pem");
        System.out.println("公钥为："+publicKey);
        byte[] bytes = publicKey.getBytes();

        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(publicKey)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
           throw new RuntimeException("非法token!!!");
        }
        return jwt.getClaims();
    }

    /**
     * 根据Token获取username
     *
     * @param token
     * @return username
     */
    public static Long getUsername(String token) {
        Map<String, Claim> claims = verifyToken(token);
        Claim username_claim = claims.get("username");
        if (null == username_claim || StringUtils.isBlank(username_claim.asString())) {
            throw new RuntimeException("非法token!!!");
        }
        return Long.valueOf(username_claim.asString());
    }
}
