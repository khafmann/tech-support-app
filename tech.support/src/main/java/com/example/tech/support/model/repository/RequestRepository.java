package com.example.tech.support.model.repository;

import com.example.tech.support.model.entity.Request;
import com.example.tech.support.model.enums.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request,Long> {
    List<Request> findAllByUserId(String userId);

    List<Request> findAllByStatus(RequestStatus status);
}
