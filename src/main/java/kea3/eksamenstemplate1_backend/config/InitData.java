package kea3.eksamenstemplate1_backend.config;

import kea3.eksamenstemplate1_backend.club.Club;
import kea3.eksamenstemplate1_backend.club.ClubRepository;
import kea3.eksamenstemplate1_backend.template.Item;
import kea3.eksamenstemplate1_backend.template.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitData implements CommandLineRunner {


    private final ItemRepository itemRepository;
    private final ClubRepository clubRepository;

    public InitData(ItemRepository itemRepository, ClubRepository clubRepository) {
        this.itemRepository = itemRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("Hello from InitData");
        createItems();
        createClubs();
    }

    public void createItems() {
        System.out.println("Data created");
        List<Item> items = List.of(
                new Item("Item 1"),
                new Item("Item 2"),
                new Item("Item 3"),
                new Item("Item 4"),
                new Item("Item 5")
        );

        for (Item item : items) {

            Item existingItem = itemRepository.findByName(item.getName());
            if (existingItem == null) {
                itemRepository.save(item);
            }
        }
    }

    private void createClubs() {
        List<Club> clubs = List.of(
                new Club("Dragonhawk Athletics", "Tokyo"),
                new Club("Samurai Tiger Track Club", "Osaka"),
                new Club("Phoenix Eagle Runners", "New York"),
                new Club("Ninja Wolf Athletics", "Los Angeles"),
                new Club("Thunder Falcon Track and Field", "Chicago"),
                new Club("Ronin Bear Athletic Club", "San Francisco"),
                new Club("Sakura Panther Athletics", "Kyoto"),
                new Club("Shuriken Shark Track Team", "Miami"),
                new Club("Dynasty Lion Track Club", "Beijing"),
                new Club("Rising Dragon Athletic Association", "Seoul")
        );

        for (Club club : clubs) {
            Club existingClub = clubRepository.findByName(club.getName());
            if (existingClub == null) {
                clubRepository.save(club);
            }
        }
    }
}