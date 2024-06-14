package com.example.businesslogic.controler.flower.individual_flower;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class FlowersListRestControllerTest {


    @Autowired
    MockMvc mockMvc;


    @Test
    @Sql("/sql/flowers.sql")
    void getAllFlowers_ReturnsFlowersList() throws Exception {

        //given - дано
        var requestBuilder = MockMvcRequestBuilders.get("main/flowers/list");

        // when - когда

        mockMvc.perform(requestBuilder)
                // then - тогда
                .andDo(print()).andExpectAll(
                        status().isOk(),
                        content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON),
                        content().json(
                                """
                                        [
                                        {"id":1,"title":"Rose","price":100,"extraCharge":20,"inventory":{"id":1,"quantity":50},"typeFlower":{"id":1,"name":"Perennial"},"suppliers":{"id":1,"name":"Supplier A","location":"City A"}},
                                        {"id":2,"title":"Tulip","price":70,"extraCharge":15,"inventory":{"id":2,"quantity":100},"typeFlower":{"id":2,"name":"Annual"},"suppliers":{"id":2,"name":"Supplier B","location":"City B"}},
                                        {"id":3,"title":"Lily","price":120,"extraCharge":25,"inventory":{"id":3,"quantity":30},"typeFlower":{"id":3,"name":"Perennial"},"suppliers":{"id":3,"name":"Supplier C","location":"City C"}}
                                        """
                        )
                );
    }
}