package com.example.tech.support.service;

import com.example.tech.support.model.entity.Request;
import com.example.tech.support.model.enums.RequestStatus;
import com.example.tech.support.model.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final UserInfoRepository userInfoRepository;

    public void handleStatusChange(Request request) {
        if (request.getStatus() == RequestStatus.FINISHED) {
            sendCompletionMessage(request.getId());
        }
    }

    private void sendCompletionMessage(Long requestId) {
        String message = "Работа по заявке завершена: requestId = " + requestId;
        kafkaTemplate.send("request-notifications", message);
    }

    private void notifyUserByEmail(String userId) {
        userInfoRepository.findByEmail(userId).ifPresentOrElse(
                user -> log.info("Отправлено email-сообщение: email = {}", user.getEmail()),
                () -> log.warn("Пользователь с этим email не найден: email = {}", userId)
        );
    }
}
