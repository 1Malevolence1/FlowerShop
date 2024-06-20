package com.example.businesslogic.controler.flower.supplier;


import com.example.businesslogic.dto.individual_flower.supplier.NewSupplierDTO;
import com.example.businesslogic.models.flower.suppliers.Supplier;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequestMapping("main/flowers/supplier/create")
@Slf4j
@RequiredArgsConstructor
public class SupplierCreateRestController
{


    private final SupplierAbstractControllerHelper supplierControllerHelper;




    @PostMapping()
    private ResponseEntity<?> createSuppler(@Valid @RequestBody NewSupplierDTO dto, BindingResult bindingResult,
                                            UriComponentsBuilder uriComponentsBuilder) throws BindException {

        if(bindingResult.hasErrors()){
            if(bindingResult instanceof BindException bindException){
                throw bindException;
            } else {
                throw new BindException(bindingResult);
            }
        }
        Supplier suppliers =  supplierControllerHelper.checkSaveEntityBaseDateReturnObject(dto);
        return ResponseEntity.created(uriComponentsBuilder.replacePath("main/flowers/suppliers/{supplierId}/supplier_info").build(Map.of("supplierId", suppliers.getId()))).body(suppliers);
    }
}
