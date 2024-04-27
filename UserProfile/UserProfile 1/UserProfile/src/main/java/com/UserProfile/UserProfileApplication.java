package com.UserProfile;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;





@SpringBootApplication

@EnableJpaRepositories("com.UserProfile.repository")
@EnableDiscoveryClient(autoRegister=true)
@EnableFeignClients
@ComponentScan(basePackages = {"com.*"})
public class UserProfileApplication {
     
	

	public static void main(String[] args) {
		SpringApplication.run(UserProfileApplication.class, args);
	}

    

}