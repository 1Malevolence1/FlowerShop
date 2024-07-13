package com.example.businesslogic.dto.flowers.individual_flower;


import com.example.businesslogic.dto.inventory.InventoryDto;
import com.example.businesslogic.models.flower.inventory.Inventory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;


@Data
public class NewFlowerDTO {

      @NotBlank(message = "название не должно быть пустым")
      private String title;

      @PositiveOrZero(message = "цена должна быть больше или равно 0")
      private  Integer price;
      @PositiveOrZero(message = "наценка должна быть больше или равно 0")
      private  Integer extraCharge;

      private InventoryDto inventory;

    @NotBlank(message = """ 
            поле "Тип" не может быть пустым
            """)
      private String type;

    @NotBlank(message = """ 
            поле "Поставщик" не может быть пустым
            """)
    private String supplierName;

    public NewFlowerDTO(String title, Integer price, Integer extraCharge, String type, String supplierName, InventoryDto inventory) {
        this.title = title;
        this.price = checkObjectOnNullOtherwiseReturnZero(price);
        this.extraCharge = checkObjectOnNullOtherwiseReturnZero(extraCharge);
        this.type = type;
        this.supplierName = supplierName;
        this.inventory = inventory;
    }

    private Integer checkObjectOnNullOtherwiseReturnZero(Integer object){
        if(object == null) return 0;
        else return object;
    }
}

