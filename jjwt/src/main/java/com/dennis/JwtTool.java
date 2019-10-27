package com.dennis;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class JwtTool {

    public static final String PRIVATE_KEY = "MIIEpAIBAAKCAQEAudbvmC39mmOzbvvig6Yxrs9F8lTROdW/aLS/HwG0l+66tt/f" +
            "Usj6sOGDKjHyhfCh0yrv8GW8YnZ0Z/86YfeOTgb6UPpGvFtcosbcr6j9JUVxZTtw" +
            "wzkhHdz5GN+rJ+MIIB1z+0fmAbYxM/D58ptzL9hq9TTAl/42u5yd6cswnLvEan04" +
            "Ef7M9YvhGEPG7Vdlp9/B3ZcDOJmXkJJ+SPZZkR1/FEdvbQ/NxFSf86Lx5irtB47v" +
            "m5jLc+qSe+0UVsptNbLs+9Yn3XrGudIWZ+qcUB7vb6AqZ20DLcaFVXUi+QrOagfN" +
            "iZN6/9YYKkvb0mfNMPYd2tmtQVAetBt5sU8hHwIDAQABAoIBAQCmXrxqYanrAJzP" +
            "m+JCd5N86wS0mKgifa/5He8H5C/34Hn5Y9x7MX/0wD77lHGI5U8KTCM39Ow8vc0i" +
            "mUR8FfKo+eg4fIa885GwDBXfkIroRg3pUdh2fXufT4cVdI+2irJohdWiPNC18ZSE" +
            "6pPpVK8/QyEl2g8dQzFerixU9FnVxWBqeiTzfA1VP/5SGClsBqxjB8WaW1wQnsje" +
            "cg51Vjseyb/M57QfsjP4dym7lILWQOaJls4qAMTSeOUuZozAwLz1zWBzU6YC34nC" +
            "EFQ+EYzG8HOko3bd6TkRn6lcIWprNdeRyKtux0fqUElS2jbX5m9V7kOZ0ikpNph/" +
            "EHLGuJghAoGBAOTTqgRT7wNPSOc27RFTGqPUvpTL4jUcHgV8B3G6qOpZYyjnxLH6" +
            "MEP1eWYnOcty+cRI/QB/GtId0aYz5G6pZKHcn6xI1iPMPLi+0lIul2IvakHc6cSV" +
            "qtUuIpdxNCOkqAdxQg6mVd0jqiTXfW3rQHw4EioDD0+iKCKvKDkZEW6vAoGBAM/o" +
            "dc2zACr2kAi6a5KPVT8htTP9I0TxHKzVyBVgdEHZDaJS7W+fdv/GqnOoOqTol641" +
            "E3/VpBED1SmHJnlgEr1p3R/teytAgxwq1oye18bICs/JExXdRvtJ8KZEyw8YjhEO" +
            "4D483UoB9QSXxUNoeyJwtFVWIZw5ky8Bkr/l45CRAoGAJb9Q7ZPW+snKcfHam6AE" +
            "5f/DTJJxh2dTAH6cT8OF99q1A9tv1Bg8fAlzdEmGPCyETT/pFHrjNsQagHtQ9HxX" +
            "EGhvoqEFSjR309YOpeXvrQ+7TJAftAEohDAvHqJbAoI4AbpKNlZ0FZ27hIZTt502" +
            "Lwek329PyEgsrMQOM5USDhsCgYBsj9i7oUVsKbVKKXW0YM3FmmdRD1RUUoaDpVnF" +
            "98ic/abF5QGAcMclhepJXEXLCHzzhVl6Pedezx6GgcDQTh9a8qV5X3saOaR8l83S" +
            "Pbs0XA5xM3CY0SOYYaKcX32ck1jThW4IcaWnWGBFlq51pV/uuuUfTktclR/KwsqL" +
            "E5KBUQKBgQDiS90PQpOw3Bh8sUfTz3Qu+ekJvmfUg+Yoo8UO/IYluYY3nWs4UD1t" +
            "p89/TYC2Sfen0ta0n0FktG2szvUhMJHoqQdfwgHvScIs6FhloG+O29XLFMuFYReN" +
            "rJFD0yGJTmQcBoQ91aW7Tda3cO8Xh8s5rPGh0L9++FfMSAQ39qsxKQ==";


    public static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAudbvmC39mmOzbvvig6Yx" +
            "rs9F8lTROdW/aLS/HwG0l+66tt/fUsj6sOGDKjHyhfCh0yrv8GW8YnZ0Z/86YfeO" +
            "Tgb6UPpGvFtcosbcr6j9JUVxZTtwwzkhHdz5GN+rJ+MIIB1z+0fmAbYxM/D58ptz" +
            "L9hq9TTAl/42u5yd6cswnLvEan04Ef7M9YvhGEPG7Vdlp9/B3ZcDOJmXkJJ+SPZZ" +
            "kR1/FEdvbQ/NxFSf86Lx5irtB47vm5jLc+qSe+0UVsptNbLs+9Yn3XrGudIWZ+qc" +
            "UB7vb6AqZ20DLcaFVXUi+QrOagfNiZN6/9YYKkvb0mfNMPYd2tmtQVAetBt5sU8h" +
            "HwIDAQAB";


    public static void initSignatureAlgorithm() {
        Keys.keyPairFor(SignatureAlgorithm.RS256);
    }

    // 从文件中获取私钥字符串
    public static String getPrivateKeyString() throws IOException {
        //    生成方法：安装openssl,执行     openssl genrsa -out private.pem 2048
        return IOUtils.toString(new FileInputStream("D:\\Github\\practicedemo\\jjwt\\src\\main\\resources\\static\\rsa_private_key.pem"));
    }

    // 从文件中获取公钥字符串
    public static String getPublicKeyString() throws IOException {
        //    导出公钥方法：生成私钥(private.pem)后,执行    openssl rsa -in private.pem -outform PEM -pubout -out public.pem
        return IOUtils.toString(new FileInputStream("D:\\Github\\practicedemo\\jjwt\\src\\main\\resources\\static\\rsa_public_key.pem"));
    }


    public static PrivateKey getPrivateKey(String privateKeyStr) throws Exception {
        byte[] bytes = Base64.getDecoder().decode(privateKeyStr);

        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory rsaFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = rsaFactory.generatePrivate(pkcs8EncodedKeySpec);
        return privateKey;
    }


    public static PublicKey getPublicKey(String publicKeyStr) throws Exception {
        byte[] bytes = Base64.getDecoder().decode(publicKeyStr);

        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(bytes);
        KeyFactory rsaFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = rsaFactory.generatePublic(x509EncodedKeySpec);
        return publicKey;
    }

    public static void generateKeysStr() throws UnsupportedEncodingException {
        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);

        System.out.println("-----------------------------------------");
        System.out.println("----------------私钥信息-------------------");
        PrivateKey aPrivate = keyPair.getPrivate();
        String format = aPrivate.getFormat();
        System.out.println(format);
        byte[] encoded = aPrivate.getEncoded();
        byte[] encode = Base64.getEncoder().encode(encoded);
        String Prk = new String(encode, "UTF-8");
        System.out.println("私钥为：" + Prk);
        System.out.println("-----------------------------------------");


        System.out.println("-----------------------------------------");
        System.out.println("----------------公钥信息-------------------");
        PublicKey aPublic = keyPair.getPublic();
        String format1 = aPublic.getFormat();
        System.out.println(format1);
        byte[] encoded1 = aPublic.getEncoded();
        byte[] encode1 = Base64.getEncoder().encode(encoded1);
        String Pbk = new String(encode1, "UTF-8");
        System.out.println("公钥为：" + Pbk);
        System.out.println("-----------------------------------------");

    }

    public static void main(String[] args) throws Exception {
        // 初始化签名算法
        JwtTool.initSignatureAlgorithm();
        // 获取私钥
        PrivateKey privateKey = JwtTool.getPrivateKey(JwtTool.getPrivateKeyString());
        // 获取公钥
        PublicKey publicKey = JwtTool.getPublicKey(JwtTool.getPublicKeyString());
        //生成签名
        String jws = Jwts.builder() // (1)
                .setSubject("Bob")      // (2)
                .signWith(privateKey)          // (3)
                .compact();
        System.out.println(jws);

        String testJwt = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJCb2IifQ.Nqzt-Es33NlYt_0Fq-6BjGuvb5vF-WRPTkudOguAAfnw_nJpJqZdROoPgfglivjVj6732XYVj9ewsD89vQGKXNV5AxsBTLzpPDtoPkM_U26xRRXlM_5S3HiVLUp9ug3I-m-bT-XwK7QRZEzSfA8hcRTgIFFXtHLxGUurXdu3Xc3fzjNJjdHzGoEn_8diwsh_cVswJ3Rb5emwy8zqUN0Ajz346NeUY9bUwG7lzrc4PneOko8vrmRIfCW9gyyO3j4ALO0HgHghl7qJ0wU3hDdsixk5IpT3zmYoeSzR2AbiCSeXXDAMAcXj-6JMaqPJwcDB1-JajUIAVxxg5p6cCMvzyw";

        // 解析签名
        JwtParser parser = Jwts.parser();


        Jws<Claims> claimsJws = null;
        try {
            claimsJws = parser.setSigningKey(publicKey).parseClaimsJws(testJwt);
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            System.out.println("token已过期");
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
            System.out.println("token格式不符合：header.patload.signature 格式");
        } catch (MalformedJwtException e) {
            e.printStackTrace();
            System.out.println("token结构不对！");
        } catch (SignatureException e) {
            e.printStackTrace();
            System.out.println("解析时的密钥不对导致计算出的签名不匹配SignatureException,或是解析的token的签名本就不合法");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("解析时选择的算法不匹配");
        }

        Claims body = claimsJws.getBody();// 获取载荷
        String subject = body.getSubject();// 获取载荷中的subject
        System.out.println("用户主体--->" + subject);

        JwsHeader header = claimsJws.getHeader();// 获取头对象
        String algorithm = header.getAlgorithm();// 获取头中的加密算法信息
        System.out.println("算法名称--->" + algorithm);

        String signature = claimsJws.getSignature();// 获取签名信息
        System.out.println("签名信息为--->" + signature);
    }
}
