package com.example.tech.support.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Request {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private String status;

    private String description;
    private String userId;
    private LocalDateTime lastUpdated;
}
