package com.example.managerapp.client;

import com.example.managerapp.DTO.supply_flower.AddFlowerSupplyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;


public class SupplyFlowerRestClient {

    private final RestClient restClient;


    @Autowired
    public SupplyFlowerRestClient(RestClient restClient) {
        this.restClient = restClient;
    }


    public void sumFlowerSupply(Long id, Integer addedQuantity){
        restClient.patch().uri("/main/supply_flower/sum").
                contentType(MediaType.APPLICATION_JSON).
                body(new AddFlowerSupplyDTO(id, addedQuantity)).retrieve().toBodilessEntity();
    }

    public void deductFlowerSupply(Long id, Integer addedQuantity){
        restClient.patch().uri("/main/supply_flower/deduct").
                contentType(MediaType.APPLICATION_JSON).
                body(new AddFlowerSupplyDTO(id, addedQuantity)).retrieve().toBodilessEntity();
    }
}
