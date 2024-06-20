package com.example.businesslogic.controler.flower.type_flower;

import com.example.businesslogic.dto.type_flower.NewTypeFlowerDTO;
import com.example.businesslogic.models.flower.TypeFlower;
import com.example.businesslogic.serivce.flower.type_flower.TypeFlowerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("main/type_flower")
@RequiredArgsConstructor
@Slf4j
public class TypeFlowerController {

    private final TypeFlowerService typeFlowerService;


    @GetMapping("list")
    public List<TypeFlower> getAllTypeFlower(){
        log.info("метод начался");
        return typeFlowerService.findAllEntityFormBaseDate();
    }



    @DeleteMapping("delete/{typeId}")
    public ResponseEntity<Void> deleteTypeFlower(@PathVariable ("typeId") Long id){
        typeFlowerService.deleteEntityFromBaseDateById(id);
        return ResponseEntity.noContent().build();
    }
}
