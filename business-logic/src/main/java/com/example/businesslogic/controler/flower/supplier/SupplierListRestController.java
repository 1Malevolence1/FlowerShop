package com.example.businesslogic.controler.flower.supplier;


import com.example.businesslogic.models.flower.suppliers.Supplier;
import com.example.businesslogic.serivce.flower.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("main/flowers/supplier/list")
public class SupplierListRestController {

    private final SupplierService supplierService;


    @Autowired
    public SupplierListRestController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    
    @GetMapping()
    public List<Supplier> getListSupplier(){
       return supplierService.findAll();
    }
}
