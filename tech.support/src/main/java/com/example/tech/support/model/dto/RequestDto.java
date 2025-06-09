package com.example.tech.support.model.dto;

import com.example.tech.support.model.enums.RequestStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestDto {
    private Long id;
    private RequestStatus status;
    private String description;
    private String userId;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;
}
