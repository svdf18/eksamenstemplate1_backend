package kea3.eksamenstemplate1_backend.discipline;

import kea3.eksamenstemplate1_backend.result.resulttype.ResultTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
    Discipline findByName(String name);
    Optional<Discipline> findByNameAndGender(String name, Discipline.GenderEnum gender);
}
