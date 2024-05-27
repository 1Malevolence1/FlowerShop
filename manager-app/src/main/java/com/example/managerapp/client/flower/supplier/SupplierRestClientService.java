package com.example.managerapp.client.flower.supplier;

import com.example.managerapp.client.CrudService;
import com.example.managerapp.dto.flower.supplier.NewSupplierDTO;
import com.example.managerapp.dto.flower.supplier.Supplier;
import com.example.managerapp.dto.flower.supplier.UpdateSupplierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
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
        return null;
    }

    @Override
    public void update(UpdateSupplierDTO updateSupplierDTO, Long id) {

    }

    @Override
    public void delete(Long id) {

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

