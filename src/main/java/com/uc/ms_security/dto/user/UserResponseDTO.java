package com.uc.ms_security.dto.user;

// Valida la seguridad de salida de los datos, para garantizar que datos sensibles que deban ser privados no se vayan en la respuesta
import lombok.Value;

@Value
public class UserResponseDTO {
    Long id;
    String name;
    String email;
}
