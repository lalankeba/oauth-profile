package com.laan.oauthprofile.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping(value = {"/", "/index"})
    public String init() {
        return "Hello world";
    }

    @GetMapping(value = "/secured")
    public String initSecured() {
        return "Secured";
    }
}
