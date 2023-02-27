package luis.ejercicio.bitboxer2.service;

import luis.ejercicio.bitboxer2.converter.ItemConverter;
import luis.ejercicio.bitboxer2.converter.UsuarioConverter;
import luis.ejercicio.bitboxer2.dto.UsuarioDTO;
import luis.ejercicio.bitboxer2.model.Usuario;
import luis.ejercicio.bitboxer2.repsitory.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        return UsuarioConverter.toDTOList(usuarios);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioDTO findUsuarioById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        UsuarioDTO usuarioDTO = UsuarioConverter.toDTO(usuario.get());
        return usuarioDTO;
    }

    @Override
    @Transactional
    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioConverter.toEntity(usuarioDTO);

        UsuarioDTO usuarioDTOSaved = UsuarioConverter.toDTO(usuarioRepository.save(usuario));
        return null;
    }
}
