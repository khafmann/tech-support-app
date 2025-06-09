package com.example.tech.support.controller;

import com.example.tech.support.model.dto.CreateRequestDto;
import com.example.tech.support.model.dto.RequestDto;
import com.example.tech.support.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/request-processing")
public class RequestController {
    private final RequestService requestService;

    @PostMapping
    public ResponseEntity<RequestDto> createRequest(@RequestBody CreateRequestDto dto) {
        return ResponseEntity.ok(requestService.createRequest(dto));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<RequestDto> getRequests(@PathVariable Long userId){
        return ResponseEntity.ok(requestService.getRequestsById(userId));
    }
}
