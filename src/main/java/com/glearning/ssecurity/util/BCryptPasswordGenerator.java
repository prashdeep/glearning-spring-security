package com.glearning.ssecurity.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2B);
        String password = "welcome";
        String encoded1 = bCryptPasswordEncoder.encode(password);
        String encoded2 = bCryptPasswordEncoder.encode(password);
        String encoded3 = bCryptPasswordEncoder.encode(password);

        System.out.println(encoded1);
        System.out.println(encoded2);
        System.out.println(encoded3);

        System.out.println(bCryptPasswordEncoder.matches("welcome", encoded1));
        System.out.println(bCryptPasswordEncoder.matches("welcome", encoded2));
        System.out.println(bCryptPasswordEncoder.matches("welcome", encoded3));

    }
}