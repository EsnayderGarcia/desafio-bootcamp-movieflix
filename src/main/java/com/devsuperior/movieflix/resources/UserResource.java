package com.devsuperior.movieflix.resources;

import com.devsuperior.movieflix.DTOs.UserDTO;
import com.devsuperior.movieflix.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getUser() {
        return ResponseEntity.ok(userService.getUser());
    }
}
