package com.fashionblog.demo.controller;

import com.fashionblog.demo.dto.PostDto;
import com.fashionblog.demo.entities.Admin;
import com.fashionblog.demo.entities.Post;
import com.fashionblog.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.PushBuilder;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    public ResponseEntity <String> createPost(@RequestBody PostDto postDto) {
        postService.createPost(postDto);
        return new ResponseEntity<>("Post Created Successfully !!", HttpStatus.CREATED);
    }

//    @GetMapping("/viewAllPosts")
//    public String viewPost() {
//        postService.viewAllPosts();
//        return "Successful!";
//
//    }
//
//    @GetMapping("/viewAllPosts")
//    public ResponseEntity<List<Post>> viewAllPosts(){
//        return new ResponseEntity<>(postService.viewAllPosts(),HttpStatus.OK);
////        return new ResponseEntity<>(HttpStatus.OK);
////        return ResponseEntity.ok(postService.viewAllPosts());
//    }

    @GetMapping("/viewAllPosts")
    public ResponseEntity <List<Post>> viewAllPost() {
        return ResponseEntity.ok(postService.viewAllPosts());
    }

    @GetMapping("/viewPostById/{id}")
    public ResponseEntity <Post> viewPostId(@PathVariable("id") Long postId) {
        return ResponseEntity.ok(postService.viewPostById(postId));
    }

}
