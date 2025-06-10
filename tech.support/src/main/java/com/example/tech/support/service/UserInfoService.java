package com.example.tech.support.service;

import com.example.tech.support.model.entity.UserInfo;
import com.example.tech.support.model.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;

    public UserInfo createTestUser() {
        UserInfo user = new UserInfo();
        user.setName("James");
        user.setSurname("Hetfield");
        user.setEmail("metallica@gmail.com");
        user.setCreatedAt(LocalDateTime.now());

        return userInfoRepository.save(user);
    }
}
