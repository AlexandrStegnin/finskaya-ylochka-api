package com.finskaya.ylochka.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class FinskayaYlochkaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinskayaYlochkaApiApplication.class, args);
    }

}
