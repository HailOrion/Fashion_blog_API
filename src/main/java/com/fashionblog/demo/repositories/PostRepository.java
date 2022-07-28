package com.fashionblog.demo.repositories;

import com.fashionblog.demo.entities.Admin;
import com.fashionblog.demo.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Admin findPostByAdminIdAndPostId(Long adminId, Long postId);

    Admin findByAdminId(Long adminId);

}
