package com.fashionblog.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "blog_tbl")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,unique = true)
    private Long blogId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id", referencedColumnName = "adminId")
    private Admin admin;

    @OneToMany(
        cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
        name = "fk_blog",
        referencedColumnName = "blogId"
    )
    private List<Customer> customers;

}
