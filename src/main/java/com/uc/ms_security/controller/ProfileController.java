package com.uc.ms_security.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uc.ms_security.dto.profile.CreateProfileDTO;
import com.uc.ms_security.dto.profile.ProfileResponseDTO;
import com.uc.ms_security.dto.profile.UpdateProfileDTO;
import com.uc.ms_security.service.ProfileService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping({"/profiles", "/profiles/"})
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponseDTO create(@Valid @RequestBody CreateProfileDTO dto) {
        return profileService.create(dto);
    }

    @PostMapping("/users/{userId}/profile")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponseDTO createForUser(
            @PathVariable Long userId,
            @Valid @RequestBody CreateProfileDTO dto) {
        return profileService.create(userId, dto);
    }

    @GetMapping({"/profiles", "/profiles/"})
    public List<ProfileResponseDTO> findAll() {
        return profileService.findAll();
    }

    @GetMapping("/profiles/{id}")
    public ProfileResponseDTO findById(@PathVariable Long id) {
        return profileService.findById(id);
    }

    @GetMapping("/users/{userId}/profile")
    public ProfileResponseDTO findByUserId(@PathVariable Long userId) {
        return profileService.findByUserId(userId);
    }

    @PutMapping("/profiles/{id}")
    public ProfileResponseDTO update(@PathVariable Long id, @Valid @RequestBody UpdateProfileDTO dto) {
        return profileService.update(id, dto);
    }

    @PutMapping("/users/{userId}/profile")
    public ProfileResponseDTO updateForUser(
            @PathVariable Long userId,
            @Valid @RequestBody UpdateProfileDTO dto) {
        return profileService.updateByUserId(userId, dto);
    }

    @DeleteMapping("/profiles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        profileService.delete(id);
    }

    @DeleteMapping("/users/{userId}/profile")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteForUser(@PathVariable Long userId) {
        profileService.deleteByUserId(userId);
    }
}
