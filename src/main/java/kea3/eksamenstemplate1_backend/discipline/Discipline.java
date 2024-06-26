package kea3.eksamenstemplate1_backend.discipline;

import jakarta.persistence.*;
import kea3.eksamenstemplate1_backend.athlete.Athlete;
import kea3.eksamenstemplate1_backend.result.resulttype.ResultTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Enumerated(EnumType.STRING)
    private ResultTypeEnum resultType;

    public Discipline(String name, GenderEnum gender, ResultTypeEnum resultType) {
        this.name = name;
        this.gender = gender;
        this.resultType = resultType;
    }

    public Discipline() {
    }

    public enum GenderEnum {
        MENS,
        WOMENS,
        MIXED
    };
}
