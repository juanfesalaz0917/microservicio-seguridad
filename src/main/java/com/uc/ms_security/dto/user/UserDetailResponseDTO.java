package com.uc.ms_security.dto.user;

import com.uc.ms_security.dto.profile.ProfileResponseDTO;
import lombok.Value;

//Dto detallado donde voy a traer tambien las relaciones de la entidad User, en este caso el profile
@Value //El decorador value sirve para que la clase sea inmutable, es decir, que no se pueda modificar una vez creada. Esto es útil para los DTOs, ya que normalmente no queremos que se modifiquen una vez creados.
public class UserDetailResponseDTO {
    Long id;
    String name;
    String email;
    ProfileResponseDTO profile;
}