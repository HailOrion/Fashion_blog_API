//package com.fashionblog.demo.controller;
//
//
//import com.fashionblog.demo.dto.PersonDto;
//import com.fashionblog.demo.entities.Admin;
//import com.fashionblog.demo.enums.Role;
//import com.fashionblog.demo.service.AdminService;
//import lombok.RequiredArgsConstructor;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(AdminController.class) // This creates the context for testing for endpoints.
//class AdminControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private AdminService adminService;
//
//    private Admin admin;
//
//    @BeforeEach
//    void setUp() { // Output Object
//        admin = Admin.builder()
//                .id(1L)
//                .firstName("Olalekan")
//                .lastName("Olakitan")
//                .email("Olakitan@gmail.com")
//                .password("123456")
//                .build();
//    }
//
//    @Test
//    void createAdmin() throws Exception { //Input Object
//        PersonDto personDto = PersonDto.builder()
//                .firstName("Olalekan")
//                .lastName("Olakitan")
//                .email("Olakitan@gmail.com")
//                .password("123456")
//                .build();
//
//        Mockito.when(adminService.createAdmin(personDto)).thenReturn(admin);
//
//        mockMvc.perform(post("/admin/create") //Calling the Endpoints
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\n" +
//                        "\t\"firstName\":\"Olalekan\",\n" +
//                        "\t\"lastname\":\"Olakitan\",\n" +
//                        "\t\"email\":\"Olakitan@gmail.com\",\n" +
//                        "\t\"password\":\"123456\",\n" +
//                        "}"))
//                        .andExpect(status().isOk());
//    }
//
//}