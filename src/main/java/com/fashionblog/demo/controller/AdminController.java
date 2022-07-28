package com.fashionblog.demo.controller;

import com.fashionblog.demo.dto.LoginDto;
import com.fashionblog.demo.dto.PersonDto;
import com.fashionblog.demo.dto.PostDto;
import com.fashionblog.demo.entities.Admin;
import com.fashionblog.demo.enums.Role;
import com.fashionblog.demo.service.AdminService;
import com.fashionblog.demo.service.serviceimpl.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/signUp")
    public ResponseEntity<String> saveAdmin(@Valid @RequestBody PersonDto personDto) {
        adminService.createAdmin(personDto);
        return new ResponseEntity<>("Admin Created Successfully", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginAdmin(@RequestBody LoginDto loginDto) {
        adminService.adminLogin(loginDto);
        return new ResponseEntity<>("Login Successful", HttpStatus.OK);
    }

}
