package com.example.businesslogic.serivce.flower;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ManagerBaseDate<DtoNew, UpdateDto, Model> {

    List<Model> findAllEntity();

    Model findByName(String title);


    void saveEntityNotReturnObject(DtoNew object);
    void saveEntityNotReturnObject();

    Model saveEntityReturnObject(DtoNew dtoNew);
    Model saveEntityReturnObject();

    void deleteEntityById(Long id);

    void updateEntity(UpdateDto dtoUpdate, Long id);

    Model findById(Long id);

    @Query(value = "select count(*) from :table")
    int findCountAll(@Param("table") String nameTable);
}
