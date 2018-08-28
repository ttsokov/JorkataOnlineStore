package org.georgi.shop.application;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.georgi.shop.controller")
public class ShopServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopServerApplication.class, args);
	}

    @Bean
    public ModelMapper modelMapper() {
	    return new ModelMapper();
    }
}
