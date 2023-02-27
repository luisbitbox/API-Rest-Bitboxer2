package luis.ejercicio.bitboxer2.service;

import luis.ejercicio.bitboxer2.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDTO> findAllUsuarios();

    UsuarioDTO findUsuarioById(Long id);

    UsuarioDTO createUsuario(UsuarioDTO usuarioDTO);


}
