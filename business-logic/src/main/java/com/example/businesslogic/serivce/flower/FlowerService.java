package com.example.businesslogic.serivce.flower;

import com.example.businesslogic.models.Flower;
import com.example.businesslogic.record.flower.NewFlowerPayload;
import com.example.businesslogic.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Iterable<Flower> allFlower() {
        return flowerRepository.findAll();
    }

    @Override
    public Optional<Flower> findFlower(Long id) {
        return flowerRepository.findById(id);
    }

    @Override
    public Flower createFlower(NewFlowerPayload payload) {
        return flowerRepository.save(new Flower(
                null,
                payload.title(),
                payload.price(),
                payload.extraCharge(),
                payload.accountingQuantity(),
                payload.actualQuantity()));
    }

    @Override
    public void deleteFlower(Long id) {

    }
}
