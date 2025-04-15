package com.abletocode.spring_security_impl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/management/**")
public class AdminController {
    @GetMapping
    public String getAdmin(){
        return "Admin: secured url";
    }
}
