package luis.ejercicio.bitboxer2.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPriceReduction")
public class PriceReduction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@SequenceGenerator(name = "model_id_seq", sequenceName = "model_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "idpricereduction")
    Long idPriceReduction;

    @Column(name = "reducedprice")
    Double reducedPrice;

    @Column(name = "startdate")
    Date startDate;

    @Column(name = "enddate")
    Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "item_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    Item item;
}
