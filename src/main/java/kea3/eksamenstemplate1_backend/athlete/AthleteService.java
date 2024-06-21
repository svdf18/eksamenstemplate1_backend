package kea3.eksamenstemplate1_backend.athlete;

import kea3.eksamenstemplate1_backend.agegroup.AgeGroup;
import kea3.eksamenstemplate1_backend.agegroup.AgeGroupEnum;
import kea3.eksamenstemplate1_backend.agegroup.AgeGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AthleteService {

        private final AthleteRepository athleteRepository;
    private final AgeGroupRepository ageGroupRepository;

    public AthleteService(AthleteRepository athleteRepository, AgeGroupRepository ageGroupRepository) {
            this.athleteRepository = athleteRepository;
        this.ageGroupRepository = ageGroupRepository;
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
            athlete.setGender(athleteDTO.getGender());
            athlete.setAge(athleteDTO.getAge());
            athlete.setImageUrl(athleteDTO.getImageUrl());
            athlete.setClub(athleteDTO.getClub());
            athlete.setDisciplines(athleteDTO.getDisciplines());

            AgeGroupEnum ageGroupEnum = AgeGroupEnum.getAgeGroupByAge(athleteDTO.getAge());

            AgeGroup ageGroup = ageGroupRepository.findByAgeGroupName(ageGroupEnum);
            if (ageGroup != null) {
                athlete.setAgeGroup(ageGroup);
            }

            athleteRepository.save(athlete);

            return convertToDTO(athlete);
        }

        public AthleteDTO updateAthlete(Long id, AthleteDTO athleteDTO) {
            Athlete athlete = athleteRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Athlete not found with ID: " + id));
            athlete.setName(athleteDTO.getName());
            athlete.setGender(athleteDTO.getGender());
            athlete.setAge(athleteDTO.getAge());
            athlete.setImageUrl(athleteDTO.getImageUrl());
            athlete.setClub(athleteDTO.getClub());
            athlete.setDisciplines(athleteDTO.getDisciplines());

            AgeGroupEnum ageGroupEnum = AgeGroupEnum.getAgeGroupByAge(athleteDTO.getAge());
            AgeGroup ageGroup = ageGroupRepository.findByAgeGroupName(ageGroupEnum);
            if (ageGroup != null) {
                athlete.setAgeGroup(ageGroup);
            }

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
            athleteDTO.setImageUrl(athlete.getImageUrl());
            athleteDTO.setClub(athlete.getClub());
            athleteDTO.setDisciplines(athlete.getDisciplines());
            return athleteDTO;
        }

        public Athlete convertToEntity(AthleteDTO athleteDTO) {
            Athlete athlete = new Athlete();
            athlete.setName(athleteDTO.getName());
            athlete.setGender(athleteDTO.getGender());
            athlete.setAge(athleteDTO.getAge());
            athlete.setImageUrl(athleteDTO.getImageUrl());
            athlete.setClub(athleteDTO.getClub());
            athlete.setDisciplines(athleteDTO.getDisciplines());
            return athlete;
        }



}
