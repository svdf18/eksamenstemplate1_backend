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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
                new AgeGroup(AgeGroupEnum.CHILD),
                new AgeGroup(AgeGroupEnum.YOUTH),
                new AgeGroup(AgeGroupEnum.JUNIOR),
                new AgeGroup(AgeGroupEnum.SENIOR),
                new AgeGroup(AgeGroupEnum.VETERAN)
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


        Athlete athlete1 = new Athlete("Mo Farah", "M", 25, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimg2.thejournal.ie%2Farticle%2F3672445%2Friver%3Fversion%3D3672446%26width%3D1340&f=1&nofb=1&ipt=99a7520dbcdd2bd795e0b778f380d2be1391c8d34e5a4be22d5990b05433cdd8&ipo=images", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.SENIOR), club1, List.of(discipline1.orElseThrow(), discipline2.orElseThrow(), discipline3.orElseThrow()));
        Athlete athlete2 = new Athlete("Jakob Ingebrigtsen", "M", 25, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Frunningmagazine.ca%2Fwp-content%2Fuploads%2F2023%2F03%2FIngebrigtsen_Jakob-R-Worlds22-1200x675.jpg&f=1&nofb=1&ipt=8c476501ef0688524f1049cbe0ac92e6c6c82e8e4af358909e9b632a6619211d&ipo=images", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.SENIOR), club2, List.of(discipline2.orElseThrow(), discipline3.orElseThrow()));
        Athlete athlete3 = new Athlete("Sifan Hassan", "F", 25, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fdqtjif.bitlydns.net%2Fwp-content%2Fuploads%2F2021%2F08%2FNeerlandesa-Sifan-Hassan.jpg&f=1&nofb=1&ipt=8a5881483ce8d6dbde2c2fe107c15817bbab172f4db634a2328c5090f117197c&ipo=images", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.SENIOR), club3, List.of(discipline13.orElseThrow(), discipline14.orElseThrow(), discipline23.orElseThrow()));
        Athlete athlete4 = new Athlete("Karsten Warholm", "M", 15, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwesportfr.com%2Fwp-content%2Fuploads%2F2021%2F07%2FNRK.jpeg&f=1&nofb=1&ipt=b49658695c93c1833b6e265d9e6351a7166751f5e0a6eb75486e800892636fdc&ipo=images", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.SENIOR), club4, List.of(discipline5.orElseThrow(), discipline6.orElseThrow(), discipline7.orElseThrow()));
        Athlete athlete5 = new Athlete("Elaine Thompson-Herah", "F", 35, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.dancehallmag.com%2Fassets%2F2021%2F08%2FElaine-Thompson-Herah.jpeg&f=1&nofb=1&ipt=3ae134459703dec9ba23963302621a93aafe87ff1d1d53431b28da4bc3d7f79a&ipo=images", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.SENIOR), club6, List.of(discipline17.orElseThrow(), discipline18.orElseThrow(), discipline19.orElseThrow()));
        Athlete athlete6 = new Athlete("Noah Lyles", "M", 45, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.si.com%2F.image%2Ft_share%2FMTgyOTEzMDkwMDk2OTk3NzI4%2Fnoah-lyes-200-olympics-inline.jpg&f=1&nofb=1&ipt=10c1c3252397ad35b6e7c07eb4d553402c607e879aad606b3d0ed6c07708cc6d&ipo=images", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.SENIOR), club6, List.of(discipline4.orElseThrow(), discipline5.orElseThrow(), discipline6.orElseThrow()));
        Athlete athlete7 = new Athlete("Shaunae Miller-Uibo", "F", 45, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.Qbx5BPXURuiqqVeww1k4ZQHaE8%26pid%3DApi&f=1&ipt=88c09ae43c870c1b3fa964dd04612dc40fcf87d476bd10de8a41b74322106ed9&ipo=images", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.SENIOR), club6, List.of(discipline16.orElseThrow(), discipline17.orElseThrow(), discipline18.orElseThrow()));
        Athlete athlete8 = new Athlete("Christian Coleman", "M", 24, "https://www.gannett-cdn.com/presto/2020/06/17/USAT/2ee4d84a-d77b-45f9-a7f4-1a5f72dc550b-AFP_AFP_1TL30Y.jpg?crop=4581,2577,x0,y219&width=3200&height=1801&format=pjpg&auto=webp", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.SENIOR), club8, List.of(discipline5.orElseThrow(), discipline6.orElseThrow(), discipline7.orElseThrow()));
        Athlete athlete9 = new Athlete("Dina Asher-Smith", "F", 25, "https://static.independent.co.uk/2023/05/04/19/5dc15b2b93b2c86447c55fb7a5f6693fY29udGVudHNlYXJjaGFwaSwxNjgzMzA3Mjgx-2.71136512.jpg", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.SENIOR), club10, List.of(discipline16.orElseThrow(), discipline17.orElseThrow(), discipline18.orElseThrow()));
        Athlete athlete10 = new Athlete("Trayvon Bromell", "M", 22, "https://image-cdn.essentiallysports.com/wp-content/uploads/Trayvon-Bromell-Track-Tokyo.jpg?width=900", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.SENIOR), club10, List.of(discipline5.orElseThrow(), discipline6.orElseThrow(), discipline7.orElseThrow()));
        Athlete athlete11 = new Athlete("Shelly-Ann Fraser-Pryce", "F", 25, "https://cdn.britannica.com/86/172786-050-0EA326A4/Shelly-Ann-Fraser-Pryce.jpg", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.SENIOR), club1, List.of(discipline16.orElseThrow(), discipline17.orElseThrow(), discipline18.orElseThrow()));
        Athlete athlete12 = new Athlete("Fred Kerley", "M", 25, "https://media.nbcwashington.com/2022/07/web-220716-fred-kerley-1.jpg?quality=85&strip=all&resize=1200%2C675", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.SENIOR), club2, List.of(discipline5.orElseThrow(), discipline6.orElseThrow(), discipline7.orElseThrow()));
        Athlete athlete13 = new Athlete("Shericka Jackson", "F", 20, "https://swisherpost.co.za/wp-content/uploads/2022/07/shericka-jackson.jpeg", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.SENIOR), club2, List.of(discipline16.orElseThrow(), discipline17.orElseThrow(), discipline18.orElseThrow()));
        Athlete athlete14 = new Athlete("Eluid Kipchoge", "M", 39, "https://cdn.dmcl.biz/media/image/214109/o/GettyImages-1332939917.jpg", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.SENIOR), club2, List.of(discipline1.orElseThrow(), discipline2.orElseThrow(), discipline3.orElseThrow()));
        // Create a list of athletes
        List<Athlete> athletes = List.of(athlete1, athlete2, athlete3, athlete4, athlete5, athlete6, athlete7, athlete8, athlete9, athlete10, athlete11, athlete12, athlete13, athlete14);

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
        Athlete athlete4 = athleteRepository.findByName("Karsten Warholm");
        Athlete athlete5 = athleteRepository.findByName("Elaine Thompson-Herah");
        Athlete athlete6 = athleteRepository.findByName("Noah Lyles");
        Athlete athlete7 = athleteRepository.findByName("Shaunae Miller-Uibo");
        Athlete athlete8 = athleteRepository.findByName("Christian Coleman");
        Athlete athlete9 = athleteRepository.findByName("Dina Asher-Smith");
        Athlete athlete10 = athleteRepository.findByName("Trayvon Bromell");
        Athlete athlete11 = athleteRepository.findByName("Shelly-Ann Fraser-Pryce");
        Athlete athlete12 = athleteRepository.findByName("Fred Kerley");
        Athlete athlete13 = athleteRepository.findByName("Shericka Jackson");
        Athlete athlete14 = athleteRepository.findByName("Eluid Kipchoge");

        Optional<Discipline> discipline1 = disciplineRepository.findByNameAndGender("5000m", Discipline.GenderEnum.MENS);
        Optional<Discipline> discipline2 = disciplineRepository.findByNameAndGender("10000m", Discipline.GenderEnum.MENS);
        Optional<Discipline> discipline3 = disciplineRepository.findByNameAndGender("1500m", Discipline.GenderEnum.MENS);
        Optional<Discipline> discipline4 = disciplineRepository.findByNameAndGender("High Jump", Discipline.GenderEnum.WOMENS);
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

        System.out.println("Creating results");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

        // Example times, adjust as needed
        LocalTime time1 = LocalTime.parse("00:13:22.111", timeFormatter);
        LocalTime time2 = LocalTime.parse("00:28:22.122", timeFormatter);
        LocalTime time3 = LocalTime.parse("00:03:38.043", timeFormatter);

        ResultTime result1Athlete1Discipline1 = new ResultTime(trackMeet1, now, athlete1, discipline1.get(), time1);
        ResultTime result1Athlete1Discipline2 = new ResultTime(trackMeet2, now, athlete1, discipline2.get(), time2);
        ResultTime result1Athlete1Discipline3 = new ResultTime(trackMeet3, now, athlete1, discipline3.get(), time3);

        // Define results for athlete2
        LocalTime time4 = LocalTime.parse("00:28:23.760", timeFormatter);
        LocalTime time5 = LocalTime.parse("00:03:33.904", timeFormatter);

        ResultTime result1Athlete2Discipline2 = new ResultTime(trackMeet2, now, athlete2, discipline2.get(), time4);
        ResultTime result1Athlete2Discipline3 = new ResultTime(trackMeet3, now, athlete2, discipline3.get(), time5);

        // Define results for athlete3
        ResultDistance result1Athlete3Discipline4 = new ResultDistance(trackMeet4, now, athlete3, discipline4.get(), 1.98);

        // Define results for athlete4
        LocalTime time6 = LocalTime.parse("00:00:47.453", timeFormatter);
        ResultTime result1Athlete4Discipline5 = new ResultTime(trackMeet1, now, athlete4, discipline5.get(), time6);
        ResultDistance result1Athlete4Discipline6 = new ResultDistance(trackMeet2, now, athlete4, discipline6.get(), 78.5);
        ResultDistance result1Athlete4Discipline7 = new ResultDistance(trackMeet3, now, athlete4, discipline7.get(), 45.6);

        // Define results for athlete5
        LocalTime time7 = LocalTime.parse("00:00:52.304", timeFormatter);
        ResultTime result1Athlete5Discipline17 = new ResultTime(trackMeet4, now, athlete5, discipline17.get(), time7);
        ResultDistance result1Athlete5Discipline18 = new ResultDistance(trackMeet1, now, athlete5, discipline18.get(), 17.5);
        ResultDistance result1Athlete5Discipline19 = new ResultDistance(trackMeet2, now, athlete5, discipline19.get(), 20.5);

        // Define results for athlete6
        LocalTime time8 = LocalTime.parse("00:00:51.921", timeFormatter);
        ResultTime result1Athlete6Discipline4 = new ResultTime(trackMeet4, now, athlete6, discipline5.get(), time8);
        ResultDistance result1Athlete6Discipline5 = new ResultDistance(trackMeet1, now, athlete6, discipline6.get(), 45.123);

        // Create a list of results
        List<ResultType> results = List.of(
                result1Athlete1Discipline1, result1Athlete1Discipline2, result1Athlete1Discipline3,
                result1Athlete2Discipline2, result1Athlete2Discipline3, result1Athlete3Discipline4,
                result1Athlete4Discipline5, result1Athlete4Discipline6, result1Athlete4Discipline7,
                result1Athlete5Discipline17, result1Athlete5Discipline18, result1Athlete5Discipline19,
                result1Athlete6Discipline4, result1Athlete6Discipline5
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


