package luis.ejercicio.bitboxer2.service;

import luis.ejercicio.bitboxer2.dto.ItemDTO;
import luis.ejercicio.bitboxer2.dto.SupplierDTO;

import java.util.List;
import java.util.Optional;

public interface ItemService{
    List<ItemDTO> findAllItems();

    Optional<ItemDTO> findById(Long idItem);

    void createItem(ItemDTO item);

    List<SupplierDTO> findSuppliersByItemId(Long idItem);
}
