package com.fashionblog.demo.service.serviceimpl;

import com.fashionblog.demo.dto.CommentDto;
import com.fashionblog.demo.dto.LoginDto;
import com.fashionblog.demo.dto.PersonDto;
import com.fashionblog.demo.entities.Customer;
import com.fashionblog.demo.enums.Role;
import com.fashionblog.demo.exceptions.ResourceAlreadyExistsException;
import com.fashionblog.demo.exceptions.ResourceNotFoundException;
import com.fashionblog.demo.repositories.CustomerRepository;
import com.fashionblog.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    @Override
    public void createCustomer(PersonDto personDto) {
        if (customerRepository.findByEmail(personDto.getEmail()) != null) {
            throw new ResourceAlreadyExistsException("Customer already exist !!!");
        }

        Customer customer = Customer.builder()
                .firstName(personDto.getFirstName())
                .lastName(personDto.getLastName())
                .email(personDto.getEmail())
                .password(personDto.getPassword())
                .role(Role.CUSTOMER)
                .build();

        customerRepository.save(customer);
    }

    @Override
    public Customer customerLogin(LoginDto loginDto) {
        Customer customer = Optional.ofNullable(customerRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword()))
                .orElseThrow(() -> new ResourceNotFoundException("Invalid Username/Password"));

        return customer;
    }

    @Override
    public void customerLogout() {
        // TODO implement logout for customer
    }

}
