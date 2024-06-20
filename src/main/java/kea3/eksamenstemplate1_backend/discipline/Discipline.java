package kea3.eksamenstemplate1_backend.discipline;

import jakarta.persistence.*;
import kea3.eksamenstemplate1_backend.result.resulttype.ResultTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ResultTypeEnum resultType;

    public Discipline(String name, ResultTypeEnum resultType) {
        this.name = name;
        this.resultType = resultType;
    }

    public Discipline() {
    }
}
