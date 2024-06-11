package com.rlabausa.cherishservice.posts.repositories;

import com.rlabausa.cherishservice.posts.models.Post;
import com.rlabausa.cherishservice.posts.models.PostDto;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Transactional
public class PostRepositoryCustomImpl implements PostRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    public List<PostDto> findPostByNearestLatLong(
            @Param("lat") BigDecimal latitude,
            @Param("long") BigDecimal longitude
    ) {
        List<PostDto> posts = entityManager
                .createStoredProcedureQuery("cherish.GET_POST_BY_DISTANCE_FROM_LAT_LONG")
                .setParameter("lat", latitude)
                .setParameter("long", longitude)
                .getResultList();

        return posts;
    }

    @Override
    public Post merge(Post post) {
        return this.entityManager.merge(post);
    }
}
