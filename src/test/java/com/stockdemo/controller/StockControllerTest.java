package com.stockdemo.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.stockdemo.repository.StockRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = StockController.class)

class StockControllerTest {

    @MockBean
    private StockRepository stockRepository;
    
    @Autowired
    private MockMvc mockMvc;

	
	@Test
	void testSaveStock() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
        		.get("/stock/{code}", "GOOG"))
                .andExpect(MockMvcResultMatchers.status().is(200))
//                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

	@Test
	void testGetStock() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
        		.get("/stock/{code}", "GOOG"))
                .andExpect(MockMvcResultMatchers.status().is(200))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.stockCode").value("GOOG"))
//                .andDo(MockMvcResultHandlers.print())
                .andReturn();
	}

	@Test
	void testDeleteStock() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
        		.get("/stock/{code}", "GOOG"))
                .andExpect(MockMvcResultMatchers.status().is(200))
//                .andDo(MockMvcResultHandlers.print())
                .andReturn();
	}

	@Test
	void testUpdateStock() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
        		.get("/stock/{code}", "GOOG"))
                .andExpect(MockMvcResultMatchers.status().is(200))
//                .andDo(MockMvcResultHandlers.print())
                .andReturn();
	}

}
