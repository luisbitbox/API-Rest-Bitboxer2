package luis.ejercicio.bitboxer2.service;

import luis.ejercicio.bitboxer2.dto.ItemDTO;
import luis.ejercicio.bitboxer2.dto.PriceReductionDTO;
import luis.ejercicio.bitboxer2.dto.SupplierDTO;

import java.util.List;
import java.util.Optional;

public interface ItemService{
    List<ItemDTO> findAllItems();

    ItemDTO findById(Long idItem);

    ItemDTO createItem(ItemDTO item);

    List<SupplierDTO> findSuppliersByItemId(Long idItem);

    List<PriceReductionDTO> findPriceReductionsByItemId(Long idItem);
}
