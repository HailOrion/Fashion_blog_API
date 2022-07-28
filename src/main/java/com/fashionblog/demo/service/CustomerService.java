package com.fashionblog.demo.service;

import com.fashionblog.demo.dto.CommentDto;
import com.fashionblog.demo.dto.LoginDto;
import com.fashionblog.demo.dto.PersonDto;
import com.fashionblog.demo.entities.Admin;
import com.fashionblog.demo.entities.Comment;
import com.fashionblog.demo.entities.Customer;
import com.fashionblog.demo.enums.Role;

public interface CustomerService {

    void createCustomer(PersonDto personDto);

    Customer customerLogin (LoginDto loginDto);

    void customerLogout();

}
