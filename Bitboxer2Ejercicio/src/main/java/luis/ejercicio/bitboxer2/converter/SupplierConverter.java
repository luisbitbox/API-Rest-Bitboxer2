package luis.ejercicio.bitboxer2.converter;

import luis.ejercicio.bitboxer2.dto.SupplierDTO;
import luis.ejercicio.bitboxer2.model.Item;
import luis.ejercicio.bitboxer2.model.Supplier;

import java.util.ArrayList;
import java.util.List;

public class SupplierConverter {

    public static SupplierDTO toDTO(Supplier supplier){
        SupplierDTO supplierDTO = new SupplierDTO();

        supplierDTO.setIdSupplier(supplier.getIdSupplier());
        supplierDTO.setName(supplier.getName());
        supplierDTO.setCountry(supplier.getCountry());

        /*if (supplier.getItems() != null){
            supplierDTO.setItems(new ArrayList<>());
            for (Item i: supplier.getItems()){
                supplierDTO.getItems().add(ItemConverter.toDTO(i));
            }
        }*/

        return supplierDTO;
    }

    public static Supplier toEntity(SupplierDTO supplierDTO){
        Supplier supplier = new Supplier();

        supplier.setIdSupplier(supplierDTO.getIdSupplier());
        supplier.setName(supplierDTO.getName());
        supplier.setCountry(supplierDTO.getCountry());

        /*if (supplierDTO.getItems() != null){
            supplierDTO.setItems(new ArrayList<>());
            for (ItemDTO i: supplierDTO.getItems()){
                supplier.getItems().add(ItemConverter.toEntity(i));
            }
        }*/

        return supplier;
    }


    public static List<SupplierDTO> toDTOList(List<Supplier> suppliers){
        List<SupplierDTO> supplierDTOS = new ArrayList<>();

        for (Supplier s: suppliers){
            supplierDTOS.add(SupplierConverter.toDTO(s));
        }
        return  supplierDTOS;
    }
}
