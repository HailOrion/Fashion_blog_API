package com.fashionblog.demo.service.serviceimpl;

import com.fashionblog.demo.dto.PostDto;
import com.fashionblog.demo.entities.Admin;
import com.fashionblog.demo.entities.Post;
import com.fashionblog.demo.enums.Category;
import com.fashionblog.demo.exceptions.ResourceNotFoundException;
import com.fashionblog.demo.repositories.AdminRepository;
import com.fashionblog.demo.repositories.PostRepository;
import com.fashionblog.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final AdminRepository adminRepository;

    @Override
    public void createPost(PostDto postDto) {
        Optional<Admin> admin1 = adminRepository.findById(postDto.getAdminId());

        if (admin1.isEmpty()) {
            throw new ResourceNotFoundException("User Not Found!");
        }

//        Optional<Admin> admin1 = Optional.ofNullable(adminRepository.findById(postDto.getUserId()))
//                .orElseThrow(() -> new ResourceNotFoundException("User Not Found!"));

        Post post = Post.builder()
                .title(postDto.getTitle())
                .body(postDto.getBody())
                .category(postDto.getCategory())
                .CreatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
                .updatedAt(new SimpleDateFormat("0000-00-00 00:00").format(new Date()))
//                .admin(postDto.getAdminId())
                .adminId(postDto.getAdminId())
                .build();

        postRepository.save(post);
    }

    @Override
    public List<Post> viewAllPosts() {
        List<Post> postList = postRepository.findAll();

       if (postList.isEmpty()) {
           throw new ResourceNotFoundException("No created post yet!!");
       }
       return postList;
    }

    @Override
    public Post viewPostById(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("This post is not available"));
    }

    @Override
    public Post updatePostTitle(Admin postId, PostDto postDto) {
        Admin post1 =  postRepository.findPostByAdminIdAndPostId(postDto.getAdminId(), postDto.getPostId());
        if (post1 == null) {
            throw new ResourceNotFoundException("Invalid post ID provided or post ID belongs to another user!");
        }

        Post post = Post.builder()
                .title(postDto.getTitle())
                .updatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
                .build();

        return postRepository.save(post);
    }

//    @Override
//    public List<Post> viewPostByCategory(Long postId, Category category) {
//        Category category1 = postRepository.find
//    }


}
