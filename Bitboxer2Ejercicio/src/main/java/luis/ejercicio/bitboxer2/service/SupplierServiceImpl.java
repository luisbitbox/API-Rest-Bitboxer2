package luis.ejercicio.bitboxer2.service;

import luis.ejercicio.bitboxer2.converter.SupplierConverter;
import luis.ejercicio.bitboxer2.dto.ItemDTO;
import luis.ejercicio.bitboxer2.dto.SupplierDTO;
import luis.ejercicio.bitboxer2.model.Item;
import luis.ejercicio.bitboxer2.model.Supplier;
import luis.ejercicio.bitboxer2.repsitory.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    SupplierRepository supplierRepository;



    @Override
    @Transactional(readOnly = true)
    public List<SupplierDTO> findAllSuppliers() {
        List<Supplier> suppliers = supplierRepository.findAll();

        return SupplierConverter.toDTOList(suppliers);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SupplierDTO> findSupplierById(Long idSupplier) {
        Optional<Supplier> supplier = supplierRepository.findById(idSupplier);
        return supplier.map(SupplierConverter::toDTO);
    }

    @Override
    @Transactional
    public void createSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = SupplierConverter.toEntity(supplierDTO);
        supplierRepository.save(supplier);
    }


    @Override
    @Transactional(readOnly = true)
    public List<ItemDTO> findItemsBySupplierId(Long idSupplier) {
        List<Item> items = supplierRepository.findItemsBySupplierId(idSupplier);
        //return itemMapper.toDTOList(items);
        return null;
    }
}
