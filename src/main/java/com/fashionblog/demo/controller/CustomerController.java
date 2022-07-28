package com.fashionblog.demo.controller;

import com.fashionblog.demo.dto.CommentDto;
import com.fashionblog.demo.dto.LoginDto;
import com.fashionblog.demo.dto.PersonDto;
import com.fashionblog.demo.enums.Role;
import com.fashionblog.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/signUp")
    public ResponseEntity<String> saveCustomer(@Valid @RequestBody PersonDto personDto) {
        customerService.createCustomer(personDto);
        return new ResponseEntity<>("Customer Created Successfully", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginAdmin(@RequestBody LoginDto loginDto) {
        customerService.customerLogin(loginDto);
        return new ResponseEntity<>("Login Successful", HttpStatus.OK);
    }

}
