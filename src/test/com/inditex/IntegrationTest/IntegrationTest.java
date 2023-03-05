package com.inditex.IntegrationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.inditex.application.service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@SqlGroup({
        @Sql({ "/drop_schema.sql", "/create_schema.sql" }),
        @Sql("/insert_data.sql")
})
class IntegrationTest {

    @Autowired
    private PriceService repository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void inditex_test1() throws Exception {

        this.mockMvc.perform(get("/api/prices/{brandId}/{productId}/{date}", 1, 35455, "2020-06-14 10:00:00"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].brandId").value(1))
                .andExpect(jsonPath("$[0].startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$[0].endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[0].priceList").value(1))
                .andExpect(jsonPath("$[0].productId").value(35455))
                .andExpect(jsonPath("$[0].price").value(35.50));
    }

    @Test
    void inditex_test2() throws Exception {

        this.mockMvc.perform(get("/api/prices/{brandId}/{productId}/{date}", 1, 35455, "2020-06-16 10:00:00"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].brandId").value(1))
                .andExpect(jsonPath("$[0].startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$[0].endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[0].priceList").value(1))
                .andExpect(jsonPath("$[0].productId").value(35455))
                .andExpect(jsonPath("$[0].price").value(35.50))
                .andExpect(jsonPath("$[1].id").value(4))
                .andExpect(jsonPath("$[1].brandId").value(1))
                .andExpect(jsonPath("$[1].startDate").value("2020-06-15T00:00:00"))
                .andExpect(jsonPath("$[1].endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[1].priceList").value(4))
                .andExpect(jsonPath("$[1].productId").value(35455))
                .andExpect(jsonPath("$[1].price").value(38.95));
    }

    @Test
    void inditex_test3() throws Exception {

        this.mockMvc.perform(get("/api/prices/{brandId}/{productId}/{date}", 1, 35455, "2020-06-14 21:00:00"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].brandId").value(1))
                .andExpect(jsonPath("$[0].startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$[0].endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[0].priceList").value(1))
                .andExpect(jsonPath("$[0].productId").value(35455))
                .andExpect(jsonPath("$[0].price").value(35.50));
    }

    @Test
    void inditex_test4() throws Exception {

        this.mockMvc.perform(get("/api/prices/{brandId}/{productId}/{date}", 1, 35455, "2020-06-15 10:00:00"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].brandId").value(1))
                .andExpect(jsonPath("$[0].startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$[0].endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[0].priceList").value(1))
                .andExpect(jsonPath("$[0].productId").value(35455))
                .andExpect(jsonPath("$[0].price").value(35.50))
                .andExpect(jsonPath("$[1].id").value(3))
                .andExpect(jsonPath("$[1].brandId").value(1))
                .andExpect(jsonPath("$[1].startDate").value("2020-06-15T00:00:00"))
                .andExpect(jsonPath("$[1].endDate").value("2020-06-15T11:00:00"))
                .andExpect(jsonPath("$[1].priceList").value(3))
                .andExpect(jsonPath("$[1].productId").value(35455))
                .andExpect(jsonPath("$[1].price").value(30.50))
                .andExpect(jsonPath("$[2].id").value(4))
                .andExpect(jsonPath("$[2].brandId").value(1))
                .andExpect(jsonPath("$[2].startDate").value("2020-06-15T00:00:00"))
                .andExpect(jsonPath("$[2].endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[2].priceList").value(4))
                .andExpect(jsonPath("$[2].productId").value(35455))
                .andExpect(jsonPath("$[2].price").value(38.95));
    }

    @Test
    void inditex_test5() throws Exception {

        this.mockMvc.perform(get("/api/prices/{brandId}/{productId}/{date}", 1, 35455, "2020-06-16 10:00:00"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].brandId").value(1))
                .andExpect(jsonPath("$[0].startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$[0].endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[0].priceList").value(1))
                .andExpect(jsonPath("$[0].productId").value(35455))
                .andExpect(jsonPath("$[0].price").value(35.50))
                .andExpect(jsonPath("$[1].id").value(4))
                .andExpect(jsonPath("$[1].brandId").value(1))
                .andExpect(jsonPath("$[1].startDate").value("2020-06-15T00:00:00"))
                .andExpect(jsonPath("$[1].endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$[1].priceList").value(4))
                .andExpect(jsonPath("$[1].productId").value(35455))
                .andExpect(jsonPath("$[1].price").value(38.95));
    }
}
