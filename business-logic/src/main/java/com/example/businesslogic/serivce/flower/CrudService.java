package com.example.businesslogic.serivce.flower;

import java.util.List;

public interface CrudService<newObject, updateObject , modelObject, ID> {
    void crate(newObject object);

    void update(updateObject updateObject);

    void delete (ID id);

    List<modelObject> findAll();

    modelObject find(ID id);
}
