package luis.ejercicio.bitboxer2.repsitory;

import luis.ejercicio.bitboxer2.dto.SupplierDTO;
import luis.ejercicio.bitboxer2.model.Item;
import luis.ejercicio.bitboxer2.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT i.suppliers FROM Item i WHERE i.idItem = :id")
    List<Supplier> findSuppliersByItemId(@Param("id") Long id);

}
