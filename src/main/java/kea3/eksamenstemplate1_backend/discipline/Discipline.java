package kea3.eksamenstemplate1_backend.discipline;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String resultType; // This should probably be an enum

    public Discipline(String name, String resultType) {
        this.name = name;
        this.resultType = resultType;
    }

    public Discipline() {
    }
}
