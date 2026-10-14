package com.pharmacy.identityservice.controller;

import com.pharmacy.identityservice.dto.request.RegisterRequest;
import com.pharmacy.identityservice.dto.response.UserResponse;
import com.pharmacy.identityservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    /**
     * POST /api/auth/register
     * Endpoint công khai — permitAll trong SecurityConfig.
     */
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(
            @Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.register(request));
    }
}