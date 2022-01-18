package com.example.gitwork;

import com.google.common.io.Files;

import org.kohsuke.github.GHAppInstallationToken;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.BitSet;
import java.util.Date;
import java.util.List;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class GithubQuery {
    GitHub gb;
    String JWToken;
    static PrivateKey get(String file) throws Exception{
        byte[] bytes = Files.toByteArray(new File(file));
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }

    static String createAJWT(String appId, long ttlMillis) throws Exception{
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.RS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Key key = get("gitworked.2022-01-18.private-key.der");
        JwtBuilder jwt = Jwts.builder().setIssuedAt(now).setIssuer(appId).signWith(key, signatureAlgorithm);
        if (ttlMillis > 0){
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            jwt.setExpiration(exp);
        }
        return jwt.compact();
    }


}
