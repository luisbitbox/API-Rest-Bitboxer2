package luis.ejercicio.bitboxer2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import luis.ejercicio.bitboxer2.model.Item;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierDTO {
    Long idSupplier;

    String name;

    String country;

    List<ItemDTO> items;

    public  void addItemDTO(ItemDTO itemDTO){
        if (itemDTO != null){
            if(this.items == null){
                this.items = new ArrayList<>();
            }
            this.items.add(itemDTO);
        }
    }
}
