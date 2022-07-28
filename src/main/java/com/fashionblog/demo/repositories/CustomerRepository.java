package com.fashionblog.demo.repositories;

import com.fashionblog.demo.entities.Customer;
import com.fashionblog.demo.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String email);

    Customer findByEmailAndPassword(String email, String password);

    boolean findByRole(Role admin);
}
