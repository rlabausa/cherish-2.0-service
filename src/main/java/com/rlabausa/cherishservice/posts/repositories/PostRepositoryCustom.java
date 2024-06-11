package com.rlabausa.cherishservice.posts.repositories;

import com.rlabausa.cherishservice.posts.models.Post;
import com.rlabausa.cherishservice.posts.models.PostDto;

import java.math.BigDecimal;
import java.util.List;

public interface PostRepositoryCustom {
    public List<PostDto> findPostByNearestLatLong(BigDecimal latitude, BigDecimal longitude);
    public Post merge(Post post);
}
