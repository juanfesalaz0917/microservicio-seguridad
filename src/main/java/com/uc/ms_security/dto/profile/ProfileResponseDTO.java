package com.uc.ms_security.dto.profile;

import java.time.ZonedDateTime;

import lombok.Value;

@Value
public class ProfileResponseDTO {
    Long id;
    String phone;
    ZonedDateTime birthDate;
}
