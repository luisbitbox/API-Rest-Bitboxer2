package luis.ejercicio.bitboxer2.controller;

import luis.ejercicio.bitboxer2.dto.ItemDTO;
import luis.ejercicio.bitboxer2.dto.PriceReductionDTO;
import luis.ejercicio.bitboxer2.service.PriceReductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/erp/api/priceReduction")
@CrossOrigin
public class PriceReductionController {

    @Autowired
    PriceReductionService priceReductionService;

    @PostMapping
    ResponseEntity<PriceReductionDTO> createPriceReduction(@RequestBody PriceReductionDTO priceReductionDTO){
        try {
            priceReductionService.createPriceReduction(priceReductionDTO);
            return  ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getPriceReduction(@PathVariable Long id){
        try {
            Optional<PriceReductionDTO> oPriceReduction = priceReductionService.findPriceReductionById(id);

            if(!oPriceReduction.isPresent()){
                return ResponseEntity.notFound().build();
            }
            return  ResponseEntity.ok().body(oPriceReduction);
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping
    ResponseEntity<?> getPriceReductions(){
        try {
            List<PriceReductionDTO> priceReductionDTOS = (List) priceReductionService.findAllPriceReductions();

            return  ResponseEntity.ok().body(priceReductionDTOS);
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<?>  updateItem(@PathVariable Long id, @RequestBody PriceReductionDTO priceReductionDTO){
        try {
            Optional<PriceReductionDTO> oPriceReduction = priceReductionService.findPriceReductionById(id);

            if(!oPriceReduction.isPresent()){
                return ResponseEntity.notFound().build();
            }

            oPriceReduction.get().setReducedPrice(priceReductionDTO.getReducedPrice());
            oPriceReduction.get().setStartDate(priceReductionDTO.getStartDate());
            oPriceReduction.get().setEndDate(priceReductionDTO.getEndDate());

            priceReductionService.createPriceReduction(oPriceReduction.get());

            return  ResponseEntity.status(HttpStatus.CREATED).build();

        }catch (Exception e){
            return  ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/item")
    ResponseEntity<?>  addPriceReductionToItem(@PathVariable Long id, @RequestBody ItemDTO itemDTO){
        try {
            Optional<PriceReductionDTO> oPriceReduction = priceReductionService.findPriceReductionById(id);

            if(!oPriceReduction.isPresent()){
                return ResponseEntity.notFound().build();
            }
            oPriceReduction.get().setItemDTO(itemDTO);

            priceReductionService.createPriceReduction(oPriceReduction.get());

            return  ResponseEntity.status(HttpStatus.CREATED).build();

        }catch (Exception e){
            return  ResponseEntity.badRequest().build();
        }
    }
}
