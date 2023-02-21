package luis.ejercicio.bitboxer2.mapper;

import luis.ejercicio.bitboxer2.dto.ItemDTO;
import luis.ejercicio.bitboxer2.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    ItemDTO toDTO(Item item);

    Item toEntity(ItemDTO itemDTO);

    List<ItemDTO> toDTOList(List<Item> items);
}
