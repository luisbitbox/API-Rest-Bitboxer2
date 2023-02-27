package luis.ejercicio.bitboxer2.converter;

import luis.ejercicio.bitboxer2.dto.ItemDTO;
import luis.ejercicio.bitboxer2.dto.PriceReductionDTO;
import luis.ejercicio.bitboxer2.dto.SupplierDTO;
import luis.ejercicio.bitboxer2.model.Item;
import luis.ejercicio.bitboxer2.model.PriceReduction;
import luis.ejercicio.bitboxer2.model.Supplier;

import java.util.ArrayList;
import java.util.List;

public class ItemConverter {

    public  static ItemDTO toDTO(Item item){
        ItemDTO itemDTO= new ItemDTO();

        itemDTO.setIdItem(item.getIdItem());
        itemDTO.setItemCode(item.getItemCode());
        itemDTO.setDescription(item.getDescription());
        itemDTO.setPrice(item.getPrice());
        itemDTO.setState(item.getState());
        itemDTO.setCreation(item.getCreation());

        if(item.getSuppliers() != null){
            itemDTO.setSuppliers(new ArrayList<>());
            for(Supplier s: item.getSuppliers()){
                itemDTO.getSuppliers().add(SupplierConverter.toDTO(s));
            }
        }

        if(item.getPriceReductions() != null){
            itemDTO.setPriceReductions(new ArrayList<>());
            for(PriceReduction pr: item.getPriceReductions()){
                itemDTO.getPriceReductions().add(PriceReductionConverter.toDTO(pr));
            }
        }

        return itemDTO;
    }

    public  static Item toEntity(ItemDTO itemDTO){
        Item item= new Item();

        item.setIdItem(itemDTO.getIdItem());
        item.setItemCode(itemDTO.getItemCode());
        item.setDescription(itemDTO.getDescription());
        item.setState(itemDTO.getState());
        item.setPrice(itemDTO.getPrice());
        item.setCreation(itemDTO.getCreation());

        if(itemDTO.getSuppliers() != null){
            item.setSuppliers(new ArrayList<>());
            for(SupplierDTO s: itemDTO.getSuppliers()){
                item.getSuppliers().add(SupplierConverter.toEntity(s));
            }
        }

        if(itemDTO.getPriceReductions() != null){
            //item.setPriceReductions(new ArrayList<>());
            for(PriceReductionDTO pr: itemDTO.getPriceReductions()){
                item.addPriceReduction(PriceReductionConverter.toEntity(pr));
            }
        }

        return item;
    }

    public  static List<ItemDTO> toDTOList(List<Item> items){
        List<ItemDTO> itemsDTO = new ArrayList<>();

        for(Item i: items){
            itemsDTO.add(ItemConverter.toDTO(i));
        }
        return itemsDTO;
    }
}
