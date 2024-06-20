package kea3.eksamenstemplate1_backend.config;

import kea3.eksamenstemplate1_backend.agegroup.AgeGroup;
import kea3.eksamenstemplate1_backend.agegroup.AgeGroupEnum;
import kea3.eksamenstemplate1_backend.agegroup.AgeGroupRepository;
import kea3.eksamenstemplate1_backend.club.Club;
import kea3.eksamenstemplate1_backend.club.ClubRepository;
import kea3.eksamenstemplate1_backend.discipline.DisciplineRepository;
import kea3.eksamenstemplate1_backend.discipline.Discipline;
import kea3.eksamenstemplate1_backend.result.resulttype.ResultTypeEnum;
import kea3.eksamenstemplate1_backend.template.Item;
import kea3.eksamenstemplate1_backend.template.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InitData implements CommandLineRunner {


    private final ItemRepository itemRepository;
    private final ClubRepository clubRepository;
    private final AgeGroupRepository ageGroupRepository;
    private final DisciplineRepository disciplineRepository;


    public InitData(ItemRepository itemRepository,
                    ClubRepository clubRepository,
                    AgeGroupRepository ageGroupRepository,
                    DisciplineRepository disciplineRepository) {

        this.itemRepository = itemRepository;
        this.clubRepository = clubRepository;
        this.ageGroupRepository = ageGroupRepository;
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("Hello from InitData");
        createItems();
        createClubs();
        createAgeGroups();
        createDisciplines();
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
        System.out.println("Creating clubs");
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

    private void createAgeGroups() {
        System.out.println("Creating age groups");
        List<AgeGroup> ageGroups = List.of(
                new AgeGroup(AgeGroupEnum.YOUTH),
                new AgeGroup(AgeGroupEnum.JUNIOR),
                new AgeGroup(AgeGroupEnum.ADULT),
                new AgeGroup(AgeGroupEnum.SENIOR)
        );

        for (AgeGroup ageGroup : ageGroups) {
            AgeGroup existingAgeGroup = ageGroupRepository.findByAgeGroupName(ageGroup.getAgeGroupName());
            if (existingAgeGroup == null) {
                ageGroupRepository.save(ageGroup);
            }
        }
    }

    private void createDisciplines() {
        System.out.println("Creating disciplines");
        List<Discipline> disciplines = List.of(
                // Men's disciplines
                new Discipline("5000m", Discipline.GenderEnum.MENS, ResultTypeEnum.TIME),
                new Discipline("10000m", Discipline.GenderEnum.MENS, ResultTypeEnum.TIME),
                new Discipline("1500m", Discipline.GenderEnum.MENS, ResultTypeEnum.TIME),
                new Discipline("800m", Discipline.GenderEnum.MENS, ResultTypeEnum.TIME),
                new Discipline("400m", Discipline.GenderEnum.MENS, ResultTypeEnum.TIME),
                new Discipline("Javelin", Discipline.GenderEnum.MENS, ResultTypeEnum.DISTANCE),
                new Discipline("Discus", Discipline.GenderEnum.MENS, ResultTypeEnum.DISTANCE),
                new Discipline("Triple Jump", Discipline.GenderEnum.MENS, ResultTypeEnum.DISTANCE),
                new Discipline("Pole Vault", Discipline.GenderEnum.MENS, ResultTypeEnum.DISTANCE),
                new Discipline("Long Jump", Discipline.GenderEnum.MENS, ResultTypeEnum.DISTANCE),
                new Discipline("High Jump", Discipline.GenderEnum.MENS, ResultTypeEnum.DISTANCE),
                new Discipline("Decathlon", Discipline.GenderEnum.MENS, ResultTypeEnum.POINTS),

                // Women's disciplines
                new Discipline("5000m", Discipline.GenderEnum.WOMENS, ResultTypeEnum.TIME),
                new Discipline("10000m", Discipline.GenderEnum.WOMENS, ResultTypeEnum.TIME),
                new Discipline("1500m", Discipline.GenderEnum.WOMENS, ResultTypeEnum.TIME),
                new Discipline("800m", Discipline.GenderEnum.WOMENS, ResultTypeEnum.TIME),
                new Discipline("400m", Discipline.GenderEnum.WOMENS, ResultTypeEnum.TIME),
                new Discipline("Javelin", Discipline.GenderEnum.WOMENS, ResultTypeEnum.DISTANCE),
                new Discipline("Discus", Discipline.GenderEnum.WOMENS, ResultTypeEnum.DISTANCE),
                new Discipline("Triple Jump", Discipline.GenderEnum.WOMENS, ResultTypeEnum.DISTANCE),
                new Discipline("Pole Vault", Discipline.GenderEnum.WOMENS, ResultTypeEnum.DISTANCE),
                new Discipline("Long Jump", Discipline.GenderEnum.WOMENS, ResultTypeEnum.DISTANCE),
                new Discipline("High Jump", Discipline.GenderEnum.WOMENS, ResultTypeEnum.DISTANCE),
                new Discipline("Heptathlon", Discipline.GenderEnum.WOMENS, ResultTypeEnum.POINTS),

                new Discipline("4x400 Relay", Discipline.GenderEnum.MIXED, ResultTypeEnum.TIME)

                 );

        for (Discipline discipline : disciplines) {
            Optional<Discipline> existingDiscipline = disciplineRepository.findByNameAndGender(discipline.getName(), discipline.getGender());
            if (existingDiscipline.isEmpty()) {
                disciplineRepository.save(discipline);
            }
        }

    }
}
