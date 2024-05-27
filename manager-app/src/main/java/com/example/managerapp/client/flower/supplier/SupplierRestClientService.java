package com.example.managerapp.client.flower.supplier;

import com.example.managerapp.client.BadRequestException;
import com.example.managerapp.client.CrudService;
import com.example.managerapp.dto.flower.supplier.NewSupplierDTO;
import com.example.managerapp.dto.flower.supplier.Supplier;
import com.example.managerapp.dto.flower.supplier.UpdateSupplierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

public class SupplierRestClientService implements CrudService<NewSupplierDTO, UpdateSupplierDTO, Supplier, Long> {

    private static ParameterizedTypeReference<List<Supplier>> SUPPLIER_TYPE_REFERENCE = new ParameterizedTypeReference<List<Supplier>>() {
    };

    private RestClient restClient;

    @Autowired
    public SupplierRestClientService(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public Supplier create(NewSupplierDTO object) {
        try {
            return restClient.post().uri("/main/flowers/supplier/create").contentType(MediaType.APPLICATION_JSON).body(object)
                    .retrieve().body(Supplier.class);
        } catch (HttpClientErrorException.BadRequest exception){
            ProblemDetail problemDetail = exception.getResponseBodyAs(ProblemDetail.class);
            throw new BadRequestException((List<String>) problemDetail.getProperties().get("errors"));
        }
    }

    @Override
    public void update(UpdateSupplierDTO updateSupplierDTO, Long id) {
        try {
            restClient.patch().uri("main/flowers/supplier/{supplierId}", id).contentType(MediaType.APPLICATION_JSON).body(updateSupplierDTO).retrieve().toBodilessEntity();
        } catch (HttpClientErrorException.BadRequest exception){
            ProblemDetail problemDetail = exception.getResponseBodyAs(ProblemDetail.class);
            throw new BadRequestException((List<String>) problemDetail.getProperties().get("errors"));
        }
    }

    @Override
    public void delete(Long id) {
        restClient.delete().uri("main/flowers/supplier/{supplierId}", id).retrieve().toBodilessEntity();
    }

    @Override
    public List<Supplier> findAll() {
        return restClient.get().uri("/main/flowers/supplier/list").retrieve().body(SUPPLIER_TYPE_REFERENCE);
    }

    @Override
    public Optional<Supplier> find(Long id) {
        try {
            return Optional.ofNullable(restClient.get().uri("/main/flowers/supplier/{supplierId}", id).retrieve().body(Supplier.class));
        } catch (HttpClientErrorException.NotFound exception) {
            throw exception;
        }
    }
}

