package com.fashionblog.demo.service;

import com.fashionblog.demo.dto.CommentDto;
import com.fashionblog.demo.entities.Comment;
import com.fashionblog.demo.entities.Post;
import com.fashionblog.demo.enums.Role;

import java.util.List;

public interface CommentService {

    void createComment (CommentDto commentDto);

    List<Comment> viewAllComments();

    Comment viewCommentById(Long commendId);
}
