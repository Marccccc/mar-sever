package com.mar.shiro;

import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.authc.AuthenticationToken;

import java.util.Map;

@Getter
public class StatelessToken implements AuthenticationToken {

    private String tokenId;
    private String clientDigest;

    public StatelessToken(String tokenId,String clientDigest) {
        this.tokenId=tokenId;
        this.clientDigest=clientDigest;
    }

    public Object getPrincipal() {  return tokenId;}
    public Object getCredentials() {  return clientDigest;}

}