package com.example.managerapp.controller.flower.supplier;

import com.example.managerapp.client.BadRequestException;
import com.example.managerapp.client.flower.supplier.SupplierRestClientService;
import com.example.managerapp.dto.flower.supplier.NewSupplierDTO;
import com.example.managerapp.dto.flower.supplier.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ConcurrentModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@DisplayName("модульные тесты SupplierCreateRestController")
class SupplierCreateRestControllerTest {

    @Mock
    SupplierRestClientService restClientService;
    @InjectMocks
    SupplierCreateRestController controller;


    @Test
    @DisplayName("createSupplier создаст нового поставщика и перенаправит пльзователя на подробную странцу о паставищка")
    void createSupplier_RequestIsValid_ReturnsRedirectionToSupplierInfoPage() {

        // given - дано. блок с исходным состоянием системы
        var payload = new NewSupplierDTO("ООО РОЗА", "Пятигорск", "Хороший адрес");
       // var model = Mockito.mock(Model.class);
        var model = new ConcurrentModel();


        //   doReturn(new Supplier(1L, "ООО РОЗА", "Пятигорск", "Хороший адрес")) - ожидается объект с этими данным
        doReturn(new Supplier(1L, "ООО РОЗА", "Пятигорск", "Хороший адрес"))
                .when(restClientService).create(new NewSupplierDTO("ООО РОЗА", "Пятигорск", "Хороший адрес"));

        //doReturn -  указывает, что должно быть возвращено при вызове метода mock-объекта.
        // when - когда.  блок с обращением к тестируемому коду


       var result =  controller.createSupplier(payload, model);

        // then тогда. блок с проверкой полученного результата

      assertEquals("redirect:/main/flowers/supplier/1/info", result);

        // Проверка, что метод create был вызван с ожидаемым объектом NewSupplierDTO
      verify(restClientService).create(new NewSupplierDTO("ООО РОЗА", "Пятигорск", "Хороший адрес"));

        // Проверка, что никаких других методов на restClientService не вызывалось
      verifyNoMoreInteractions(restClientService);
    }


    @Test
    @DisplayName("createSupplier вернёт страницу с ошибкой, елси запрос не валидный")
    void crateSupplier_RequestIsInvalid_ReturnSupplierFormWithErrors(){

        // given

        var payload = new NewSupplierDTO("    ", "     ", null);
        var model = new ConcurrentModel();

        doThrow(new BadRequestException(List.of("Ошибка 1", "Ошибка 2"))).when(restClientService).create(new NewSupplierDTO("    ", "     ", null));


        // when
        var result = controller.createSupplier(payload, model);
        // then

        assertEquals("main/supplier/supplier_create", result);
        assertEquals(payload, model.getAttribute("payload"));
        assertEquals((List.of("Ошибка 1", "Ошибка 2")), model.getAttribute("errors"));

        verify(restClientService).create(new NewSupplierDTO("    ", "     ", null));
        verifyNoMoreInteractions(restClientService);

    }

}