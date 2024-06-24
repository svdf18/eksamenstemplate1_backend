package kea3.eksamenstemplate1_backend.agegroup;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
public class AgeGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    private AgeGroupEnum ageGroupName;

    public AgeGroup() {
    }

    public AgeGroup(AgeGroupEnum ageGroupName) {
        this.ageGroupName = ageGroupName;
    }
}

