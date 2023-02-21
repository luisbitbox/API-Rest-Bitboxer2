package luis.ejercicio.bitboxer2.controller;

import luis.ejercicio.bitboxer2.dto.ItemDTO;
import luis.ejercicio.bitboxer2.dto.PriceReductionDTO;
import luis.ejercicio.bitboxer2.dto.SupplierDTO;
import luis.ejercicio.bitboxer2.enums.StateEnum;
import luis.ejercicio.bitboxer2.service.ItemService;
import luis.ejercicio.bitboxer2.service.PriceReductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/erp/api/item")
@CrossOrigin
public class ItemController {

    @Autowired
    ItemService itemService;
    @Autowired
    PriceReductionService priceReductionService;


    @PostMapping
    ResponseEntity<ItemDTO>  createItem(@RequestBody ItemDTO itemDTO){
        try {
            itemDTO.setState(StateEnum.ACTIVE);
            itemDTO.setCreation(new Date());

            System.out.println(itemDTO.getIdItem() + "  " + itemDTO.getDescription() + "  " + itemDTO.getPrice()+ "  " + itemDTO.getItemCode());

            itemService.createItem(itemDTO);
            return  ResponseEntity.ok().build();

        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getItem(@PathVariable Long id){
        try {
            Optional<ItemDTO> itemDTO = itemService.findById(id);

            if (!itemDTO.isPresent()){
                return ResponseEntity.notFound().build();
            }
            return  ResponseEntity.ok().body(itemDTO.get());
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping
    ResponseEntity<?> getItems(){
        try {
            List<ItemDTO> items = (List)itemService.findAllItems();

            return  ResponseEntity.ok().body(items);
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}/suppliers")
    ResponseEntity<?> getItemSuppliers(@PathVariable Long id){
        try {
            List<SupplierDTO> suppliers = (List)itemService.findSuppliersByItemId(id);

            return  ResponseEntity.ok().body(suppliers);
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}/priceReductions")
    ResponseEntity<?> getItemPriceReductions(@PathVariable Long id){
        try {
            List<PriceReductionDTO> priceReductions = (List) itemService.findPriceReductionsByItemId(id);
            for (PriceReductionDTO pr: priceReductions
                 ) {
                System.out.println(pr.getReducedPrice() + " - " + pr.getStartDate() + " - " + pr.getEndDate());
            }

            return  ResponseEntity.ok().body(priceReductions);
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<?>  updateItem(@PathVariable Long id, @RequestBody ItemDTO itemDTO){
        try {
            Optional<ItemDTO> oItem = itemService.findById(id);

            if (!oItem.isPresent()){
                return ResponseEntity.notFound().build();
            }

            // Si el Item tiene como state ACTIVE se permite editar
            if(StateEnum.ACTIVE.equals(oItem.get().getState())){
                oItem.get().setDescription(itemDTO.getDescription());
                oItem.get().setPrice(itemDTO.getPrice());
                oItem.get().setState(itemDTO.getState());
                oItem.get().setCreation(new Date());
                oItem.get().setSuppliers(itemDTO.getSuppliers());
                oItem.get().setPriceReductions(itemDTO.getPriceReductions());

                itemService.createItem(oItem.get());
            }


            return  ResponseEntity.status(HttpStatus.CREATED).build();

        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/addSupplier")
    ResponseEntity<?>  addSupplierToItem(@PathVariable Long id, @RequestBody SupplierDTO supplierDTO){
        try {
            Optional<ItemDTO> oItem = itemService.findById(id);

            if (!oItem.isPresent()){
                return ResponseEntity.notFound().build();
            }
                oItem.get().addSupplier(supplierDTO);
                itemService.createItem(oItem.get());

            // Si el Item tiene como state ACTIVE se permite añadirle un supplier
            /*if(StateEnum.ACTIVE.equals(oItem.get().getState())){
                //List<SupplierDTO> listaSupplier = oItem.get().getSuppliers();

                //Si la lista es null o  no incluye el supplier se le añade
                if(!oItem.get().getSuppliers().contains(supplierDTO)){
                }*/

            //}


            return  ResponseEntity.status(HttpStatus.CREATED).build();

        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping("/{id}/addPriceReduction")
    ResponseEntity<?> addPriceReduction(@PathVariable Long id, @RequestBody PriceReductionDTO priceReductionDTO){
        try{
            Optional<ItemDTO> oItem = itemService.findById(id);

            if (!oItem.isPresent()){
                return ResponseEntity.notFound().build();
            }
            if(priceReductionDTO!= null){
                priceReductionService.createPriceReduction(priceReductionDTO);
                oItem.get().addPriceReduction(priceReductionDTO);
                itemService.createItem(oItem.get());
                /*for(PriceReductionDTO pr: oItem.get().getPriceReductions()){
                    System.out.println(pr.toString());
                }*/
            }

            return  ResponseEntity.status(HttpStatus.CREATED).build();

        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
