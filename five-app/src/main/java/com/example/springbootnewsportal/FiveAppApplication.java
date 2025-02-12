package com.example.springbootnewsportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCaching
public class FiveAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiveAppApplication.class, args);
    }

}
