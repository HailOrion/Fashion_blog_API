package com.fashionblog.demo.service.serviceimpl;

import com.fashionblog.demo.dto.CommentDto;
import com.fashionblog.demo.entities.Comment;
import com.fashionblog.demo.entities.Customer;
import com.fashionblog.demo.entities.Post;
import com.fashionblog.demo.enums.Role;
import com.fashionblog.demo.exceptions.PermissionDeniedException;
import com.fashionblog.demo.exceptions.ResourceNotFoundException;
import com.fashionblog.demo.repositories.CommentRepository;
import com.fashionblog.demo.repositories.CustomerRepository;
import com.fashionblog.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createComment(CommentDto commentDto) {
        Optional<Customer> customer = customerRepository.findById(commentDto.getCustomerId());

        if(customer.isEmpty()) {
            throw new ResourceNotFoundException("User not found");
        }
        Comment comment = Comment.builder()
                .text(commentDto.getText())
                .customerId(commentDto.getCustomerId())
                .CreatedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()))
                .updatedAt(new SimpleDateFormat("0000-00-00 00:00").format(new Date()))
                .build();

        commentRepository.save(comment);
    }

    @Override
    public List<Comment> viewAllComments() {
        List<Comment> commentList = commentRepository.findAll();

        if (commentList.isEmpty()) {
            throw new ResourceNotFoundException("No comments!");
        }
        return commentList;
    }

    @Override
    public Comment viewCommentById(Long commendId) {
        return commentRepository.findById(commendId).orElseThrow(() -> new ResourceNotFoundException("Post is unavailable"));
    }
}
