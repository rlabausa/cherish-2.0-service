package com.rlabausa.cherishservice.posts.assemblers;

import com.rlabausa.cherishservice.posts.controllers.PostController;
import com.rlabausa.cherishservice.posts.models.Post;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component // annotation indicates that the assembler is automatically created when the app starts
public class PostModelAssembler implements RepresentationModelAssembler<Post, EntityModel<Post>> {

    @Override
    public EntityModel<Post> toModel(Post post) {
        return EntityModel.of(post,
                linkTo(
                        methodOn(PostController.class).getPost(post.getId())
                ).withSelfRel(),
                linkTo(
                        methodOn(PostController.class).getAllPosts()
                ).withRel("posts")
        );
    }
}
