package com.fashionblog.demo.entities;


import com.fashionblog.demo.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "post_tbl")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,unique = true)
    private Long postId;

    private String title;

    private String body;

    private String CreatedAt ;

    private String updatedAt;

    @Enumerated(EnumType.STRING)
    private Category category;

//    @ManyToOne(targetEntity = Admin.class)
//    private Admin adminId;

    private Long adminId;

}
