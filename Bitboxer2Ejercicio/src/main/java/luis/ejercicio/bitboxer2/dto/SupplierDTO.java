package luis.ejercicio.bitboxer2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import luis.ejercicio.bitboxer2.model.Item;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierDTO {
    Long idSupplier;

    String name;

    String country;

    List<Item> items;
}
