package com.example.businesslogic.serivce.flower;

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
    public List<Model> findAllEntityFormBaseDate() {
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
    @Transactional
    public void saveEntityFromBaseDateNotReturnObject(DtoNew object) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    @Transactional
    public Model saveEntityFromBaseDateReturnObject(DtoNew dtoNew) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    @Transactional
    public void deleteEntityFromBaseDateById(Long id) {
        throw new UnsupportedOperationException("Method not implemented");
    }

    @Override
    @Transactional
    public void updateEntityFromBaseDate(UpdateDto dtoUpdate, Long id) {
        throw new UnsupportedOperationException("Method not implemented");
    }


}
