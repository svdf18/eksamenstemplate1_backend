package kea3.eksamenstemplate1_backend.template;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {


    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/all")
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Long id) {
        Optional<ItemDTO> itemDTO = Optional.ofNullable(itemService.getItemById(id));
        if (itemDTO.isPresent()) {
            return ResponseEntity.ok(itemDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO itemDTO) {
        try {
            ItemDTO createdItem = itemService.createItem(itemDTO);
            return ResponseEntity.ok(createdItem);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<ItemDTO> updateItem(@PathVariable Long id, @RequestBody ItemDTO itemDTO) {
        try {
            ItemDTO updatedItem = itemService.updateItem(id, itemDTO);
            return ResponseEntity.ok(updatedItem);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ItemDTO> deleteItem(@PathVariable Long id) {
        try {
            ItemDTO deletedItem = itemService.deleteItem(id);
            return ResponseEntity.ok(deletedItem);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
