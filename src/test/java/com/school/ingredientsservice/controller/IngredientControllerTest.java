package com.school.ingredientsservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.ingredientsservice.entity.Ingredient;
import com.school.ingredientsservice.service.IngredientService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.UnsupportedEncodingException;

import static org.mockito.Mockito.when;
import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class IngredientControllerTest {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private IngredientService ingredientService;

    @Test
    void getAllIngredients() throws Exception {

         mvc.perform(get("/ingredient/all")
                 .contentType(MediaType.APPLICATION_JSON)
                 .accept(MediaType.APPLICATION_JSON))
                 .andExpect(status().isOk())
                 .andReturn();
    }

    @Test
    void getAllIngredientsInOrder() {
    }

    @Test
    void saveIngredient() throws Exception {
        Ingredient ingredientToPost = new Ingredient(19L, "Frikandel", 20);
        String ingredientAsString = mapper.writeValueAsString(ingredientToPost);

        mvc.perform(post("/ingredient/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ingredientAsString)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ingredientId").value(1L))
                .andExpect(jsonPath("$.name").value("Frikandel"))
                .andExpect(jsonPath("$.amount").value(20));
    }

    @Test
    void deleteIngredientById() {
    }

    @Test
    void test() {
    }
}