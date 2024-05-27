package com.example.businesslogic.controler.flower.supplier;


import com.example.businesslogic.dto.individual_flower.UpdateFlowerDTO;
import com.example.businesslogic.dto.supplier.UpdateSupplierDTO;
import com.example.businesslogic.models.flower.suppliers.Supplier;
import com.example.businesslogic.repository.ContactRepository;
import com.example.businesslogic.serivce.flower.supplier.ContactService;
import com.example.businesslogic.serivce.flower.supplier.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("main/flowers/supplier/{supplierId:\\d+}")
@RequiredArgsConstructor
public class SupplierManagerRestController {

    private final SupplierService supplierService;

    private final ContactRepository contactRepository;



    @ModelAttribute("supplier")
    public Supplier supplier(@PathVariable("supplierId") Long id){
        return supplierService.find(id);
    }

    @GetMapping()
    public Supplier getSupplier(@ModelAttribute("supplier") Supplier supplier) {
        return supplier;
    }

    @PatchMapping()
    public ResponseEntity<?> update(@PathVariable("supplierId") Long id,
                                    @Valid @RequestBody UpdateSupplierDTO payload,
                                    BindingResult bindingResult) throws BindException{

        if(bindingResult.hasErrors()){
            if(bindingResult instanceof BindException bindException){
                throw bindException;
            } else throw new BindException(bindingResult);
        } else {
            supplierService.update(payload, id);

        }
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping()
    public ResponseEntity<Void> delete(@PathVariable(name = "supplierId") Long id){
         supplierService.delete(id);
         return ResponseEntity.noContent().build();
    }
}

