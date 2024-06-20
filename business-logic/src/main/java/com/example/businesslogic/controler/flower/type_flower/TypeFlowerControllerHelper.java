package com.example.businesslogic.controler.flower.type_flower;


import com.example.businesslogic.controler.flower.ControllerHelper;
import com.example.businesslogic.dto.type_flower.NewTypeFlowerDTO;
import com.example.businesslogic.models.flower.TypeFlower;
import com.example.businesslogic.models.flower.suppliers.Supplier;
import com.example.businesslogic.serivce.flower.AbstractManagerBaseDate;
import com.example.businesslogic.serivce.flower.individual_flower.FlowerService;
import com.example.businesslogic.serivce.flower.type_flower.TypeFlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class TypeFlowerControllerHelper extends ControllerHelper<NewTypeFlowerDTO, Void, TypeFlower> {

   @Autowired
    public TypeFlowerControllerHelper(TypeFlowerService service) {
        super(service);
    }
}
