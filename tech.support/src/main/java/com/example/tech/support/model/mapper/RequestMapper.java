package com.example.tech.support.model.mapper;

import com.example.tech.support.model.dto.CreateRequestDto;
import com.example.tech.support.model.dto.RequestDto;
import com.example.tech.support.model.entity.Request;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RequestMapper {
    @Mapping(target = "userId", source = "userId")
    Request toEntity(CreateRequestDto dto);
    RequestDto toDto(Request entity);
}
