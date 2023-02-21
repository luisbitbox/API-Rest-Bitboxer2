package luis.ejercicio.bitboxer2.mapper;

import luis.ejercicio.bitboxer2.dto.SupplierDTO;
import luis.ejercicio.bitboxer2.model.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    SupplierMapper INSTANCE =  Mappers.getMapper(SupplierMapper.class);

    SupplierDTO toDTO(Supplier supplier);

    Supplier toEntity(SupplierDTO supplierDTO);

    List<SupplierDTO> toDTOList(List<Supplier> supliers);
}
