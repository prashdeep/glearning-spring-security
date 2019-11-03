package com.glearning.ssecurity.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(BCryptPasswordEncoder.BCryptVersion.$2B);
        String password = "welcome";
        String encoded1 = bCryptPasswordEncoder.encode(password);
        String encoded2 = bCryptPasswordEncoder.encode(password);
        String encoded3 = bCryptPasswordEncoder.encode(password);


        System.out.println(bCryptPasswordEncoder.matches("welcome", "$2a$10$ych5K0zoq1oPChu0QUOL8.TWTpFI/Msm9d.Krz630kBlr/L0QOArW"));
        System.out.println(bCryptPasswordEncoder.matches("testing", "$2a$10$ych5K0zoq1oPChu0QUOL8.TWTpFI/Msm9d.Krz630kBlr/L0QOArW"));

    }
}