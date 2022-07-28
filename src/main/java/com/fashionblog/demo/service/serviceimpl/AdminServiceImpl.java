package com.fashionblog.demo.service.serviceimpl;

import com.fashionblog.demo.dto.LoginDto;
import com.fashionblog.demo.dto.PersonDto;
import com.fashionblog.demo.entities.Admin;
import com.fashionblog.demo.enums.Role;
import com.fashionblog.demo.exceptions.ResourceAlreadyExistsException;
import com.fashionblog.demo.exceptions.ResourceNotFoundException;
import com.fashionblog.demo.repositories.AdminRepository;
import com.fashionblog.demo.repositories.PostRepository;
import com.fashionblog.demo.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    public void createAdmin(PersonDto personDto) {
        if (adminRepository.findByEmail(personDto.getEmail()) != null) {
            throw new ResourceAlreadyExistsException("Admin already exist !!!");
        }

        Admin admin = Admin.builder()
                .firstName(personDto.getFirstName())
                .lastName(personDto.getLastName())
                .email(personDto.getEmail())
                .password(personDto.getPassword())
                .role(Role.ADMIN)
                .build();

         adminRepository.save(admin);
    }


    @Override
    public Admin adminLogin(LoginDto loginDto) {
        Admin admin = Optional.ofNullable(adminRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword()))
                .orElseThrow(()-> new ResourceNotFoundException("Invalid Username or Password"));
        return admin;
    }

    @Override
    public void adminLogout() {
        //TODO implement logout for admin
    }


}
