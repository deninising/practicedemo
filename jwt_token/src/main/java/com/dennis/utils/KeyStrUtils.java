package com.dennis.utils;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class KeyStrUtils {

    /**
     * 描述：生成对称密钥串
     *
     * @return void
     */
    public static void generateKeyStr() throws NoSuchAlgorithmException, IOException {
        KeyGenerator kg = KeyGenerator.getInstance("HmacSHA256");
        kg.init(521);
        SecretKey k = kg.generateKey();
        byte[] encoded = k.getEncoded();
        System.out.println(Arrays.toString(encoded));

        String s = byteArrToBinStr(encoded);
        System.out.println(s);

        byte[] encode = Base64.getEncoder().encode(encoded);
        System.out.println(new String(encode));
    }

    public static String byteArrToBinStr(byte[] b) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            result.append(Long.toString(b[i] & 0xff, 2) + ",");
        }
        return result.toString().substring(0, result.length() - 1);
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        KeyStrUtils.generateKeyStr();
    }
}
