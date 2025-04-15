package com.abletocode.spring_security_impl.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/management")
public class MemberController {
    @GetMapping
    public String getMember(){
        return "Member: secured url";
    }

    @GetMapping("/admin-write")
    @PreAuthorize("hasAuthority('admin:write')")
    public String memberOnlyForAdminWrite(){
        return "Member: secured end point only for admin write";
    }

}
