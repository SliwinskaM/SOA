package pl.edu.agh.soa.lab.jwt;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class KeyGenerator implements KeyGeneratorInterface {

    public Key generateKey() {
        String keyString = "z6B8DbGdJgNjQmTqVsXv2x4z7C9EcHeKgPkRnTrWtYv3y5A8DaFcJfMhPmSpUrXuZw4z6B8EbGdJgNjQ";
        return new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
    }
}