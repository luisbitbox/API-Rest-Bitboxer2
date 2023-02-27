package luis.ejercicio.bitboxer2.service;

import luis.ejercicio.bitboxer2.converter.ItemConverter;
import luis.ejercicio.bitboxer2.converter.PriceReductionConverter;
import luis.ejercicio.bitboxer2.dto.ItemDTO;
import luis.ejercicio.bitboxer2.dto.PriceReductionDTO;
import luis.ejercicio.bitboxer2.dto.SupplierDTO;
import luis.ejercicio.bitboxer2.model.Item;
import luis.ejercicio.bitboxer2.model.PriceReduction;
import luis.ejercicio.bitboxer2.model.Supplier;
import luis.ejercicio.bitboxer2.repsitory.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    @Autowired

    @Override
    @Transactional(readOnly = true)
    public List<ItemDTO> findAllItems() {
        List<Item> items = itemRepository.findAll();

        return ItemConverter.toDTOList(items);
    }

    @Override
    @Transactional(readOnly = true)
    public ItemDTO findById(Long idItem) {
        Optional<Item> item = itemRepository.findById(idItem);
        ItemDTO itemDTO = ItemConverter.toDTO(item.get());
        return itemDTO;
    }

    @Override
    @Transactional
    public ItemDTO createItem(ItemDTO itemDTO) {
        Item item = ItemConverter.toEntity(itemDTO);
        itemRepository.save(item);
        ItemDTO itemDTOSaved = ItemConverter.toDTO(itemRepository.save(item));

        return itemDTOSaved;
    }

    public List<PriceReductionDTO> getItemPriceReduction(Long idItem){
        Optional<Item> item = itemRepository.findById(idItem);
        List<PriceReduction> priceReductions = new ArrayList<>(item.get().getPriceReductions());
        List<PriceReductionDTO> priceReductionDTOS = PriceReductionConverter.toDTOList(priceReductions);

        return priceReductionDTOS;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SupplierDTO> findSuppliersByItemId(Long idItem) {
        List<Supplier> suppliers = itemRepository.findSuppliersByItemId(idItem);
        //return supplierMapper.toDTOList(suppliers);
        return  null;
    }

    @Override
    public List<PriceReductionDTO> findPriceReductionsByItemId(Long idItem) {
        List<PriceReduction> priceReductions = itemRepository.findPriceReductionsByItemId(idItem);
        return PriceReductionConverter.toDTOList(priceReductions);
    }


}
