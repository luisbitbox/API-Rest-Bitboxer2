package luis.ejercicio.bitboxer2.repsitory;

import luis.ejercicio.bitboxer2.model.Item;
import luis.ejercicio.bitboxer2.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query("SELECT s.items FROM Supplier s WHERE s.idSupplier = :id")
    List<Item> findItemsBySupplierId(@Param("id") Long id);

}
