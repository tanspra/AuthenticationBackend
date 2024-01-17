package com.auth.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Component
@Getter
@Setter
public class RSAKeyProperties {

    private RSAPrivateKey privateKey;
    private RSAPublicKey publicKey;

    public RSAKeyProperties() {
        KeyPair keyPair=KeyGeneratorUtility.generateRSAKey();
        this.privateKey = (RSAPrivateKey) keyPair.getPrivate();
        this.publicKey = (RSAPublicKey) keyPair.getPublic();
    }
}
