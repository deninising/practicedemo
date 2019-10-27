package com.dennis.tokentool;

import com.auth0.jwt.interfaces.Claim;
import org.junit.Test;

import java.util.Map;

public class JwtTokenToolTest {

    @Test
    public void createToken() {

        String token = null;
        try {
           token = JwtTokenTool.createToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("用私钥创建的token--->"+token);

    }

    @Test
    public void verifyToken() {
        try {
            Map<String, Claim> stringClaimMap = JwtTokenTool.verifyToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpUVyIsInNsZyI6IlJTMjU2In0.eyJjb21wYW55TmFtZSI6Imd1b3RpZSIsImV4cCI6MTU3MjA5NTM1OSwiaWF0IjoxNTcyMDk1MTc4LCJ1c2VybmFtZSI6InpoYW5nc2FuIn0.cZx3tXIXJtIQzgVCwSnxQPRRS1LIKHurIR2UVqpj8dM");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void getUsername() {
    }
}