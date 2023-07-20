package com.company.Summative_Project_1.controller;

import com.company.Summative_Project_1.model.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Magic8BallController.class)
public class Magic8BallControllerTest {
    // Wiring in the MockMvc object
    @Autowired
    private MockMvc mockMvc;

    // ObjectMapper to convert between JSON
    private ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        // Standard set up method, for instantiating test objects --> autowired
    }

    @Test
    public void getMagic8BallAnswer() throws Exception {
        // Create a new Answer which contains the question
        String requestbody = "Test Question";
        mockMvc.perform(post("/magic")
                        .contentType("application/json")
                        .content(requestbody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.question").value("Test Question"))
                .andExpect(jsonPath("$.answer").exists())
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    public void getMagic8BallAnswerWithNoProvidedQuestion() throws Exception {
        // Create a new Answer which contains the question
        mockMvc.perform(post("/magic")
                .contentType("application/json"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.question").doesNotExist())
                .andExpect(jsonPath("$.answer").exists());

    }
}
