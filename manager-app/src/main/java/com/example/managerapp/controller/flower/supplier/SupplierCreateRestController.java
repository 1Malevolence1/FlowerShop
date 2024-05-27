package com.example.managerapp.controller.flower.supplier;

import com.example.managerapp.client.BadRequestException;
import com.example.managerapp.client.flower.supplier.SupplierRestClientService;
import com.example.managerapp.dto.flower.supplier.NewSupplierDTO;
import com.example.managerapp.dto.flower.supplier.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main/flowers/supplier/create")
@Slf4j
public class SupplierCreateRestController {

    private final SupplierRestClientService supplierRestClientService;

    @Autowired
    public SupplierCreateRestController(SupplierRestClientService supplierRestClientService) {
        this.supplierRestClientService = supplierRestClientService;
    }


    @GetMapping()
    public String getCreateSupplierPage( ){
        return "main/supplier/supplier_create";
    }
    @PostMapping
    private String createSupplier(NewSupplierDTO payload, Model model){
        try {

            log.info("{}", payload);
            Supplier supplier = supplierRestClientService.create(payload);
            return "redirect:/main/flowers/supplier/%d/info".formatted(supplier.getId());

        } catch (BadRequestException exception){
            model.addAttribute("payload", payload);
            model.addAttribute("errors", exception.getErrors());
            return "main/supplier/supplier_create";
        }
    }
}
