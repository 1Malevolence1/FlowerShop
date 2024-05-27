package com.example.managerapp.client;

import java.util.List;
import java.util.Optional;

public interface CrudService<newObject, updateObject , modelObject, ID> {
    modelObject create(newObject object);

    void update(updateObject updateObject, Long id);

    void delete (ID id);

    List<modelObject> findAll();

    Optional<modelObject> find(ID id);

}
