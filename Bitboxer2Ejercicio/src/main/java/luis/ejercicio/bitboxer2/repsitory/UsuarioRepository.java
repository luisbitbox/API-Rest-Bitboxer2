package luis.ejercicio.bitboxer2.repsitory;

import luis.ejercicio.bitboxer2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
