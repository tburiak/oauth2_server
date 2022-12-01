package com.course.spring.boot.oauth2_server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookProfileController {
    @RequestMapping("/api/books/me")
    public ResponseEntity<BookProfile> profile(Authentication authentication) {
        System.out.println("Getting book profile by " + authentication.getName());

        BookProfile profile = new BookProfile();
        profile.setTitle("Harry Potter");
        profile.setAuthor("J. K. Rowling");
        profile.setRequestedBy(authentication.getName());

        return ResponseEntity.ok(profile);
    }
}