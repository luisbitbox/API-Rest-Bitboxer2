package luis.ejercicio.bitboxer2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@SequenceGenerator(name = "model_id_seq", sequenceName = "model_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "idsupplier")
    Long idSupplier;

    String name;

    String country;

    @ManyToMany(mappedBy = "suppliers")
    List<Item> items;

}
