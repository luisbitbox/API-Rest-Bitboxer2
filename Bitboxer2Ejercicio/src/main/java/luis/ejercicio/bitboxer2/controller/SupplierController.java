package luis.ejercicio.bitboxer2.controller;

import luis.ejercicio.bitboxer2.dto.SupplierDTO;
import luis.ejercicio.bitboxer2.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/erp/api/supplier")
@CrossOrigin
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @PostMapping
    ResponseEntity<SupplierDTO> createSupplier(@RequestBody SupplierDTO supplierDTO){
        try {
            supplierService.createSupplier(supplierDTO);
            return  ResponseEntity.ok().build();

        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getSupplier(@PathVariable Long id){
        try {
            Optional<SupplierDTO> oSupplier = supplierService.findSupplierById(id);

            if (!oSupplier.isPresent()){
                return  ResponseEntity.notFound().build();
            }
            return  ResponseEntity.ok().body(oSupplier.get());
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping
    ResponseEntity<?> getSuppliers(){
        try {
            List<SupplierDTO> suppliers = (List) supplierService.findAllSuppliers();

            return  ResponseEntity.ok().body(suppliers);
        }catch (Exception e){
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping
    ResponseEntity<SupplierDTO> updateSupplier(@PathVariable Long id, @RequestBody SupplierDTO supplierDTO){
        try {
            Optional<SupplierDTO> oSupplier = supplierService.findSupplierById(id);

            if (!oSupplier.isPresent()){
                return  ResponseEntity.notFound().build();
            }

            oSupplier.get().setName(supplierDTO.getName());
            oSupplier.get().setCountry(supplierDTO.getCountry());
            oSupplier.get().setItems(supplierDTO.getItems());

            supplierService.createSupplier(oSupplier.get());

            return  ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
