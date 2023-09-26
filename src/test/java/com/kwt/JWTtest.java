package com.kwt;

import com.kwt.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.ibatis.annotations.Insert;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JWTtest {
    @Test
    public void testGenJwt(){
        Map<String, Object> data = new HashMap<>();
        data.put("id",1);
        data.put("name","Christopher");
        data.put("username","Christopher");
        System.out.println(data);
        System.out.println(JwtUtils.generateJwt(data));
    }

    @Test
    public void testParseJWT(){
        Claims claims = Jwts.parser()
                .setSigningKey("kwtasdqwe")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTY5NTc0MDgzNH0.kULAOCy6MfMghb-SU_v91bgklQwxHsBSXCCcnqr4Oq4")
                .getBody();
        System.out.println(claims);
    }
}
