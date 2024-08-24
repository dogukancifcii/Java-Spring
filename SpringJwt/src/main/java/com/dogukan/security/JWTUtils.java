package com.dogukan.security;

import com.dogukan.security.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.net.Authenticator;
import java.util.Date;

@Component
public class JWTUtils {

    private long expirationTime = 86400000;//24*60*60*1000

    private String secretKey = "dogukan";

    //token: header + payload(userla ilgili bilgileri) + signature
    // Bearer ekwsefmcvb1242sfdmk

    //1-JWT token generate:icine username kayacagiz
    public String generateToken(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        //login olan kullaniciyi getir

        //tokenin icine(payload) username bilgisini koyalim
        return Jwts.builder()//jwt olusturucuyu getirir
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())//System.currentMilis()-->24.08 21.09
                .setExpiration(new Date(new Date().getTime() + expirationTime))//->25.08 21.09
                .signWith(SignatureAlgorithm.HS512, secretKey)//hash fonksiyonu ile tek yonlu sifreleme yapilir , karsilastirma yapilabilir
                .compact();//ayarlari tamamlar ve tokeni olusturur
    }
    //2-JWT tokeni validate

    public boolean validateToken(String token) {

        try {
            Jwts.parser()//ayristirici
                    .setSigningKey(secretKey)//anahtari set ediyoruz
                    .parseClaimsJws(token);//anahtar uyumlu ise, JWT token gecerli
            return true;
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();

        } catch (SignatureException e) {
            e.printStackTrace();

        } catch (MalformedJwtException e) {
            e.printStackTrace();

        } catch (IllegalArgumentException e) {
            e.printStackTrace();

        }
        return false;


    }


    //3-JWT tokendan username i alma
    public String getUsernameFromToken() {
        return null;
    }
}
