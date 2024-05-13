package com.example.managerapp.config;

import com.example.managerapp.client.FlowerClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import javax.validation.Valid;

@Configuration
@Slf4j
public class RestConfigClient {

    @Bean
    public FlowerClientService flowerClientService(@Value("${api.path}") String uri) {
        log.info("URI сервера: {}", uri);
        return new FlowerClientService(RestClient.builder().baseUrl(uri).build());
    }
}
