//package kea3.eksamenstemplate1_backend.athlete;
//
//import kea3.eksamenstemplate1_backend.club.Club;
//import kea3.eksamenstemplate1_backend.club.ClubRepository;
//import kea3.eksamenstemplate1_backend.agegroup.AgeGroupEnum;
//import kea3.eksamenstemplate1_backend.agegroup.AgeGroupRepository;
//import kea3.eksamenstemplate1_backend.discipline.Discipline;
//import kea3.eksamenstemplate1_backend.discipline.DisciplineRepository;
//import kea3.eksamenstemplate1_backend.result.resulttype.ResultTypeEnum;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.List;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class AthleteControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private AthleteRepository athleteRepository;
//
//    @Autowired
//    private ClubRepository clubRepository;
//
//    @Autowired
//    private AgeGroupRepository ageGroupRepository;
//
//    @Autowired
//    private DisciplineRepository disciplineRepository;
//
//    private Club club1;
//    private Club club2;
//
//    private Discipline discipline1;
//    private Discipline discipline2;
//
//    @BeforeEach
//    void setUp() {
//        // Create clubs
//        club1 = clubRepository.save(new Club("Dragonhawk Athletics", "New York"));
//        club2 = clubRepository.save(new Club("Samurai Tiger Track Club", "Tokyo"));
//
//        // Create disciplines
//        discipline1 = disciplineRepository.save(new Discipline("100m", Discipline.GenderEnum.MENS, ResultTypeEnum.TIME));
//        discipline2 = disciplineRepository.save(new Discipline("200m", Discipline.GenderEnum.MENS, ResultTypeEnum.TIME));
//
//        // Create athletes
//        Athlete athlete1 = new Athlete("Usain Bolt", "M", 36, "https://example.com/usain_bolt.jpg", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.ADULT), club1, List.of(discipline1, discipline2));
//        Athlete athlete2 = new Athlete("Tyson Gay", "M", 36, "https://example.com/tyson_gay.jpg", ageGroupRepository.findByAgeGroupName(AgeGroupEnum.ADULT), club2, List.of(discipline1));
//
//        athleteRepository.saveAll(List.of(athlete1, athlete2));
//    }
//
//    @Test
//    void getAllAthletes() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/athletes/all"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
//    }
//
//    @Test
//    void getAthleteById() throws Exception {
//        Athlete athlete = athleteRepository.findAll().get(0);
//        mockMvc.perform(MockMvcRequestBuilders.get("/athletes/id/" + athlete.getId()))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(athlete.getName()));
//    }
//
//    @Test
//    void createAthlete() throws Exception {
//        Club newClub = clubRepository.save(new Club("Phoenix Eagle Runners", "Los Angeles"));
//        Discipline newDiscipline = disciplineRepository.save(new Discipline("400m", Discipline.GenderEnum.MENS, ResultTypeEnum.TIME));
//
//        String requestBody = "{"
//                + "\"name\":\"Michael Johnson\","
//                + "\"gender\":\"M\","
//                + "\"age\":47,"
//                + "\"imageUrl\":\"https://example.com/michael_johnson.jpg\","
//                + "\"club\":{\"name\":\"Phoenix Eagle Runners\",\"city\":\"Los Angeles\"},"
//                + "\"disciplines\":[{\"name\":\"400m\",\"gender\":\"MENS\",\"resultType\":\"TIME\"}]"
//                + "}";
//
//        mockMvc.perform(post("/athletes/create")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestBody))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Michael Johnson"));
//    }
//
//    @Test
//    void updateAthlete() throws Exception {
//        Athlete athlete = athleteRepository.findAll().get(0);
//
//        // Fetch discipline by name
//        Discipline discipline = disciplineRepository.findByName("200m");
//        if (discipline == null) {
//            throw new IllegalArgumentException("Discipline not found");
//        }
//
//        // Optionally, filter further based on gender and result type if needed
//        // For example:
//        if (discipline.getGender() != Discipline.GenderEnum.MENS || discipline.getResultType() != ResultTypeEnum.TIME) {
//            throw new IllegalArgumentException("Invalid discipline details");
//        }
//
//        String requestBody = "{"
//                + "\"name\":\"Usain Bolt Updated\","
//                + "\"gender\":\"M\","
//                + "\"age\":36,"
//                + "\"imageUrl\":\"https://example.com/usain_bolt_updated.jpg\","
//                + "\"club\":{\"name\":\"Dragonhawk Athletics\",\"city\":\"New York\"},"
//                + "\"disciplines\":[{\"name\":\"200m\",\"gender\":\"MENS\",\"resultType\":\"TIME\"}]"
//                + "}";
//
//        mockMvc.perform(MockMvcRequestBuilders.patch("/athletes/edit/" + athlete.getId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestBody))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Usain Bolt Updated"));
//    }
//
//    @Test
//    void deleteAthlete() throws Exception {
//        Athlete athlete = athleteRepository.findAll().get(0);
//
//        mockMvc.perform(MockMvcRequestBuilders.delete("/athletes/delete/" + athlete.getId()))
//                .andExpect(status().isOk());
//    }
//}
