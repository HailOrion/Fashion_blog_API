package com.fashionblog.demo.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer_tbl")
public class Customer extends Person{
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(nullable = false,unique = true)
 private Long customerId;

 @OneToMany(
         cascade = CascadeType.ALL
 )
 @JoinColumn(
         name = "fk_customer",
         referencedColumnName = "customerId"
 )
 private List<Comment> comments;

}
