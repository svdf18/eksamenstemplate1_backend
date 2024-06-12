package kea3.eksamenstemplate1_backend.config;

import kea3.eksamenstemplate1_backend.template.Item;
import kea3.eksamenstemplate1_backend.template.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitData implements CommandLineRunner {


    private final ItemRepository itemRepository;

    public InitData(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("Hello from InitData");
        createData();
    }

    public void createData() {
        System.out.println("Data created");
        List<Item> items = List.of(
                new Item("Item 1"),
                new Item("Item 2"),
                new Item("Item 3"),
                new Item("Item 4")
        );

        for (Item item : items) {

            Item existingItem = itemRepository.findByName(item.getName());
            if (existingItem == null) {
                itemRepository.save(item);
            }
        }
    }
}
