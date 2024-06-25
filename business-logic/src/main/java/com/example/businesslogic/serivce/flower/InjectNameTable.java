/*
package com.example.businesslogic.serivce.flower;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class InjectNameTable {

    @SneakyThrows
    public String getAnnotationTableName(Object t)  {
        Class<?> object = t.getClass();
        if(!object.isAnnotationPresent(Entity.class)){
            throw new Exception("Класс " + object.getName() + "не обладает аннотацией entity");
        }
        else {
            Table table = object.getAnnotation(Table.class);
            String className = object.getSimpleName();
            String tableParameterName = table.name();
            if(tableParameterName.isEmpty()) return className.substring(0,1).toLowerCase() + className.substring(1);
            else return tableParameterName;
        }
    }
}
*/
