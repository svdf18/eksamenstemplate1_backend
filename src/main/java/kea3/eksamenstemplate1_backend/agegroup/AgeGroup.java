package kea3.eksamenstemplate1_backend.agegroup;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AgeGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AgeGroupEnum ageGroupName;

    public AgeGroup() {
    }

    public AgeGroup(AgeGroupEnum ageGroupName) {
        this.ageGroupName = ageGroupName;
    }
}

