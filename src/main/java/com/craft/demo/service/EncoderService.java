package com.craft.demo.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class EncoderService {

    private static final Random randomGenerator = new Random();

    public String getRandomEncodedString(String alphabet, int maxLength) {
        int base = alphabet.length();
        long largestEncodableValue = (long) Math.pow(base, maxLength);
        long seed = Math.abs(randomGenerator.nextLong()) % largestEncodableValue;

        StringBuilder sb = new StringBuilder();
        do {
            int charPosition = (int) (seed % base);
            seed /= base;
            sb.append(alphabet.charAt(charPosition));
        } while (seed > 0);

        sb.reverse();
        return sb.toString();
    }

}
