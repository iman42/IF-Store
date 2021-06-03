package com.ifstore.web.comic_store;

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
public class ComicIntegrationTests {

    @Autowired
    public MockMvc mockMvc;

    private MockMultipartFile file = new MockMultipartFile("file", "filename.png", "image/png", "CONTENT".getBytes());
    private MockMultipartHttpServletRequestBuilder postRequest = MockMvcRequestBuilders.multipart("/comics").file(file);
    private MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.get("/comics");

    @Test
    public void postReturns200() throws Exception {
        mockMvc.perform(postRequest).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void canRoundTripComicName() throws Exception {
        mockMvc.perform(postRequest);
        mockMvc.perform(getRequest).andExpect(
                MockMvcResultMatchers.content().string("[{name: \"" + file.getOriginalFilename() + "\"}\n]"));
    }

    @Nested
    class GivenNoFileInPostRequest {

        private MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/comics");

        @Test
        public void returns400() throws Exception {
            mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isBadRequest());
        }
    }
}
