package com.example.Springonlinestorenew;

import com.example.Springonlinestorenew.uploads.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringOnlineStoreNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOnlineStoreNewApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}


}
