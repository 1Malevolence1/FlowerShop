package com.example.businesslogic.serivce.flower;

import com.example.businesslogic.models.Flower;
import com.example.businesslogic.record.flower.NewFlowerPayload;
import com.example.businesslogic.record.flower.UpdateFlowerPayload;
import com.example.businesslogic.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FlowerService implements FlowerServiceImpl {


    private final FlowerRepository flowerRepository;

    @Autowired
    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    @Override
    public List<Flower> allFlowers() {
        return flowerRepository.findAll();
    }

    @Override
    public Optional<Flower> findFlower(Long id) {
        return flowerRepository.findById(id);
    }

    @Override
    @Transactional
    public Flower createFlower(String title, Integer price, Integer extraCharge, Integer accountingQuantity, Integer actualQuantity) {
        return flowerRepository.save(new Flower(
                null,
                title,
                price,
                extraCharge,
                accountingQuantity,
                actualQuantity));
    }


    @Override
    @Transactional
    public void updateFlower(Long id, UpdateFlowerPayload payload) {
        flowerRepository.findById(id).ifPresentOrElse(
                newDataForflower -> {
                    newDataForflower.setTitle(payload.title());
                    newDataForflower.setPrice(payload.price());
                    newDataForflower.setAccountingQuantity(payload.accountingQuantity());
                    newDataForflower.setActualQuantity(payload.actualQuantity());
                    newDataForflower.setExtraCharge(payload.extraCharge());
                }, () -> {
                    throw new NoSuchElementException();
                }
        );
    }

    @Override
    @Transactional
    public void deleteFlower(Long id) {
        flowerRepository.deleteById(id);
    }
}
