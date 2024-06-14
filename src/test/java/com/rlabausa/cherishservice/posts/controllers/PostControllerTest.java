package com.rlabausa.cherishservice.posts.controllers;

import com.rlabausa.cherishservice.locations.models.Location;
import com.rlabausa.cherishservice.posts.assemblers.PostModelAssembler;
import com.rlabausa.cherishservice.posts.models.Post;
import com.rlabausa.cherishservice.posts.services.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostController.class)
public class PostControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostService postService;

    @TestConfiguration
    static class DependencyConfiguration {
        @Bean
        public PostModelAssembler postModelAssembler() {
            return new PostModelAssembler();
        }
    }

    private List<Post> posts;


    @BeforeEach
    private void setUp() {
        posts = Arrays.asList(
                new Post(
                        1L,
                        "User 1",
                        "This is a test post",
                        new Location(22L, new BigDecimal(90), new BigDecimal(90), "Test location 1"),
                        new ArrayList<>()
                ),
                new Post(
                        2L,
                        "User 1",
                        "This is another test post",
                        new Location(22L, new BigDecimal(90), new BigDecimal(90), "Test location 1"),
                        new ArrayList<>()
                )
        );
    }


    @Test
    public void shouldReturnOkForAllPosts() throws Exception {
        given(this.postService.getAllPosts()).willReturn(posts);

        mvc.perform(get("/posts"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturn2xxForAllPosts() throws Exception {
        given(this.postService.getAllPosts()).willReturn(posts);

        mvc.perform(get("/posts"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void shouldReturnDefaultHalJsonResponse() throws Exception {
        given(this.postService.getAllPosts()).willReturn(posts);

        mvc.perform(get("/posts"))
                .andExpect(jsonPath("_embedded").exists())
                .andExpect(jsonPath("_links").exists())
                .andExpect(jsonPath("_links.self.href").exists())
        ;
    }

    @Test
    public void shouldReturnEmbeddedPostResourcesWithLinks() throws Exception {
        given(this.postService.getAllPosts()).willReturn(posts);

        mvc.perform(get("/posts"))
                .andExpect(jsonPath("_embedded.postList").exists())
                .andExpect(jsonPath("_embedded.postList[0].id").value(posts.get(0).getId()))
                .andExpect(jsonPath("_embedded.postList[0].author").value(posts.get(0).getAuthor()))
                .andExpect(jsonPath("_embedded.postList[0].caption").value(posts.get(0).getCaption()))
                .andExpect(jsonPath("_embedded.postList[0].photos").exists())
                .andExpect(jsonPath("_embedded.postList[0].location.id").value(posts.get(0).getLocation().getId()))
                .andExpect(jsonPath("_embedded.postList[0].location.locationName").value(posts.get(0).getLocation().getLocationName()))
                .andExpect(jsonPath("_embedded.postList[0].location.latitude").value(posts.get(0).getLocation().getLatitude()))
                .andExpect(jsonPath("_embedded.postList[0].location.longitude").value(posts.get(0).getLocation().getLongitude()))

                .andExpect(jsonPath("_embedded.postList[1].id").value(posts.get(1).getId()))
                .andExpect(jsonPath("_embedded.postList[1].author").value(posts.get(1).getAuthor()))
                .andExpect(jsonPath("_embedded.postList[1].caption").value(posts.get(1).getCaption()))
                .andExpect(jsonPath("_embedded.postList[1].photos").exists())
                .andExpect(jsonPath("_embedded.postList[1].location.id").value(posts.get(1).getLocation().getId()))
                .andExpect(jsonPath("_embedded.postList[1].location.locationName").value(posts.get(1).getLocation().getLocationName()))
                .andExpect(jsonPath("_embedded.postList[1].location.latitude").value(posts.get(1).getLocation().getLatitude()))
                .andExpect(jsonPath("_embedded.postList[1].location.longitude").value(posts.get(1).getLocation().getLongitude()))
        ;
    }
}
