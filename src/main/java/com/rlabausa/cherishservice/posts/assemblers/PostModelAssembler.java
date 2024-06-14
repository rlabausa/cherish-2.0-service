package com.rlabausa.cherishservice.posts.assemblers;

import com.rlabausa.cherishservice.posts.controllers.PostController;
import com.rlabausa.cherishservice.posts.models.Post;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


// @Component annotation indicates that this PostModelAssembler is automatically created when the app starts
@Component
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

    @Override
    public CollectionModel<EntityModel<Post>> toCollectionModel(Iterable<? extends Post> iterable) {
        Stream<EntityModel<Post>> stream = StreamSupport
                .stream(iterable.spliterator(), false)
                .map(this::toModel);

        var posts = stream.collect(Collectors.toList());

        return CollectionModel.of(
                posts,
                linkTo(
                        methodOn(PostController.class)
                                .getAllPosts()
                ).withSelfRel()
        );
    }
}
