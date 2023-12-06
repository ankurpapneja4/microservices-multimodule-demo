package com.example.demoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.example.demoapp.domain.configurationproperties")
public class ClientsApplication {

    public static void main(String[] args){
        SpringApplication.run(ClientsApplication.class);
    }
}
