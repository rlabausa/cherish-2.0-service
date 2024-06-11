package com.rlabausa.cherishservice.posts.repositories;

import com.rlabausa.cherishservice.posts.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
}
