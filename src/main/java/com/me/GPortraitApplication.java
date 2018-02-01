package com.me;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.me.mybatis.mapper")
public class GPortraitApplication {

	public static void main(String[] args) {
		SpringApplication.run(GPortraitApplication.class, args);
	}
}
