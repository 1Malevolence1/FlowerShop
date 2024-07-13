package com.example.businesslogic.controler.flower;

public interface ControllerHelperImpl<DtoNew, DtoUpdate, Model> {
   void checkUpdateEntityReturnVoid(DtoUpdate payload, Long id);

   Model checkSaveEntityBaseDateReturnObject(DtoNew newEntity);
   void checkSaveEntityBaseDateNotReturnObject(DtoNew newEntity);

}
