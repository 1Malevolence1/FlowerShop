package com.example.managerapp.controller.flower.supplier;


import com.example.managerapp.client.BadRequestException;
import com.example.managerapp.client.flower.supplier.SupplierRestClientService;
import com.example.managerapp.dto.flower.supplier.Supplier;
import com.example.managerapp.dto.flower.supplier.UpdateSupplierDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("main/flowers/supplier/{supplierId:\\d+}/info")
@Slf4j
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


    @GetMapping()
    public String getSupplierInfoPage(Model module, @ModelAttribute("supplier") Supplier supplier ) {
            log.info("{}", supplier);
            module.addAttribute("supplier", supplier);
            return "main/supplier/supplier_info";
    }


    @GetMapping("update")
    public String getPageUpdateSupplier(){
        return "main/supplier/supplier_update";
    }
    @PostMapping("update")
    public String updateDataFlower(@ModelAttribute(name = "supplier", binding = false) Supplier supplier,
                                   UpdateSupplierDTO updateSupplierDTO,
                                   Model model) {
        try {

            supplierRestClientService.update(updateSupplierDTO, supplier.getId());

            return "redirect:/main/flowers/supplier/%d/info".formatted(supplier.getId());

        } catch (BadRequestException badRequestException) {
            model.addAttribute("payload", updateSupplierDTO);
            model.addAttribute("errors", badRequestException.getErrors());
            return "main/supplier/supplier_update";
        }
    }

    @PostMapping("delete")
    public String deleteSupplier(@PathVariable("supplierId") Long id){
        supplierRestClientService.delete(id);
        return "redirect:/main/suppliers/list";
    }
}
