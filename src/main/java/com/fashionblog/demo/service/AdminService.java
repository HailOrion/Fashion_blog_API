package com.fashionblog.demo.service;

import com.fashionblog.demo.dto.LoginDto;
import com.fashionblog.demo.dto.PersonDto;
import com.fashionblog.demo.entities.Admin;

public interface AdminService {

    void createAdmin(PersonDto personDto);

    Admin adminLogin (LoginDto loginDto);

    void adminLogout();
}
