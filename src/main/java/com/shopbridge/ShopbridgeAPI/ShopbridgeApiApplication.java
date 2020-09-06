package com.shopbridge.ShopbridgeAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@ComponentScan({ 
	"com.shopbridge.dao.spring", 
	"com.shopbridge.controller", 
	"com.shopbridge.services" })
@SpringBootApplication
public class ShopbridgeApiApplication extends SpringBootServletInitializer implements WebMvcConfigurer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ShopbridgeApiApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ShopbridgeApiApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			 System.out.println("   Let'adas inspect the beans provided by Spring Boot: ");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				//System.out.println(beanName); not needed
			}

			System.out.println("********** ShopbridgeApiApplication Running successfully ********* ");
		};
	}
	
	
}