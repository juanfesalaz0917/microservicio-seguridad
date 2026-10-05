package com.uc.ms_security.dto.session;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public  class SessionRequestDTO {
    @NotBlank(message = "El token es obligatorio.")
    private String token;

    @NotNull(message = "Debe haber una expiracion.")
    @Future(message = "La fecha de expiracion debe ser en el futuro.")
    private LocalDateTime expiration;

    @NotBlank(message = "Debe haber un codigo 2FA.")
    @Size(min = 6, max = 10, message = "El codigo 2FA debe tener entre 6 y 10 caracteres.")
    private String code2FA;
}
