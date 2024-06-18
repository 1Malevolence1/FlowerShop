package com.example.businesslogic.controler.flower;

public interface ControllerHelperImpl<T, E, Z,ID>  {
   void updateEntityReturnVoid(E payload, ID id);

   Z createEntity(T newEntity);

   void createEntityReturnVoid(T newEntity);
}
