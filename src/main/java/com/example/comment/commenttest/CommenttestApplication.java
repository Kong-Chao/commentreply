package com.example.comment.commenttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = "com.example.comment.commenttest.model")
@EnableJpaRepositories(basePackages = "com.example.comment.commenttest.dao")
public class CommenttestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommenttestApplication.class, args);
    }

}
