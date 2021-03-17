package com.ifstore.web.comic_store.controllers;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
public class ComicControllerTests {

    @Autowired
    public MockMvc mockMvc;

    @Nested
    class Post {
        @Nested
        class GivenRequestMadeWithFile {
            private MockMultipartFile file = new MockMultipartFile("file", "filename.png", "image/png",
                    "CONTENT".getBytes());
            private MockMultipartHttpServletRequestBuilder postRequest = MockMvcRequestBuilders.multipart("/comics")
                    .file(file);
            private MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.get("/comics");

            @Test
            public void returns200() throws Exception {
                mockMvc.perform(postRequest).andExpect(MockMvcResultMatchers.status().isOk());
            }

            @Disabled
            @Test
            public void canGetFile() throws Exception {
                mockMvc.perform(postRequest);
                mockMvc.perform(getRequest).andExpect(
                    MockMvcResultMatchers.content().string("[{name: "+file.getName()+"}]")
                );
            }
        }

        @Nested
        class GivenNoFileInRequest {
            private MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/comics");

            @Test
            public void returns400() throws Exception {
                mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isBadRequest());
            }
        }
    }
}
