package kea3.eksamenstemplate1_backend.template;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {


    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();
return items.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ItemDTO getItemById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found with ID: " + id));
        return convertToDTO(item);
    }

    public ItemDTO createItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setName(itemDTO.getName());

        itemRepository.save(item);

        return convertToDTO(item);
    }

    public ItemDTO updateItem(Long id, ItemDTO itemDTO) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found with ID: " + id));
        item.setName(itemDTO.getName());

        itemRepository.save(item);

        return convertToDTO(item);
    }

    public ItemDTO deleteItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found with ID: " + id));
        itemRepository.delete(item);
        return convertToDTO(item);
    }

    public ItemDTO convertToDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setName(item.getName());
        return itemDTO;
    }
}
