package kea3.eksamenstemplate1_backend.discipline;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisciplineService {

    private final DisciplineRepository disciplineRepository;

    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public List<DisciplineDTO> getAllDisciplines() {
        List<Discipline> disciplines = disciplineRepository.findAll();
        return disciplines.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public DisciplineDTO convertToDTO(Discipline discipline) {
        return new DisciplineDTO(
                discipline.getId(),
                discipline.getName(),
                discipline.getGender(),
                discipline.getResultType()
        );
    }

    public Discipline convertToEntity(DisciplineDTO disciplineDTO) {
        Discipline discipline = new Discipline();
        discipline.setId(disciplineDTO.getId());
        discipline.setName(disciplineDTO.getName());
        discipline.setGender(disciplineDTO.getGender());
        discipline.setResultType(disciplineDTO.getResultType());
        return discipline;
    }
}
