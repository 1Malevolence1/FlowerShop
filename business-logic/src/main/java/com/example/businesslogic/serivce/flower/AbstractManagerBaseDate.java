package com.example.businesslogic.serivce.flower;

import com.example.businesslogic.controler.flower.individual_flower.CountAllFlower;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

public class  AbstractManagerBaseDate<DtoNew, UpdateDto, Model> implements ManagerBaseDate<DtoNew, UpdateDto, Model>{

    private JpaRepository<Model, Long> repository;


    public AbstractManagerBaseDate(JpaRepository<Model, Long> repository) {
        this.repository = repository;
    }

    @Override
    public List<Model> findAllEntity() {
        return repository.findAll();
    }

    @Override
    public Model findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Не удалось найти данный объект c id: " + id));
    }


    @Override
    public Model findByName(String title) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    public CountAllFlower findCountAll() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    @Transactional
    public void saveEntityNotReturnObject(DtoNew object) {
            throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    @Transactional
    public void saveEntityNotReturnObject() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    @Transactional
    public Model saveEntityReturnObject(DtoNew dtoNew) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    @Transactional
    public Model saveEntityReturnObject() {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    @Transactional
    public void deleteEntityById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateEntity(UpdateDto dtoUpdate, Long id) {
        throw new UnsupportedOperationException("Method not implemented");
    }


}
