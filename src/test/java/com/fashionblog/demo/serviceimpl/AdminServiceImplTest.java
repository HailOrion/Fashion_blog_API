//package com.fashionblog.demo.serviceimpl;
//
//import com.fashionblog.demo.entities.Admin;
//import com.fashionblog.demo.enums.Role;
//import com.fashionblog.demo.repositories.AdminRepository;
//import lombok.RequiredArgsConstructor;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
////@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
//class AdminServiceImplTest {
//
//    @Autowired
//    private AdminRepository adminRepository;
//
//    @Test
//    public void whenCreateAdmin_thenSaveAdmin() {
//        Admin admin = Admin.builder()
//                .firstName("Moses")
//                .lastName("Alexander")
//                .email("admin@gmail.com")
//                .password("admin1")
//                .role(Role.ADMIN)
//                .build();
//        adminRepository.save(admin);
//    }
//}