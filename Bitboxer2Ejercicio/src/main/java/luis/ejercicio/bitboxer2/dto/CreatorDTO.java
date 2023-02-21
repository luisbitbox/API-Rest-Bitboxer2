package luis.ejercicio.bitboxer2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatorDTO {

    Long idCreator;

    String name;

    String password;
}
