package luis.ejercicio.bitboxer2.controller;

import luis.ejercicio.bitboxer2.dto.UsuarioDTO;
import luis.ejercicio.bitboxer2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/erp/api/auth")
@CrossOrigin
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    ResponseEntity<?> createUsuario(@RequestBody UsuarioDTO usuarioDTO){
        try{
            return  ResponseEntity.ok().body(usuarioService.createUsuario(usuarioDTO));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getUsuario(@PathVariable Long id){
        try{
            UsuarioDTO oUsuario = usuarioService.findUsuarioById(id);

            if (oUsuario == null){
                return ResponseEntity.notFound().build();
            }


            return  ResponseEntity.ok().body(oUsuario);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping
    ResponseEntity<?> getUsuarios(){
        try{
            List<UsuarioDTO> usuarios = usuarioService.findAllUsuarios();

            return  ResponseEntity.ok().body(usuarios);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.noContent().build();
        }
    }

}
