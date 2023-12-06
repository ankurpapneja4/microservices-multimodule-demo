package com.example.demoapp;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.example.demoapp")
@ConfigurationPropertiesScan("com.example.demoapp.domain.configurationproperties")
public class ClientsApplication {

}
