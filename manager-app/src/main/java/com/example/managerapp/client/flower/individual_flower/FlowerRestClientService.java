package com.example.managerapp.client.flower.individual_flower;


import com.example.managerapp.client.BadRequestException;
import com.example.managerapp.client.FlowerClientServiceImpl;
import com.example.managerapp.dto.flower.individual_flower.NewFlowerDTO;
import com.example.managerapp.dto.flower.individual_flower.UpdateFlowerDTO;
import com.example.managerapp.dto.flower.individual_flower.Flower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;


import java.util.List;
import java.util.Optional;

@Validated
public class FlowerRestClientService implements FlowerClientServiceImpl {

    private static final ParameterizedTypeReference<List<Flower>> FLOWER_TYPE_REFERENCE = new ParameterizedTypeReference<List<Flower>>() {
    };

    private final RestClient restClient;

    @Autowired
    public FlowerRestClientService(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public List<Flower> allFlowers() {
        return restClient.get().uri("/main/flowers/list").retrieve().body(FLOWER_TYPE_REFERENCE);
    }

    @Override
    public Optional<Flower> findFlower(Long id) {
      try {
          return Optional.ofNullable(restClient.get().uri("/main/flower/{flowerId}", id).retrieve().body(Flower.class));
      } catch (HttpClientErrorException.NotFound exception){
          throw exception;
      }
    }

    @Override
    public Flower createFlower(NewFlowerDTO payload) {
        try {
            return restClient.post().uri("/main/flowers/create").
                    contentType(MediaType.APPLICATION_JSON).body(payload).retrieve().body(Flower.class);
        }
        catch (HttpClientErrorException.BadRequest badRequestException) {
            ProblemDetail problemDetail = badRequestException.getResponseBodyAs(ProblemDetail.class);
            throw new BadRequestException((List<String>) problemDetail.getProperties().get("errors"));
        }
    }

    @Override
    public void updateFlower(Long id, UpdateFlowerDTO payload) {
        try {
            restClient.patch().uri("/main/flower/{flowerId}", id)
                    .contentType(MediaType.APPLICATION_JSON).body(payload)
                    .retrieve().toBodilessEntity();
        }  catch (HttpClientErrorException.BadRequest badRequestException) {
            ProblemDetail problemDetail = badRequestException.getResponseBodyAs(ProblemDetail.class);
            throw new BadRequestException((List<String>) problemDetail.getProperties().get("errors"));
        }
    }

    @Override
    public void deleteFlower(Long id) {
            try {
                restClient.delete().uri("/main/flower/{flowerId}", id).retrieve().toBodilessEntity();
            } catch (HttpClientErrorException.NotFound exception){
                throw exception;
            }
    }



}
