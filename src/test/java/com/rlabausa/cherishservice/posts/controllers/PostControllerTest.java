package com.rlabausa.cherishservice.posts.controllers;
import com.rlabausa.cherishservice.locations.models.Location;
import com.rlabausa.cherishservice.posts.models.Post;
import com.rlabausa.cherishservice.posts.services.PostService;
import com.rlabausa.cherishservice.posts.services.PostServiceImpl;
import com.rlabausa.cherishservice.posts.services.PostServiceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@WebMvcTest(PostController.class)
public class PostControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostService postService;

    private Collection<Post> posts;


    @BeforeEach
    private void setUp() {
        this.posts = Arrays.asList(
                new Post(1L, "User 1", "This is a test post", new Location(), new ArrayList<>()),
                new Post(2L, "User 1", "This is another test post", new Location(), new ArrayList<>())
        );
    }


    @Test
    public void shouldReturnOkForAllPosts() throws Exception {
        given(this.postService.getAllPosts()).willReturn(this.posts);
        this.mvc.perform(get("/posts"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturn2xxForAllPosts() throws Exception {
        this.mvc.perform(get("/posts"))
                .andExpect(status().is2xxSuccessful());
    }

//    @Test
//    public  void shouldReturnCollectionModelEntityForAllPosts() throws Exception {
//        this.mvc.perform(get("/posts"))
//                .andExpect();
//    }
}
