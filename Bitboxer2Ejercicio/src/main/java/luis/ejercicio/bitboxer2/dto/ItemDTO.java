package luis.ejercicio.bitboxer2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import luis.ejercicio.bitboxer2.enums.StateEnum;
import luis.ejercicio.bitboxer2.model.Creator;


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

    Creator creator;

    List<SupplierDTO> suppliers;

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
            this.priceReductions.add(priceReductionDTO);
        }
    }
}
