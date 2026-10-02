package com.uc.ms_security.dto.session;

import java.time.ZonedDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseSessionDTO {
    @NotBlank(message = "El token es obligatorio.")
    private String token;

    @NotNull(message = "Debe haber una expiracion.")
    private ZonedDateTime expiration;

    @NotBlank(message = "Debe haber un codigo 2FA.")
    private String code2FA;
}
