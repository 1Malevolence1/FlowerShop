package com.example.businesslogic.controler.flower;

import com.example.businesslogic.models.flower.suppliers.Supplier;


public abstract  class ControllerHelper<T, E, Z,ID> {


    protected void updateEntityReturnVoid(E payload, ID id) {
        System.out.println("Ты забыл переопределить меня");
    }

   protected Z createEntity(T newEntity) {
       System.out.println("Ты забыл переопределить меня");
        return null;
    }

    protected void createEntityReturnVoid(T newEntity) {
        System.out.println("Ты забыл переопределить меня");
    }
}
