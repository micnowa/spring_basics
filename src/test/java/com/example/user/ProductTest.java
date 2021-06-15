package com.example.user;

import com.example.MainApp;
import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;
import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = MainApp.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:persistence.properties")
class ProductTest {
    @Autowired
    private MockMvc mvc;

    @Resource
    private ProductRepository productRepository;

    String expectedContent = "[{\"name\":\"Pillow\",\"price\":\"20.99\"},{\"name\":\"Cover\",\"price\":\"10.99\"},{\"name\":\"Bed\",\"price\":\"720.99\"},{\"name\":\"Frame\",\"price\":\"2220.99\"}]";

    @Test
    void shouldRetrieveAllProducts_WhenDbIsNotEmpty() throws Exception {
        productRepository.save(new Product("Pillow", new BigDecimal("20.99")));
        productRepository.save(new Product("Cover", new BigDecimal("10.99")));
        productRepository.save(new Product("Bed", new BigDecimal("720.99")));
        productRepository.save(new Product("Frame", new BigDecimal("2220.99")));

        mvc.perform(MockMvcRequestBuilders.get("/products")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedContent));
    }
}
