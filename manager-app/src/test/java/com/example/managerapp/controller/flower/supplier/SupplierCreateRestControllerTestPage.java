package com.example.managerapp.controller.flower.supplier;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@SpringBootTest
@AutoConfigureMockMvc
class SupplierCreateRestControllerTestPage {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getCreateSupplierPage_ReturnSupplierCretePage() throws Exception {

        // given - дано
        var requestBuild = MockMvcRequestBuilders.get("/main/flowers/supplier/create");

        // when - когда

        mockMvc.perform(requestBuild)
        // then - тогда

                .andDo(print()).andExpectAll(
                        status().isOk(), view().name("main/supplier/supplier_create")
                );

    }
}