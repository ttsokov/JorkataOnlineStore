package org.georgi.shop.application;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EntityScan(basePackages = "org.georgi.shop.model")
@ComponentScan(basePackages = { "org.georgi.shop.controller",
								"org.georgi.shop.service",
								"org.georgi.shop.security"})
@EnableJpaRepositories(basePackages = "org.georgi.shop.repository")
public class ShopServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopServerApplication.class, args);
	}

    @Bean
    public ModelMapper modelMapper() {
	    return new ModelMapper();
    }

    @Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
