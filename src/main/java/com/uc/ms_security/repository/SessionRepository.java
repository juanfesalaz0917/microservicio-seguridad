package com.uc.ms_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uc.ms_security.entity.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
}