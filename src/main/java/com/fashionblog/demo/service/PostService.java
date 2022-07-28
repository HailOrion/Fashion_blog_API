package com.fashionblog.demo.service;

import com.fashionblog.demo.dto.PostDto;
import com.fashionblog.demo.entities.Admin;
import com.fashionblog.demo.entities.Post;
import com.fashionblog.demo.enums.Category;

import java.util.List;

public interface PostService {

    void createPost(PostDto postDto);

    List<Post> viewAllPosts();

    Post viewPostById(Long postId);

//    List<Post> viewPostByCategory(Long postId, Category category);

    Post updatePostTitle(Admin postId, PostDto postDto);

}
