package com.example.tech.support.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/request-processing")
public class RequestController {
    @PostMapping()
    public void createRequest(){

    }

    @GetMapping()
    public void getRequest(){

    }
}
