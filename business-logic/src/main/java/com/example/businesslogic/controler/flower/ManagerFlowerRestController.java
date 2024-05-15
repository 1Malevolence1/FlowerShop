package com.example.businesslogic.controler.flower;


import com.example.businesslogic.models.Flower;
import com.example.businesslogic.record.flower.UpdateFlowerPayload;
import com.example.businesslogic.serivce.flower.FlowerService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.NoSuchElementException;

@RestController
@RequestMapping("main/flower/{flowerId:\\d+}")
@Slf4j
public class ManagerFlowerRestController {
    private final FlowerService flowerService;

    @Autowired
    public ManagerFlowerRestController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @ModelAttribute("flower")
    public Flower getFlower(@PathVariable(name = "flowerId") Long id) {
        return flowerService.findFlower(id).orElseThrow(() -> new NoSuchElementException("Цветок с id %d не найден".formatted(id)));
    }


    @GetMapping()
    public Flower getFlower(@ModelAttribute("flower") Flower flower){
        return flower;
    }

    @PatchMapping()
    public ResponseEntity<?> updateDateFlower(@PathVariable(name = "flowerId") Long id,
                                              @Valid @RequestBody UpdateFlowerPayload payload,
                                              BindingResult bindingResult) throws BindException {

        if(bindingResult.hasErrors()){
            if(bindingResult instanceof BindException bindException){
                throw bindException;
            } else throw new BindException(bindingResult);
        } else {
            flowerService.updateFlower(id, payload);
            log.info("Обновлены данные цвтека с id: {}", id);
        }
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping()
    public ResponseEntity<Void> deleteFlower(@PathVariable(name = "flowerId") Long id){
        flowerService.deleteFlower(id);
        log.info("удалён цветок c id: {}: ", id);
        return ResponseEntity.noContent().build();
    }



    /*
    Когда возникает исключение NoSuchElementException, вызывается этот метод, который возвращает объект ResponseEntity<ProblemDetail>.
    Этот объект содержит информацию о статусе HTTP (в данном случае HttpStatus.NOT_FOUND) и детальное сообщение об ошибке,
     которое было получено из исходного исключения.
   */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ProblemDetail> handlerNoSuchElementException(NoSuchElementException noSuchElementException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, noSuchElementException.getMessage()));
    }
}
