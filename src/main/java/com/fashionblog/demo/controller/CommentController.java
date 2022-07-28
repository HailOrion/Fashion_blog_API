package com.fashionblog.demo.controller;

import com.fashionblog.demo.dto.CommentDto;
import com.fashionblog.demo.entities.Comment;
import com.fashionblog.demo.entities.Post;
import com.fashionblog.demo.enums.Role;
import com.fashionblog.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment")
    public String createComment(@RequestBody CommentDto commentDto) {
        commentService.createComment(commentDto);
        return "Comment Created Successfully!";
    }

    @GetMapping("/viewAllComments")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> viewComments() {
        return commentService.viewAllComments();
    }

    @GetMapping("/viewCommentById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Comment> viewCommentById(@PathVariable("id") Long commentId) {
        return ResponseEntity.ok(commentService.viewCommentById(commentId));
    }
}
