package com.example.businesslogic.controler.flower.type_flower;


import com.example.businesslogic.dto.type_flower.NewTypeFlowerDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("main/type_flower")
@RequiredArgsConstructor
@Slf4j
public class TypeFlowerCreateController {

    private final TypeFlowerAbstractControllerHelper typeFlowerControllerHelper;

    @PostMapping("create")
    public ResponseEntity<?> createTypeFlower(@Valid @RequestBody NewTypeFlowerDTO dto, BindingResult bindingResult) throws BindException {
        if(bindingResult.hasErrors()){
            if(bindingResult instanceof BindException bindException){
                throw bindException;
            }
            else {
                throw  new BindException(bindingResult);
            }
        }
        typeFlowerControllerHelper.checkSaveEntityBaseDateNotReturnObject(dto);
        log.info("Всё прошло успешно");
        log.info("Загрузили {}", dto);
        return ResponseEntity.noContent().build();
    }

}
