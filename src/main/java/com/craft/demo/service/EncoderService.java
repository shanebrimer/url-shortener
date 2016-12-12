package com.craft.demo.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;

@Service
public class EncoderService {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
    private static final int maxLength = 6;

    // private static final String ALPHABET = "01";
    // private static final int maxLength = 40;

    public String encode(String original) {
        byte[] hashed = Hashing.sha256().hashString(original, StandardCharsets.UTF_8).asBytes();
        BigInteger hashedInt = new BigInteger(hashed);
        BigInteger moddedInt = hashedInt.mod(getLargestRepresentableValue());
        return encodeInt(moddedInt);
    }

    public BigInteger getLargestRepresentableValue() {
        return BigInteger.valueOf(ALPHABET.length()).pow(maxLength);
    }

    private String encodeInt(BigInteger bigInt) {
        BigInteger base = BigInteger.valueOf(ALPHABET.length());
        StringBuilder sb = new StringBuilder();
        while (bigInt.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] bigIntPair = bigInt.divideAndRemainder(base);
            sb.append(ALPHABET.charAt(bigIntPair[1].intValueExact()));
            bigInt = bigIntPair[0];
        }
        sb.reverse();
        return sb.toString();
    }

}
