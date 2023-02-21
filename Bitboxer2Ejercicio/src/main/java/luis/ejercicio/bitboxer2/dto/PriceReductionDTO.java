package luis.ejercicio.bitboxer2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import luis.ejercicio.bitboxer2.model.Item;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceReductionDTO {
    Long idPriceReduction;
    Double reducedPrice;
    Date startDate;
    Date endDate;
    Item item;
}
