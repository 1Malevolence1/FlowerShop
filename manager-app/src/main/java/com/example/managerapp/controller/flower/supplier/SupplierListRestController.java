package com.example.managerapp.controller.flower.supplier;

import com.example.managerapp.client.flower.supplier.SupplierRestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main/suppliers/list")
public class SupplierListRestController {


    private final SupplierRestClientService supplierRestClientService;

    @Autowired
    public SupplierListRestController(SupplierRestClientService supplierRestClientService) {
        this.supplierRestClientService = supplierRestClientService;
    }


    @GetMapping()
    public String getSuppliersList(Model model){
        model.addAttribute("suppliers", supplierRestClientService.findAll());
        return "main/supplier/supplier_list_page";
    }
}
