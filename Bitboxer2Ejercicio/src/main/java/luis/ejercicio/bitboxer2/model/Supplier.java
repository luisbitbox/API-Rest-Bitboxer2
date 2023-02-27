package luis.ejercicio.bitboxer2.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idSupplier")
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@SequenceGenerator(name = "model_id_seq", sequenceName = "model_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "idsupplier")
    Long idSupplier;

    String name;

    String country;

    @ManyToMany(mappedBy = "suppliers")
    //@JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<Item> items;

    public void addItem(Item item){
        if(item != null){
            if(this.items == null){
                this.items = new ArrayList<>();
            }
            this.items.add(item);
        }
    }
}
