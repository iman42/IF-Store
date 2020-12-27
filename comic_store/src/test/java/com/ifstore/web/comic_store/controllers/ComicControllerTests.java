package com.ifstore.web.comic_store.controllers;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ComicControllerTests {

    @Autowired
    public MockMvc mockMvc;

    @Nested
    class GivenFileInRequest {
        private MockMultipartFile file = new MockMultipartFile("file", "filename.png", "image/png", "CONTENT".getBytes());
        private MockMultipartHttpServletRequestBuilder request = MockMvcRequestBuilders.multipart("/comic").file(file);

        @Test
        public void returns200() throws Exception {
            mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk());
        }
    }

    @Nested
    class GivenNoFileInRequest {
        private MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/comic");

        @Test
        public void returns400() throws Exception {
            mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isBadRequest());
        }
    }
}
