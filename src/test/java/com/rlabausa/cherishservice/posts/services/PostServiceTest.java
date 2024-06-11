package com.rlabausa.cherishservice.posts.services;

import com.rlabausa.cherishservice.locations.models.Location;
import com.rlabausa.cherishservice.locations.services.LocationService;
import com.rlabausa.cherishservice.posts.models.Post;
import com.rlabausa.cherishservice.posts.repositories.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class PostServiceTest {
    private List<Post> posts;

    @Mock
    private PostRepository postRepository = mock(PostRepository.class);

    @Mock
    private LocationService locationService = mock(LocationService.class);

    private PostServiceImpl service;

    @BeforeEach
    private void setUp() {
        this.service = new PostServiceImpl(
                this.postRepository,
                this.locationService
        );

        this.posts = Arrays.asList(
                new Post(1L, "User 1", "This is a test post", new Location(), new ArrayList<>()),
                new Post(2L, "User 1", "This is another test post", new Location(), new ArrayList<>())
        );
    }


    @Test
    public void shouldReturnAllPosts() {
        given(this.postRepository.findAll()).willReturn(this.posts);

        var result = service.getAllPosts();

        assertThat(result)
                .usingRecursiveComparison()
                .isEqualTo(this.posts);
    }

    @Test
    public void shouldAddPost() {
        Post post = new Post(99L, "User 1", "New post to add", new Location(), new ArrayList<>());
        given(this.postRepository.save(post)).willReturn(post);

        var result = this.service.addPost(post);

        assertThat(result)
                .usingRecursiveComparison()
                .isEqualTo(post);
    }
}
