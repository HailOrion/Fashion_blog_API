package com.fashionblog.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "admin_tbl")
public class Admin extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,unique = true)
    private Long adminId;

    @OneToMany(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "fk_admin",
        referencedColumnName = "adminId"
    )
    private List<Post> posts;


}
