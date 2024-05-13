package com.example.managerapp.client;

import com.example.managerapp.flower.Flower;
import com.example.managerapp.flower.NewFlowerPayload;
import com.example.managerapp.flower.UpdateFlowerPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

public class FlowerClientService implements FlowerClientServiceImpl {

    private static final ParameterizedTypeReference<List<Flower>> FLOWER_TYPE_REFERENCE = new ParameterizedTypeReference<List<Flower>>() {
    };

    private final RestClient restClient;

    @Autowired
    public FlowerClientService(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<Flower> allFlowers() {
        return restClient.get().uri("/main/flowers/list").retrieve().body(FLOWER_TYPE_REFERENCE);
    }

    @Override
    public Optional<Flower> findFlower(Long id) {
        return Optional.empty();
    }

    @Override
    public Flower createFlower(NewFlowerPayload newFlowerPayload) {
        return null;
    }

    @Override
    public void updateFlower(Long id, UpdateFlowerPayload payload) {

    }

    @Override
    public void deleteFlower(Long id) {

    }
}
