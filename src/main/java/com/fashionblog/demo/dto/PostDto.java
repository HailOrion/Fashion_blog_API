package com.fashionblog.demo.dto;

import com.fashionblog.demo.entities.Admin;
import com.fashionblog.demo.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private Long adminId;
    private Long postId;

    private String title;

    private String body;
    private Category category;

}
