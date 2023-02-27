package luis.ejercicio.bitboxer2.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import luis.ejercicio.bitboxer2.enums.StateEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idItem")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@SequenceGenerator(name = "model_id_seq", sequenceName = "model_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "iditem")
    Long idItem;

    @Column(name = "itemcode", unique = true)
    Long itemCode;

    String description;

    Double price;

    @Enumerated(EnumType.STRING)
    StateEnum state;

    Date creation;

//    @ManyToOne
//    User creator;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "items_supplier",
            joinColumns = {@JoinColumn(name = "item_id")},
            inverseJoinColumns = {@JoinColumn(name = "supplier_id")}
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<Supplier> suppliers;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    List<PriceReduction> priceReductions;

    public void addSupplier(Supplier supplier){
        if(supplier != null){
            if(this.suppliers == null){
                this.suppliers = new ArrayList<>();
            }
            this.suppliers.add(supplier);
        }
    }

    public void addPriceReduction(PriceReduction priceReduction){
        if(priceReduction != null){
            if(this.priceReductions == null){
                this.priceReductions = new ArrayList<>();
            }
            priceReduction.setItem(this);
            this.priceReductions.add(priceReduction);
        }
    }
}
