package com.example.managerapp.client.flower.type_flower;


import com.example.managerapp.client.BadRequestException;
import com.example.managerapp.dto.flower.individual_flower.Flower;
import com.example.managerapp.dto.flower.type_flower.NewTypeFlowerDTO;
import com.example.managerapp.dto.flower.type_flower.TypeFlower;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TypeFlowerClientService {

    private static final ParameterizedTypeReference<List<TypeFlower>> FLOWER_TYPE_REFERENCE = new ParameterizedTypeReference<List<TypeFlower>>() {
    };
    private final RestClient restClient;

    @Autowired
    public TypeFlowerClientService(RestClient restClient) {
        this.restClient = restClient;
    }



    public List<TypeFlower> allTypeFlower(){
            return restClient.get().uri("/main/type_flower/list").retrieve().body(FLOWER_TYPE_REFERENCE);
        }

    public void crateType(NewTypeFlowerDTO dto){
        log.info("отправили запрос на создания типа");
       try {
           restClient.post().uri("/main/type_flower/create").contentType(MediaType.APPLICATION_JSON).body(dto).retrieve().toBodilessEntity();
       } catch (HttpClientErrorException.BadRequest exception){
           ProblemDetail problemDetail = exception.getResponseBodyAs(ProblemDetail.class);
           throw new BadRequestException((List<String>) problemDetail.getProperties().get("errors"));

       }
    }

    public List<TypeFlower> showTypeFlower(){
       return allTypeFlower();
    }

    public void deleteType(Long id){
        restClient.delete().uri("/main/type_flower/delete/%d".formatted(id)).retrieve().toBodilessEntity();
    }
}
