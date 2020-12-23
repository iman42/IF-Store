package com.ifstore.web.comic_store.controllers;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ComicControllerTests {

    @Autowired
    public MockMvc mockMvc;

    @Nested
    class IfFileUploaded{
        private MockMultipartFile file = new MockMultipartFile("file", "filename.png", "image/png", "CONTENT".getBytes());

        @Test
        public void shouldReturn200() throws Exception {
            mockMvc.perform(
                MockMvcRequestBuilders.multipart("/comic").file(file)
            ).andExpect(
                MockMvcResultMatchers.status().isOk()
            );
        }
    }
    
    @Nested
    class IfNoFileUploaded {
        @Test
        public void shouldReturn400() throws Exception {
            mockMvc.perform(
                MockMvcRequestBuilders.post("/comic")
            ).andExpect(
                MockMvcResultMatchers.status().isBadRequest()
            );
        }
    }
}
