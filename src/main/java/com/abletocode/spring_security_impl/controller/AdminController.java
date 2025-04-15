package com.abletocode.spring_security_impl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AdminController {
    @GetMapping
    public String getAdmin(){
        return "Admin: secured url";
    }
}
