package kea3.eksamenstemplate1_backend.template;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
