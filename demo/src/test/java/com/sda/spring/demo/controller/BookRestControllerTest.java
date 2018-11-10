package com.sda.spring.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.service.CategoryService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(BookRestController.class)
public class BookRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldUpdateCategory() throws Exception {

        Category category = new Category("Fairytale");
        category.setId(100L);

        given(categoryService.findById(100L)).willReturn(category);
        ResultActions resultActions = mockMvc.perform(put("/api/categories/100")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(category)));

        resultActions.andExpect(status().isNoContent());
    }

/*    @Test
    public void givenCategories_thenReturnJsonArray() throws Exception {

        Category category0 = new Category("fantasy");
        Category category1 = new Category("novel");
        Category category2 = new Category("poem");
        Category category3 = new Category("document");
        Category category4 = new Category("psychology");

        List<Category> categories = Arrays.asList(category0, category1, category2, category3, category4);

        given(categoryService.getCategories()).willReturn(categories);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/categories")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)));

        Mockito.verify(categoryService, VerificationModeFactory.times(2)).getCategories();
    }*/

}