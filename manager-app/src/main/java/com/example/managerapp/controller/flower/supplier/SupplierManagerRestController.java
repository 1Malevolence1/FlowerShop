package com.example.managerapp.controller.flower.supplier;


import com.example.managerapp.client.flower.supplier.SupplierRestClientService;
import com.example.managerapp.dto.flower.supplier.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("main/flowers/supplier/{supplierId:\\d+}/info")
public class SupplierManagerRestController {


    private final SupplierRestClientService supplierRestClientService;

    @Autowired
    public SupplierManagerRestController(SupplierRestClientService supplierRestClientService) {
        this.supplierRestClientService = supplierRestClientService;
    }


    @ModelAttribute("supplier")
    public Supplier supplier(@PathVariable("supplierId") Long id){
        return supplierRestClientService.find(id).orElseThrow(() -> new NoSuchElementException());
    }

}
