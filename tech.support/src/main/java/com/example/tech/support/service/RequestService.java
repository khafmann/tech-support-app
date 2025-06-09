package com.example.tech.support.service;

import com.example.tech.support.model.dto.CreateRequestDto;
import com.example.tech.support.model.dto.RequestDto;
import com.example.tech.support.model.entity.Request;
import com.example.tech.support.model.enums.RequestStatus;
import com.example.tech.support.model.mapper.RequestMapper;
import com.example.tech.support.model.repository.RequestRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;
    private final RequestMapper requestMapper;

    @Transactional
    public RequestDto createRequest(CreateRequestDto dto){
        Request request = requestMapper.toEntity(dto);
        request.setStatus(RequestStatus.ACCEPTED); // Сразу присваиваем статус "принят" т.к. запись идет в БД
        request.setCreatedAt(LocalDateTime.now());

        Request savedRequest = requestRepository.save(request);
        return requestMapper.toDto(savedRequest);
    }

    public RequestDto getRequestsById(Long userId){
        Request request = requestRepository
                .findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Request with id " + userId + " not found"));
        return requestMapper.toDto(request);
    }
}
