package luis.ejercicio.bitboxer2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import luis.ejercicio.bitboxer2.enums.Role;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    Long idUsuario;

    String username;

    String password;

    Role role;

    List<ItemDTO> items;

}
