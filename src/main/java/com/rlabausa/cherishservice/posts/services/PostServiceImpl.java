package com.rlabausa.cherishservice.posts.services;

import com.rlabausa.cherishservice.locations.models.Location;
import com.rlabausa.cherishservice.locations.services.LocationService;
import com.rlabausa.cherishservice.posts.models.Post;
import com.rlabausa.cherishservice.posts.repositories.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final LocationService locationService;
    public PostServiceImpl(
            PostRepository postRepository,
            LocationService locationService
    ) {
        this.postRepository = postRepository;
        this.locationService = locationService;
    }

    @Override
    public Collection<Post> getAllPosts() {
        return this.postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return this.postRepository.findById(id)
                .orElseThrow();
    }

    @Override public List<Post> getPostByLocationId(Long locationId) {
        return this.postRepository.findAll();
    }

    @Override
    @Transactional
    public Post addPost(Post post) {
        var postLocation = post.getLocation();

        Location locationResult = locationService.getLocationByLatLong(
                postLocation.getLatitude(),
                postLocation.getLongitude()
        );

        if (locationResult != null) {
            return postRepository.merge(post);
        }
        return postRepository.save(post);
    }
}
