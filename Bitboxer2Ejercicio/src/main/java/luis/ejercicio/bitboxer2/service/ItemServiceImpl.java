package luis.ejercicio.bitboxer2.service;

import luis.ejercicio.bitboxer2.dto.ItemDTO;
import luis.ejercicio.bitboxer2.dto.SupplierDTO;
import luis.ejercicio.bitboxer2.mapper.ItemMapper;
import luis.ejercicio.bitboxer2.mapper.SupplierMapper;
import luis.ejercicio.bitboxer2.model.Item;
import luis.ejercicio.bitboxer2.model.Supplier;
import luis.ejercicio.bitboxer2.repsitory.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    SupplierMapper supplierMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ItemDTO> findAllItems() {
        List<Item> items = itemRepository.findAll();

        return itemMapper.toDTOList(items);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ItemDTO> findById(Long idItem) {
        Optional<Item> item = itemRepository.findById(idItem);
        return item.map(itemMapper::toDTO);
    }

    @Override
    @Transactional
    public void createItem(ItemDTO itemDTO) {
        Item item = itemMapper.toEntity(itemDTO);
        itemRepository.save(item);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SupplierDTO> findSuppliersByItemId(Long idItem) {
        List<Supplier> suppliers = itemRepository.findSuppliersByItemId(idItem);
        return supplierMapper.toDTOList(suppliers);
    }


}
