package luis.ejercicio.bitboxer2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Creator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcreator")
    Long idCreator;

    String name;

    String password;
}
