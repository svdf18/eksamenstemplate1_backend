package kea3.eksamenstemplate1_backend.discipline;

import kea3.eksamenstemplate1_backend.result.resulttype.ResultTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplineDTO {

    private Long id;
    private String name;
    private Discipline.GenderEnum gender;
    private ResultTypeEnum resultType;

    // Default constructor
    public DisciplineDTO() {
    }

    // Parameterized constructor
    public DisciplineDTO(Long id, String name, Discipline.GenderEnum gender, ResultTypeEnum resultType) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.resultType = resultType;
    }
}
