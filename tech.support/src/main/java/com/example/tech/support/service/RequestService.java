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
import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;
    private final RequestMapper requestMapper;
    private final NotificationService notificationService;

    @Transactional
    public RequestDto createRequest(CreateRequestDto dto) {
        Request request = requestMapper.toEntity(dto);
        request.setStatus(RequestStatus.ACCEPTED); // Сразу присваиваем статус "принят" т.к. запись идет в БД
        request.setCreatedAt(LocalDateTime.now());

        Request savedRequest = requestRepository.save(request);
        return requestMapper.toDto(savedRequest);
    }

    public RequestDto updateRequest(Long id, RequestStatus newStatus, String newDescription) {
        Request request = requestRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Заявка не найдена: id = %d", id)));

        RequestStatus currentStatus = request.getStatus();
        if (newStatus.ordinal() <= currentStatus.ordinal()) {
            throw new IllegalArgumentException(String.format(
                    "Нельзя изменить статус на более ранний или тот же: текущий = %s, новый = %s",
                    currentStatus.name(), newStatus.name()));
        }

        request.setStatus(newStatus);
        request.setDescription(newDescription);
        request.setLastUpdated(LocalDateTime.now());

        Request updatedRequest = requestRepository.save(request);
        notificationService.handleStatusChange(updatedRequest);
        return requestMapper.toDto(updatedRequest);
    }

    public List<RequestDto> getRequestsByUserId(String userId) {
        List<Request> requests = requestRepository.findAllByUserId(userId);
        if (requests.isEmpty()) {
            throw new EntityNotFoundException(
                    String.format("Под этим пользователем записи не найдены: userId = %s", userId)
            );
        }
        return requests.stream()
                .map(requestMapper::toDto)
                .toList();
    }

    public List<RequestDto> getRequestsByStatusId(int statusId) {
        RequestStatus status = RequestStatus.fromId(statusId);
        List<Request> requests = requestRepository.findAllByStatus(status);
        if (requests.isEmpty()) {
            throw new EntityNotFoundException(String.format("Заявки со статусом %s не найдены", status.name()));
        }
        return requests.stream()
                .map(requestMapper::toDto)
                .toList();
    }
}
