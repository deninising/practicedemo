package com.dennis;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class JwtToolTest {

    @Test
    public void generateKeysStr() throws UnsupportedEncodingException {
        JwtTool.generateKeysStr();
    }

    @Test
    public void soutKey() throws IOException {
        System.out.println(JwtTool.PRIVATE_KEY);
//        System.out.println(JwtTool.getPrivateKeyString());
        System.out.println(JwtTool.PUBLIC_KEY);
//        System.out.println(JwtTool.getPublicKeyString());
    }
}