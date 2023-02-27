package luis.ejercicio.bitboxer2.dto;

import lombok.*;
import luis.ejercicio.bitboxer2.enums.StateEnum;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDTO {
    Long idItem;

    Long itemCode;

    String description;

    Double price;

    StateEnum state;

    Date creation;

    UsuarioDTO creator;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<SupplierDTO> suppliers;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<PriceReductionDTO> priceReductions;

    public void addSupplier(SupplierDTO supplier){
        if(supplier != null){
            if(this.suppliers == null){
                this.suppliers = new ArrayList<>();
            }
            this.suppliers.add(supplier);
        }
    }

    public void addPriceReduction(PriceReductionDTO priceReductionDTO){
        if(priceReductionDTO != null){
            if(this.priceReductions == null){
                this.priceReductions = new ArrayList<>();
            }
            priceReductionDTO.setItemDTO(this);
            this.priceReductions.add(priceReductionDTO);
        }
    }
}
