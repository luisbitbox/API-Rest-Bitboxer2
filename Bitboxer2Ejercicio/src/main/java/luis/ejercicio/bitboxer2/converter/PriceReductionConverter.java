package luis.ejercicio.bitboxer2.converter;

import luis.ejercicio.bitboxer2.dto.PriceReductionDTO;
import luis.ejercicio.bitboxer2.model.PriceReduction;

import java.util.ArrayList;
import java.util.List;

public class PriceReductionConverter {

    public static PriceReduction toEntity (PriceReductionDTO dto){
        PriceReduction priceReduction = new PriceReduction();
        priceReduction.setIdPriceReduction(dto.getIdPriceReduction());
        priceReduction.setReducedPrice(dto.getReducedPrice());
        priceReduction.setStartDate(dto.getStartDate());
        priceReduction.setEndDate(dto.getEndDate());

        if(dto.getItemDTO() != null){
            priceReduction.setItem(ItemConverter.toEntity(dto.getItemDTO()));
        }

        return priceReduction;

    }

    public static PriceReductionDTO toDTO (PriceReduction priceReduction){
        PriceReductionDTO dto = new PriceReductionDTO();
        dto.setIdPriceReduction(priceReduction.getIdPriceReduction());
        dto.setReducedPrice(priceReduction.getReducedPrice());
        dto.setStartDate(priceReduction.getStartDate());
        dto.setEndDate(priceReduction.getEndDate());

        return dto;
    }

    public static List<PriceReductionDTO> toDTOList(List<PriceReduction> priceReductions){
        List<PriceReductionDTO> priceReductionDTOS = new ArrayList<>();

        for (PriceReduction pr: priceReductions){
            priceReductionDTOS.add(PriceReductionConverter.toDTO(pr));
        }
        return priceReductionDTOS;
    }
}
