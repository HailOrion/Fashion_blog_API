package com.fashionblog.demo.repositories;

import com.fashionblog.demo.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository <Comment, Long> {

}
