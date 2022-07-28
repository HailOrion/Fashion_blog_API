package com.fashionblog.demo.repositories;

import com.fashionblog.demo.entities.Admin;
import com.fashionblog.demo.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

//    @Query(
//            value = ("SELECT * FROM admin_tbl WHERE email = :?1"),
//            nativeQuery = true
//    )

    Admin findByEmail (String email);

    Optional<Admin> findById(Long adminId);

    @Query("select a from Admin a where a.email = ?1 and a.password = ?2")
    Admin findByEmailAndPassword (String email, String password);



}
