package com.example.managerapp.config;

import com.example.managerapp.client.flower.individual_flower.FlowerClientService;
import com.example.managerapp.client.flower.supply_flower.SupplyFlowerRestClient;
import com.example.managerapp.client.flower.type_flower.TypeFlowerClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;


@Configuration
@Slf4j
public class RestConfigClient {



    @Bean
    public TypeFlowerClientService typeFlowerClientService(@Value("${api.path}") String uri){
        return new TypeFlowerClientService(RestClient.builder().baseUrl(uri).build());
    }

    @Bean
    public FlowerClientService flowerClientService(@Value("${api.path}") String uri) {
        log.info("URI сервера: {}", uri);
        return new FlowerClientService(RestClient.builder().baseUrl(uri).build());
    }


    @Bean
    public SupplyFlowerRestClient supplyFlowerRestClient(@Value("${api.path}") String uri) {
        log.info("URI сервера: {}", uri);
        return new SupplyFlowerRestClient(RestClient.builder().baseUrl(uri).build());
    }
}
