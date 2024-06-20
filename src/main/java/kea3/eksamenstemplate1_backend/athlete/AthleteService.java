package kea3.eksamenstemplate1_backend.athlete;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AthleteService {

        private final AthleteRepository athleteRepository;

        public AthleteService(AthleteRepository athleteRepository) {
            this.athleteRepository = athleteRepository;
        }

        public List<AthleteDTO> getAllAthletes() {
            List<Athlete> athletes = athleteRepository.findAll();
            return athletes.stream().map(this::convertToDTO).collect(Collectors.toList());
        }

        public AthleteDTO getAthleteById(Long id) {
            Athlete athlete = athleteRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Athlete not found with ID: " + id));
            return convertToDTO(athlete);
        }

        public AthleteDTO createAthlete(AthleteDTO athleteDTO) {
            Athlete athlete = new Athlete();
            athlete.setName(athleteDTO.getName());

            athleteRepository.save(athlete);

            return convertToDTO(athlete);
        }

        public AthleteDTO updateAthlete(Long id, AthleteDTO athleteDTO) {
            Athlete athlete = athleteRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Athlete not found with ID: " + id));
            athlete.setName(athleteDTO.getName());

            athleteRepository.save(athlete);

            return convertToDTO(athlete);
        }

        public AthleteDTO deleteAthlete(Long id) {
            Athlete athlete = athleteRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Athlete not found with ID: " + id));
            athleteRepository.delete(athlete);
            return convertToDTO(athlete);
        }

        public AthleteDTO convertToDTO(Athlete athlete) {
            AthleteDTO athleteDTO = new AthleteDTO();
            athleteDTO.setId(athlete.getId());
            athleteDTO.setName(athlete.getName());
            athleteDTO.setGender(athlete.getGender());
            athleteDTO.setAge(athlete.getAge());
            athleteDTO.setAgeGroupName(athlete.getAgeGroup().getAgeGroupName());
            athleteDTO.setClub(athlete.getClub());
            athleteDTO.setDisciplines(athlete.getDisciplines());
            athleteDTO.setResults(athlete.getResults());
            return athleteDTO;
        }

}
