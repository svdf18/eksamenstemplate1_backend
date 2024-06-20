package kea3.eksamenstemplate1_backend.config;

import kea3.eksamenstemplate1_backend.agegroup.AgeGroup;
import kea3.eksamenstemplate1_backend.agegroup.AgeGroupEnum;
import kea3.eksamenstemplate1_backend.agegroup.AgeGroupRepository;
import kea3.eksamenstemplate1_backend.athlete.Athlete;
import kea3.eksamenstemplate1_backend.athlete.AthleteRepository;
import kea3.eksamenstemplate1_backend.club.Club;
import kea3.eksamenstemplate1_backend.club.ClubRepository;
import kea3.eksamenstemplate1_backend.discipline.DisciplineRepository;
import kea3.eksamenstemplate1_backend.discipline.Discipline;
import kea3.eksamenstemplate1_backend.result.resultdistance.ResultDistance;
import kea3.eksamenstemplate1_backend.result.resulttime.ResultTime;
import kea3.eksamenstemplate1_backend.result.resulttype.ResultType;
import kea3.eksamenstemplate1_backend.result.resulttype.ResultTypeEnum;
import kea3.eksamenstemplate1_backend.result.resulttype.ResultTypeRepository;
import kea3.eksamenstemplate1_backend.template.Item;
import kea3.eksamenstemplate1_backend.template.ItemRepository;
import kea3.eksamenstemplate1_backend.trackmeet.TrackMeet;
import kea3.eksamenstemplate1_backend.trackmeet.TrackMeetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class InitData implements CommandLineRunner {


    private final ItemRepository itemRepository;
    private final ClubRepository clubRepository;
    private final AgeGroupRepository ageGroupRepository;
    private final DisciplineRepository disciplineRepository;
    private final AthleteRepository athleteRepository;
    private final ResultTypeRepository resultTypeRepository;
    private final TrackMeetRepository trackMeetRepository;


    public InitData(ItemRepository itemRepository,
                    ClubRepository clubRepository,
                    AgeGroupRepository ageGroupRepository,
                    DisciplineRepository disciplineRepository,
                    AthleteRepository athleteRepository,
                    ResultTypeRepository resultTypeRepository,
                    TrackMeetRepository trackMeetRepository) {

        this.itemRepository = itemRepository;
        this.clubRepository = clubRepository;
        this.ageGroupRepository = ageGroupRepository;
        this.disciplineRepository = disciplineRepository;
        this.athleteRepository = athleteRepository;
        this.resultTypeRepository = resultTypeRepository;
        this.trackMeetRepository = trackMeetRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("Hello from InitData");
        createItems();
        createClubs();
        createTrackMeet();
        createAgeGroups();
        createDisciplines();
        createAthletes();
        createResults();
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

    private void createTrackMeet() {
        System.out.println("Creating track meets");
        List<TrackMeet> trackMeets = List.of(
                new TrackMeet("Tokyo 2021"),
                new TrackMeet("Osaka 2021"),
                new TrackMeet("New York 2021"),
                new TrackMeet("Los Angeles 2021")
        );

        for (TrackMeet trackMeet : trackMeets) {
            TrackMeet existingTrackMeet = trackMeetRepository.findByName(trackMeet.getName());
            if (existingTrackMeet == null) {
                trackMeetRepository.save(trackMeet);
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

    private void createAthletes() {
        System.out.println("Creating athletes");

        Club club1 = clubRepository.findByName("Dragonhawk Athletics");
        Club club2 = clubRepository.findByName("Samurai Tiger Track Club");
        Club club3 = clubRepository.findByName("Phoenix Eagle Runners");
        Club club4 = clubRepository.findByName("Ninja Wolf Athletics");
        Club club5 = clubRepository.findByName("Thunder Falcon Track and Field");
        Club club6 = clubRepository.findByName("Ronin Bear Athletic Club");
        Club club7 = clubRepository.findByName("Sakura Panther Athletics");
        Club club8 = clubRepository.findByName("Shuriken Shark Track Team");
        Club club9 = clubRepository.findByName("Dynasty Lion Track Club");
        Club club10 = clubRepository.findByName("Rising Dragon Athletic Association");

        Optional<Discipline> discipline1 = disciplineRepository.findByNameAndGender("5000m", Discipline.GenderEnum.MENS);
        Optional<Discipline> discipline2 = disciplineRepository.findByNameAndGender("10000m", Discipline.GenderEnum.MENS);
        Optional<Discipline> discipline3 = disciplineRepository.findByNameAndGender("1500m", Discipline.GenderEnum.MENS);
        Optional<Discipline> discipline4 = disciplineRepository.findByNameAndGender("800m", Discipline.GenderEnum.MENS);
        Optional<Discipline> discipline5 = disciplineRepository.findByNameAndGender("400m", Discipline.GenderEnum.MENS);
        Optional<Discipline> discipline6 = disciplineRepository.findByNameAndGender("Javelin", Discipline.GenderEnum.MENS);
        Optional<Discipline> discipline7 = disciplineRepository.findByNameAndGender("Discus", Discipline.GenderEnum.MENS);
        Optional<Discipline> discipline8 = disciplineRepository.findByNameAndGender("Triple Jump", Discipline.GenderEnum.MENS);
        Optional<Discipline> discipline9 = disciplineRepository.findByNameAndGender("Pole Vault", Discipline.GenderEnum.MENS);
        Optional<Discipline> discipline10 = disciplineRepository.findByNameAndGender("Long Jump", Discipline.GenderEnum.MENS);
        Optional<Discipline> discipline11 = disciplineRepository.findByNameAndGender("High Jump", Discipline.GenderEnum.MENS);
        Optional<Discipline> discipline12 = disciplineRepository.findByNameAndGender("Decathlon", Discipline.GenderEnum.MENS);

        Optional<Discipline> discipline13 = disciplineRepository.findByNameAndGender("5000m", Discipline.GenderEnum.WOMENS);
        Optional<Discipline> discipline14 = disciplineRepository.findByNameAndGender("10000m", Discipline.GenderEnum.WOMENS);
        Optional<Discipline> discipline15 = disciplineRepository.findByNameAndGender("1500m", Discipline.GenderEnum.WOMENS);
        Optional<Discipline> discipline16 = disciplineRepository.findByNameAndGender("800m", Discipline.GenderEnum.WOMENS);
        Optional<Discipline> discipline17 = disciplineRepository.findByNameAndGender("400m", Discipline.GenderEnum.WOMENS);
        Optional<Discipline> discipline18 = disciplineRepository.findByNameAndGender("Javelin", Discipline.GenderEnum.WOMENS);
        Optional<Discipline> discipline19 = disciplineRepository.findByNameAndGender("Discus", Discipline.GenderEnum.WOMENS);
        Optional<Discipline> discipline20 = disciplineRepository.findByNameAndGender("Triple Jump", Discipline.GenderEnum.WOMENS);
        Optional<Discipline> discipline21 = disciplineRepository.findByNameAndGender("Pole Vault", Discipline.GenderEnum.WOMENS);
        Optional<Discipline> discipline22 = disciplineRepository.findByNameAndGender("Long Jump", Discipline.GenderEnum.WOMENS);
        Optional<Discipline> discipline23 = disciplineRepository.findByNameAndGender("High Jump", Discipline.GenderEnum.WOMENS);
        Optional<Discipline> discipline24 = disciplineRepository.findByNameAndGender("Heptathlon", Discipline.GenderEnum.WOMENS);

        Optional<Discipline> discipline25 = disciplineRepository.findByNameAndGender("4x400 Relay", Discipline.GenderEnum.MIXED);


        Athlete athlete1 = new Athlete("Mo Farah", "M", 25, "https://www.example.com/johndoe.jpg", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.ADULT), club1, List.of(discipline1.orElseThrow(), discipline2.orElseThrow(), discipline3.orElseThrow()));
        Athlete athlete2 = new Athlete("Jakob Ingebrigtsen", "M", 25, "https://www.example.com/johndoe.jpg", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.ADULT), club2, List.of(discipline2.orElseThrow(), discipline3.orElseThrow()));
        Athlete athlete3 = new Athlete("Sifan Hassan", "F", 25, "https://www.example.com/johndoe.jpg", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.ADULT), club3, List.of(discipline13.orElseThrow(), discipline14.orElseThrow(), discipline23.orElseThrow()));


        // Create a list of athletes
        List<Athlete> athletes = List.of(athlete1, athlete2, athlete3);

        // Save athletes to the database if they don't already exist
        for (Athlete athlete : athletes) {
            Athlete existingAthlete = athleteRepository.findByName(athlete.getName());
            if (existingAthlete == null) {
                athleteRepository.save(athlete);
            }
        }
    }

    private void createResults() {

        TrackMeet trackMeet1 = trackMeetRepository.findByName("Tokyo 2021");
        TrackMeet trackMeet2 = trackMeetRepository.findByName("Osaka 2021");
        TrackMeet trackMeet3 = trackMeetRepository.findByName("New York 2021");
        TrackMeet trackMeet4 = trackMeetRepository.findByName("Los Angeles 2021");

        Athlete athlete1 = athleteRepository.findByName("Mo Farah");
        Athlete athlete2 = athleteRepository.findByName("Jakob Ingebrigtsen");
        Athlete athlete3 = athleteRepository.findByName("Sifan Hassan");

        Optional<Discipline> discipline1 = disciplineRepository.findByNameAndGender("5000m", Discipline.GenderEnum.MENS);
        Optional<Discipline> discipline2 = disciplineRepository.findByNameAndGender("10000m", Discipline.GenderEnum.MENS);
        Optional<Discipline> discipline3 = disciplineRepository.findByNameAndGender("1500m", Discipline.GenderEnum.MENS);
        Optional<Discipline> discipline4 = disciplineRepository.findByNameAndGender("High Jump", Discipline.GenderEnum.WOMENS);

        System.out.println("Creating results");

        LocalDateTime now = LocalDateTime.now();

        ResultTime result1Athlete1Discipline1 = new ResultTime(trackMeet1, now, athlete1, discipline1.get(), 13.333);
        ResultTime result1Athlete1Discipline2 = new ResultTime(trackMeet2, now, athlete1, discipline2.get(), 28.4512);
        ResultTime result1Athlete1Discipline3 = new ResultTime(trackMeet3, now, athlete1, discipline3.get(), 3.5978);

        // Define results for athlete2
        ResultTime result1Athlete2Discipline2 = new ResultTime(trackMeet2, now, athlete2, discipline2.get(), 27.5530);
        ResultTime result1Athlete2Discipline3 = new ResultTime(trackMeet3, now, athlete2, discipline3.get(), 3.5622);

        ResultDistance result1Athlete3Discipline4 = new ResultDistance(trackMeet4, now, athlete3, discipline4.get(), 1.98);

        // Create a list of results
        List<ResultType> results = List.of(
                result1Athlete1Discipline1, result1Athlete1Discipline2, result1Athlete1Discipline3,
                result1Athlete2Discipline2, result1Athlete2Discipline3, result1Athlete3Discipline4
        );

        // Save results to the database
        for (ResultType result : results) {
            ResultType existingResult = resultTypeRepository.findByTrackMeetAndAthleteAndDiscipline(result.getTrackMeet(), result.getAthlete(), result.getDiscipline());
            if (existingResult == null) {
            resultTypeRepository.save(result);
            }
        }
    }
}


