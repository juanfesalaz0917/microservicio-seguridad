    package com.uc.ms_security.dto.profile;

    import java.time.LocalDate;

    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.Pattern;
    import jakarta.validation.constraints.Past;
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
        @Past(message = "La fecha de nacimiento debe estar en el pasado.")
        private LocalDate birthDate;
    }
