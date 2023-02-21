package luis.ejercicio.bitboxer2.service;

import luis.ejercicio.bitboxer2.dto.ItemDTO;
import luis.ejercicio.bitboxer2.dto.SupplierDTO;
import luis.ejercicio.bitboxer2.model.Item;

import java.util.List;
import java.util.Optional;

public interface SupplierService {
    List<SupplierDTO> findAllSuppliers();

    Optional<SupplierDTO> findSupplierById(Long idSupplier);

    void createSupplier(SupplierDTO supplierDTO);

    List<ItemDTO> findItemsBySupplierId(Long idSupplier);
}
