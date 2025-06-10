package com.example.tech.support.model.dto;

import lombok.Data;

@Data
public class UpdateRequest {
    private int statusId;
    private String description;
}