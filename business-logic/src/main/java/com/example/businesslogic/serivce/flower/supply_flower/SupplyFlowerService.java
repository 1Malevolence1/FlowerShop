package com.example.businesslogic.serivce.flower.supply_flower;


import com.example.businesslogic.dto.supply_flower.AddFlowerSupplyDTO;
import com.example.businesslogic.serivce.flower.individual_flower.FlowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class SupplyFlowerService {

    private final FlowerService flowerService;

    @Autowired
    public SupplyFlowerService(FlowerService flowerService) {
        this.flowerService = flowerService;
    }


    /*@Transactional
    public void sumFlower(AddFlowerSupplyDTO dto){
        flowerService.findById(dto.getFlowerId()).ifPresentOrElse(flowerUpdate -> {
            flowerUpdate.getInventory().setActualQuantity(flowerUpdate.getInventory().getActualQuantity() + dto.getAddedQuantity());
            flowerUpdate.getInventory().setAccountingQuantity(flowerUpdate.getInventory().getAccountingQuantity() + dto.getAddedQuantity());
        }, () -> new NoSuchFieldException());
        log.info("Цветы добавлены");
    }

    @Transactional
    public void deductFlower(AddFlowerSupplyDTO dto){
        flowerService.find(dto.getFlowerId()).ifPresentOrElse(flowerUpdate -> {
            flowerUpdate.getInventory().setActualQuantity(flowerUpdate.getInventory().getActualQuantity() - dto.getAddedQuantity());
        }, () -> new NoSuchFieldException());
        log.info("Цветы отняли");
    }*/
}
