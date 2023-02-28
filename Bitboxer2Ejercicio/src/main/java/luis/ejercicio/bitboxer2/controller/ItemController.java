package luis.ejercicio.bitboxer2.controller;

import luis.ejercicio.bitboxer2.dto.ItemDTO;
import luis.ejercicio.bitboxer2.dto.PriceReductionDTO;
import luis.ejercicio.bitboxer2.dto.SupplierDTO;
import luis.ejercicio.bitboxer2.dto.UsuarioDTO;
import luis.ejercicio.bitboxer2.enums.StateEnum;
import luis.ejercicio.bitboxer2.service.ItemService;
import luis.ejercicio.bitboxer2.service.PriceReductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

            return  ResponseEntity.ok().body(itemService.createItem(itemDTO));

        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getItem(@PathVariable Long id){
        try {
            ItemDTO itemDTO = itemService.findById(id);

            if(itemDTO == null){
                return ResponseEntity.notFound().build();
            }

            return  ResponseEntity.ok().body(itemDTO);
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
            ItemDTO oItem = itemService.findById(id);
            List<SupplierDTO> suppliers;

            if(oItem == null){
                return ResponseEntity.notFound().build();
            }

            if(oItem.getSuppliers() != null){
                suppliers = oItem.getSuppliers();
                return  ResponseEntity.ok().body(suppliers);
            }
            return  ResponseEntity.ok().body(new ArrayList<SupplierDTO>());
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}/priceReductions")
    ResponseEntity<?> getItemPriceReductions(@PathVariable Long id){
        try {
            List<PriceReductionDTO> priceReductions = itemService.findPriceReductionsByItemId(id);

            return  ResponseEntity.ok().body(priceReductions);
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<?>  updateItem(@PathVariable Long id, @RequestBody ItemDTO itemDTO){
        try {
            ItemDTO oItem = itemService.findById(id);

            if(oItem == null){
                return ResponseEntity.notFound().build();
            }

            // Si el Item tiene como state ACTIVE se permite editar
            if(StateEnum.ACTIVE.equals(oItem.getState())){
                oItem.setDescription(itemDTO.getDescription());
                oItem.setPrice(itemDTO.getPrice());
                oItem.setState(itemDTO.getState());
                oItem.setCreation(new Date());
                oItem.setSuppliers(itemDTO.getSuppliers());
                oItem.setPriceReductions(itemDTO.getPriceReductions());

                itemService.createItem(oItem);
            }

            return  ResponseEntity.status(HttpStatus.CREATED).build();

        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/addSupplier")
    ResponseEntity<?>  addSupplierToItem(@PathVariable Long id, @RequestBody SupplierDTO supplierDTO){
        try {
            ItemDTO oItem = itemService.findById(id);
            ItemDTO itemSaved = null;

            if(oItem == null){
                return ResponseEntity.notFound().build();
            }
            if (oItem.getSuppliers().contains(supplierDTO)){
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }

            // Si el Item tiene como state ACTIVE && si la lista no contiene al supplier se permite agregarlo
            if (StateEnum.ACTIVE.equals(oItem.getState())){

                oItem.addSupplier(supplierDTO);
                itemSaved = itemService.createItem(oItem);

            }

            return  ResponseEntity.status(HttpStatus.CREATED).body(itemSaved);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}/addCreator")
    ResponseEntity<?>  addSupplierToItem(@PathVariable Long id, @RequestBody UsuarioDTO creatorDTO){
        try {
            ItemDTO oItem = itemService.findById(id);
            System.out.println(creatorDTO.getUsername()+" - " + creatorDTO.getPassword() + " - " + creatorDTO.getRole());

            if(oItem == null){
                return ResponseEntity.notFound().build();
            }
            oItem.setCreator(creatorDTO);
            return  ResponseEntity.status(HttpStatus.CREATED).body(itemService.createItem(oItem));

        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

}
