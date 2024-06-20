package com.example.businesslogic.controler.flower;

import com.example.businesslogic.serivce.flower.AbstractManagerBaseDate;
import org.springframework.dao.DataIntegrityViolationException;


public abstract class ControllerHelper<NewDto, UpdateDto, Model> implements ControllerHelperImpl<NewDto, UpdateDto, Model>{


    private AbstractManagerBaseDate<NewDto, UpdateDto, Model> service;

    public ControllerHelper(AbstractManagerBaseDate<NewDto, UpdateDto, Model> service) {
        this.service = service;
    }

    @Override
    public void checkUpdateEntityReturnVoid(UpdateDto payload, Long id) {
        try {
            service.updateEntityFromBaseDate(payload, id);
        } catch (DataIntegrityViolationException exception) {
            throw new IllegalArgumentException("Тип с таким названием уже сущестует", exception);
        }
    }

    @Override
    public Model checkSaveEntityBaseDateReturnObject(NewDto newEntity) {
        try {
            return service.saveEntityFromBaseDateReturnObject(newEntity);
        } catch (DataIntegrityViolationException exception) {
            throw new IllegalArgumentException("Тип с таким названием уже сущестует", exception);
        }
    }

    @Override
    public void checkSaveEntityBaseDateNotReturnObject(NewDto newEntity) {
        try {
            service.saveEntityFromBaseDateNotReturnObject(newEntity);
        } catch (DataIntegrityViolationException exception) {
            throw new IllegalArgumentException("Тип с таким названием уже сущестует", exception);
        }
    }
}
