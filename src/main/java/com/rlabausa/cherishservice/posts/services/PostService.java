package com.rlabausa.cherishservice.posts.services;

import com.rlabausa.cherishservice.posts.models.Post;

import java.util.Collection;
import java.util.List;

public interface PostService {
    Collection<Post> getAllPosts();

    Post getPostById(Long id);

    List<Post> getPostByLocationId(Long locationId);

    Post addPost(Post post);
}
