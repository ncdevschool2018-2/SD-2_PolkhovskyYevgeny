/*
package com.netcracker.edu.fapi.old.security;

import com.netcracker.edu.fapi.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {
    
    
    private String secret = "youtube";
    
    public JwtUser validate(String token) {
        
        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            
            jwtUser = new JwtUser();
            
            jwtUser.setUserName(body.getSubject());
            jwtUser.setId(Integer.parseInt((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));
        }
        catch (Exception e) {
            System.out.println(e);
        }
        
        return jwtUser;
    }
}*/
