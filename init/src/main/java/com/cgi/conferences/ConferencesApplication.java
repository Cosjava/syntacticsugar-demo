package com.cgi.conferences;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableOpenApi
public class ConferencesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferencesApplication.class, args);
    }

}
