package com.demo.jpa.openapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@ComponentScan(basePackages={"com.demo.jpa.openapi"})
@OpenAPIDefinition(info=@Info(title="Playes Information"))
public class PlayersApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayersApplication.class, args);
	}

}
