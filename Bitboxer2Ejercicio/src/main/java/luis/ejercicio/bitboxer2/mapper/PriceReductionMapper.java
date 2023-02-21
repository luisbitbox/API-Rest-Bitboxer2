package luis.ejercicio.bitboxer2.mapper;

import luis.ejercicio.bitboxer2.dto.PriceReductionDTO;
import luis.ejercicio.bitboxer2.model.PriceReduction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceReductionMapper {

    PriceReductionMapper INSTANCE = Mappers.getMapper(PriceReductionMapper.class);

    PriceReductionDTO toDTO(PriceReduction priceReduction);

    PriceReduction toEntity(PriceReductionDTO priceReductionDTO);

    List <PriceReductionDTO> toDTOList(List<PriceReduction> priceReductions);
}
