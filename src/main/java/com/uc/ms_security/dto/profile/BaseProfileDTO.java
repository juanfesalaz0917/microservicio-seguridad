    package com.uc.ms_security.dto.profile;

    import java.time.ZonedDateTime;

    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.Pattern;
    import lombok.Getter;
    import lombok.Setter;

    @Getter
    @Setter
    public abstract class BaseProfileDTO {
        @NotBlank(message = "El telefono es obligatorio.")
        @Pattern(
                regexp = "\\d{10}",
                message = "El teléfono debe contener exactamente 10 dígitos"
        )
        private String phone;

        @NotNull(message = "La fecha de Nacimiento es obligatoria.")
        private ZonedDateTime birthDate;
    }
