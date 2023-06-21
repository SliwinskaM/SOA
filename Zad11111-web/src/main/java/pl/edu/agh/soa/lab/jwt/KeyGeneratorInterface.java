package pl.edu.agh.soa.lab.jwt;

import java.security.Key;

public interface KeyGeneratorInterface {
    Key generateKey();
}