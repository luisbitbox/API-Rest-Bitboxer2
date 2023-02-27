package luis.ejercicio.bitboxer2.service;

import luis.ejercicio.bitboxer2.converter.PriceReductionConverter;
import luis.ejercicio.bitboxer2.dto.PriceReductionDTO;
import luis.ejercicio.bitboxer2.model.PriceReduction;
import luis.ejercicio.bitboxer2.repsitory.PriceReductionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceReductionServiceImpl implements  PriceReductionService{

    @Autowired
    PriceReductionRepository priceReductionRepository;


    @Override
    public List<PriceReductionDTO> findAllPriceReductions() {
        List<PriceReduction> priceReductions = priceReductionRepository.findAll();

        return PriceReductionConverter.toDTOList(priceReductions);
    }

    @Override
    public Optional<PriceReductionDTO> findPriceReductionById(Long id) {
        Optional<PriceReduction> priceReduction = priceReductionRepository.findById(id);
        return priceReduction.map(PriceReductionConverter::toDTO);
    }

    @Override
    public PriceReductionDTO createPriceReduction(PriceReductionDTO priceReductionDTO) {
        PriceReduction priceReduction = PriceReductionConverter.toEntity(priceReductionDTO);
        PriceReductionDTO priceReductionDTOSaved = PriceReductionConverter.toDTO(priceReductionRepository.save(priceReduction));

        return  priceReductionDTOSaved;
    }
}
