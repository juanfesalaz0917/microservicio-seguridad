package com.uc.ms_security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uc.ms_security.dto.session.CreateSessionDTO;
import com.uc.ms_security.dto.session.SessionResponseDTO;
import com.uc.ms_security.dto.session.UpdateSessionDTO;
import com.uc.ms_security.entity.Session;
import com.uc.ms_security.exception.ApplicationException;
import com.uc.ms_security.exception.ErrorCase;
import com.uc.ms_security.mapper.SessionMapper;
import com.uc.ms_security.repository.SessionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final SessionRepository sessionRepository;
    private final SessionMapper sessionMapper;

    public SessionResponseDTO create(CreateSessionDTO dto) {
        Session session = sessionMapper.toEntity(dto);
        Session savedSession = sessionRepository.save(session);
        return sessionMapper.toResponseDTO(savedSession);
    }

    public List<SessionResponseDTO> findAll() {
        return sessionMapper.toResponseDTOList(sessionRepository.findAll());
    }

    private Session findSession(Long id) {
        return sessionRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(
                        ErrorCase.NOT_FOUND,
                        "Session not found with id: " + id
                ));
    }

    public SessionResponseDTO findById(Long id) {
        return sessionMapper.toResponseDTO(findSession(id));
    }

    public SessionResponseDTO update(Long id, UpdateSessionDTO dto) {
        Session session = findSession(id);
        sessionMapper.updateEntity(dto, session);
        Session updatedSession = sessionRepository.save(session);
        return sessionMapper.toResponseDTO(updatedSession);
    }

    public void delete(Long id) {
        sessionRepository.delete(findSession(id));
    }
}
