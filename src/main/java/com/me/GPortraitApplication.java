package com.me;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@MapperScan("com.me.mybatis.mapper")
public class GPortraitApplication {

	public static void main(String[] args) {
		SpringApplication.run(GPortraitApplication.class, args);
	}
}
