package luis.ejercicio.bitboxer2.service;

import luis.ejercicio.bitboxer2.dto.PriceReductionDTO;
import luis.ejercicio.bitboxer2.mapper.PriceReductionMapper;
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

    @Autowired
    PriceReductionMapper priceReductionMapper;


    @Override
    public List<PriceReductionDTO> findAllPriceReductions() {
        List<PriceReduction> priceReductions = priceReductionRepository.findAll();

        return priceReductionMapper.toDTOList(priceReductions);
    }

    @Override
    public Optional<PriceReductionDTO> findPriceReductionById(Long id) {
        Optional<PriceReduction> priceReduction = priceReductionRepository.findById(id);
        return priceReduction.map(priceReductionMapper::toDTO);
    }

    @Override
    public void createPriceReduction(PriceReductionDTO priceReductionDTO) {
        PriceReduction priceReduction = priceReductionMapper.toEntity(priceReductionDTO);
        priceReductionRepository.save(priceReduction);
    }
}
