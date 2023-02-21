package luis.ejercicio.bitboxer2.repsitory;

import luis.ejercicio.bitboxer2.model.PriceReduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceReductionRepository extends JpaRepository<PriceReduction, Long> {
}
