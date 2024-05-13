package com.example.managerapp.client;


import com.example.managerapp.exeption.BadRequestException;
import com.example.managerapp.record.flower.Flower;
import com.example.managerapp.record.flower.NewFlowerPayload;
import com.example.managerapp.record.flower.UpdateFlowerPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.web.client.HttpClientErrorException;
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
    public Flower createFlower(String title, Integer price, Integer extraCharge, Integer accountingQuantity, Integer actualQuantity) {
        try {
            return restClient.post().uri("/main/flowers/create").contentType(MediaType.APPLICATION_JSON).body(
                    new NewFlowerPayload(
                            title,
                            price,
                            extraCharge,
                            accountingQuantity,
                            actualQuantity
                    )).retrieve().body(Flower.class);
        }
        catch (HttpClientErrorException.BadRequest badRequestException) {
            ProblemDetail problemDetail = badRequestException.getResponseBodyAs(ProblemDetail.class);
            throw new BadRequestException((List<String>) problemDetail.getProperties().get("errors"));
        }
    }

    @Override
    public void updateFlower(Long id, UpdateFlowerPayload payload) {

    }

    @Override
    public void deleteFlower(Long id) {

    }
}
