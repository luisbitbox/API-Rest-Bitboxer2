package luis.ejercicio.bitboxer2.service;

import luis.ejercicio.bitboxer2.dto.PriceReductionDTO;

import java.util.List;
import java.util.Optional;

public interface PriceReductionService {

    List<PriceReductionDTO> findAllPriceReductions();

    Optional<PriceReductionDTO> findPriceReductionById(Long id);

    void createPriceReduction(PriceReductionDTO priceReductionDTO);
}
