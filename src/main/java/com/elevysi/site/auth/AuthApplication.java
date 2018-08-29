package com.elevysi.site.auth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class AuthApplication{

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}
	
}
