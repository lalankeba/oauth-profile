package com.laan.oauthprofile.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
@Slf4j
public class IndexController {

    @GetMapping(value = {"/", "/index"})
    public ResponseEntity<Object> init() {
        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }

    @GetMapping(value = "/secured")
    public ResponseEntity<Object> initSecured(@AuthenticationPrincipal OAuth2User oAuth2User) {
        log.info("--------- Attributes --------");
        Map<String, Object> attributes = oAuth2User.getAttributes();
        attributes.forEach((key, value) -> log.info("{}: {}", key, value));

        log.info("--------- Authorities --------");
        Collection<? extends GrantedAuthority> authorities = oAuth2User.getAuthorities();
        authorities.forEach(a -> log.info("{}", a.getAuthority()));

        return new ResponseEntity<>(attributes, HttpStatus.OK);
    }
}
