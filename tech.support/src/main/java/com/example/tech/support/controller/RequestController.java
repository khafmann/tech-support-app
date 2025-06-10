package com.example.tech.support.controller;

import com.example.tech.support.model.dto.CreateRequestDto;
import com.example.tech.support.model.dto.RequestDto;
import com.example.tech.support.model.dto.UpdateRequest;
import com.example.tech.support.model.enums.RequestStatus;
import com.example.tech.support.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/request-processing")
public class RequestController {
    private final RequestService requestService;

    @PostMapping
    public ResponseEntity<RequestDto> createRequest(@RequestBody CreateRequestDto dto) {
        return ResponseEntity.ok(requestService.createRequest(dto));
    }

    @PatchMapping("/change-status/{id}")
    public ResponseEntity<RequestDto> updateRequest(
            @PathVariable Long id,
            @RequestBody UpdateRequest updateDto) {
        return ResponseEntity.ok(requestService.updateRequest(id,
                        RequestStatus.fromId(updateDto.getStatusId()),
                        updateDto.getDescription()));
    }

    @GetMapping("/get-by-id/{userId}")
    public ResponseEntity<List<RequestDto>> getRequests(@PathVariable String userId){
        return ResponseEntity.ok(requestService.getRequestsByUserId(userId));
    }

    @GetMapping("/get-by-status/{statusId}")
    public ResponseEntity<List<RequestDto>> getRequestsByStatusId(@PathVariable int statusId) {
        return ResponseEntity.ok(requestService.getRequestsByStatusId(statusId));
    }

}
