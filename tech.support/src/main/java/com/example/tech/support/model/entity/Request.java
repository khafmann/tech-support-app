package com.example.tech.support.model.entity;

import com.example.tech.support.model.enums.RequestStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    private String description;
    private String userId;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;
}
