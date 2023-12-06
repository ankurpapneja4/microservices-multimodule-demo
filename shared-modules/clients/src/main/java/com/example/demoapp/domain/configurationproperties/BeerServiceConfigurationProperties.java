package com.example.demoapp.domain.configurationproperties;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "microservices.beer-microservice.config" )
public record BeerServiceConfigurationProperties(String hostname, Integer port, String servicePath) {

    public String absoluteServiceURL() {
        return String.format("http://%s:%d%s/",hostname,port,servicePath); }

}
