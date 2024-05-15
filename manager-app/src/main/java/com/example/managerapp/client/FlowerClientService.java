package com.example.managerapp.client;


import com.example.managerapp.DTO.NewFlowerDTO;
import com.example.managerapp.DTO.UpdateFlowerDTO;
import com.example.managerapp.record.flower.Flower;
import com.example.managerapp.record.flower.UpdateFlowerPayload;
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

    }

    @Override
    public void deleteFlower(Long id) {

    }
}
