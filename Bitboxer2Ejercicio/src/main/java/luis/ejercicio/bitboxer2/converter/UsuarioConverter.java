package luis.ejercicio.bitboxer2.converter;

import luis.ejercicio.bitboxer2.dto.UsuarioDTO;
import luis.ejercicio.bitboxer2.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioConverter {

    public static UsuarioDTO toDTO(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setIdUsuario(usuario.getIdCreator());
        usuarioDTO.setUsername(usuario.getUsername());
        usuarioDTO.setPassword(usuario.getPassword());
        usuarioDTO.setRole(usuario.getRole());

        /*if(usuario.getItems() != null){
            usuarioDTO.setItems(ItemConverter.toDTOList(usuario.getItems()));
        }*/

        return usuarioDTO;
    }

    public static Usuario toEntity(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();

        usuario.setIdCreator(usuarioDTO.getIdUsuario());
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setRole(usuarioDTO.getRole());

        if(usuarioDTO.getItems() != null){
            //usuario.setItems(ItemConverter.toEntity(usuarioDTO.getItems()));
        }

        return usuario;
    }

    public static List<UsuarioDTO> toDTOList(List<Usuario> usuarios){
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();

        for (Usuario u: usuarios){
            usuarioDTOS.add(UsuarioConverter.toDTO(u));
        }
        return usuarioDTOS;
    }
}
