package com.example.tech.support.controller;

import com.example.tech.support.model.entity.UserInfo;
import com.example.tech.support.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestUserController {
    private final UserInfoService userInfoService;

    @PostMapping("/create-user")
    public ResponseEntity<UserInfo> createTestUser() {
        UserInfo user = userInfoService.createTestUser();
        return ResponseEntity.ok(user);
    }
}
