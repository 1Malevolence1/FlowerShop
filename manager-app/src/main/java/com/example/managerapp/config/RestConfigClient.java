package com.example.managerapp.config;

import com.example.managerapp.client.flower.individual_flower.FlowerRestClientService;
import com.example.managerapp.client.flower.supplier.SupplierRestClientService;
import com.example.managerapp.client.flower.supply_flower.SupplyFlowerRestClient;
import com.example.managerapp.client.flower.type_flower.TypeFlowerClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;


@Configuration
@Slf4j
public class  RestConfigClient {

    @Value("${api.path}")
    private String uri;


    @Bean
    public RestClient restClient(String uri){
        return RestClient.builder().baseUrl(uri).build();
    }


    @Bean
    public TypeFlowerClientService typeFlowerClientService(){
        return new TypeFlowerClientService(restClient(uri));
    }

    @Bean
    public FlowerRestClientService flowerClientService(@Value("${api.path}") String uri) {
        log.info("URI сервера: {}", uri);
        return new FlowerRestClientService(restClient(uri));
    }


    @Bean
    public SupplyFlowerRestClient supplyFlowerRestClient(@Value("${api.path}") String uri) {

        return new SupplyFlowerRestClient(restClient(uri));
    }

    @Bean
    public SupplierRestClientService supplierRestClientService(@Value("${api.path}") String uri) {
        return new SupplierRestClientService(restClient(uri));
    }
}
