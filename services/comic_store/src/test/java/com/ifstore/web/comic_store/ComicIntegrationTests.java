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

    private byte[] CONTENT = "CONTENT".getBytes();
    private MockMultipartFile file = new MockMultipartFile("file", "filename.png", "image/png", CONTENT);
    private MockMultipartHttpServletRequestBuilder postRequest = MockMvcRequestBuilders.multipart("/comics").file(file);
    private MockHttpServletRequestBuilder getAllComicsRequest = MockMvcRequestBuilders.get("/comics");

    @Test
    public void postIsRestful() throws Exception {
        mockMvc.perform(postRequest).andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.header().exists("Location"));
    }

    @Test
    public void canRoundTripComicName() throws Exception {
        mockMvc.perform(postRequest);
        mockMvc.perform(getAllComicsRequest).andExpect(
                MockMvcResultMatchers.content().string("[{name: \"" + file.getOriginalFilename() + "\"}\n]"));
    }

    // TODO: we're doing this next
    // @Test
    // public void canRoundTripComicContent() throws Exception {
    // mockMvc.perform(postRequest).andDo((response) -> {
    // var getUrl = response.getResponse().getHeader("Location");
    // mockMvc.perform(MockMvcRequestBuilders.get(getUrl))
    // .andExpect(MockMvcResultMatchers.content().bytes(CONTENT));
    // });
    // }

    @Nested
    class GivenNoFileInPostRequest {

        private MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/comics");

        @Test
        public void returns400() throws Exception {
            mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isBadRequest());
        }
    }
}
