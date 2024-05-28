package com.example.businesslogic.controler.flower;

import com.example.businesslogic.models.flower.suppliers.Supplier;

public interface ControllerHelper<T, E, ID> {

    void updateEntity(E payload, ID id);

    Supplier createEntity(T newEntity);
}
