package com.rlabausa.cherishservice.posts.controllers;

import com.rlabausa.cherishservice.posts.assemblers.PostModelAssembler;
import com.rlabausa.cherishservice.posts.models.Post;
import com.rlabausa.cherishservice.posts.services.PostService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.stream.Collectors;


@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;
    private final PostModelAssembler assembler;

    public PostController(
            PostService postService,
            PostModelAssembler assembler
    ) {
        this.postService = postService;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<Post>> getAllPosts() {
        var posts = this.postService.getAllPosts()
                .stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(
                posts,
                linkTo(
                        methodOn(PostController.class)
                                .getAllPosts()
                ).withSelfRel()
        );
    }

    @GetMapping("/{id}")
    public EntityModel<Post> getPost(@PathVariable Long id) {
        var post = postService.getPostById(id);

        return assembler.toModel(post);
    }

    @PostMapping
    public Post addPost(@RequestBody final Post post) {
        return this.postService.addPost(post);
    }


}
