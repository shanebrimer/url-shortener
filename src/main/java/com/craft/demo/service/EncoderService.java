package com.craft.demo.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;

@Service
public class EncoderService {

    // private static final String ALPHABET =
    // "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
    // private static final int maxLength = 6;

    private static final String ALPHABET = "01";
    private static final int maxLength = 2;

    public BigInteger getHashedInt(String original) {
        byte[] hashed = Hashing.sha256().hashString(original, StandardCharsets.UTF_8).asBytes();
        return new BigInteger(hashed);
    }

    public String encode(BigInteger originalInt) {
        BigInteger moddedInt = originalInt.mod(getLargestRepresentableValue());
        BigInteger base = BigInteger.valueOf(ALPHABET.length());
        StringBuilder sb = new StringBuilder();
        do {
            BigInteger[] bigIntPair = moddedInt.divideAndRemainder(base);
            sb.append(ALPHABET.charAt(bigIntPair[1].intValueExact()));
            moddedInt = bigIntPair[0];
        } while (moddedInt.compareTo(BigInteger.ZERO) > 0);
        sb.reverse();
        return sb.toString();
    }

    public BigInteger getLargestRepresentableValue() {
        return BigInteger.valueOf(ALPHABET.length()).pow(maxLength);
    }

}
