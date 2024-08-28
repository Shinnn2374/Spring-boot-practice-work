package com.example.second_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan("com.example")
public class SecondTaskApplication{

    public static void main(String[] args)
	{
		SpringApplication.run(SecondTaskApplication.class, args);
	}
}
