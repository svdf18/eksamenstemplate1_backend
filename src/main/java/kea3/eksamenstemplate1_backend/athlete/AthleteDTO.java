package kea3.eksamenstemplate1_backend.athlete;

import kea3.eksamenstemplate1_backend.agegroup.AgeGroupEnum;
import kea3.eksamenstemplate1_backend.club.Club;
import kea3.eksamenstemplate1_backend.discipline.Discipline;
import kea3.eksamenstemplate1_backend.result.resulttype.ResultType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AthleteDTO {

    private Long id;
    private String name;
    private String gender;
    private int age;
    private AgeGroupEnum ageGroup;
    private String imageUrl;
    private Club club;
    private List<Discipline> disciplines;

    public AthleteDTO(Long id, String name, String gender, int age, String imageUrl, AgeGroupEnum ageGroup, Club club, List<Discipline> disciplines) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.imageUrl = imageUrl;
        this.ageGroup = ageGroup;
        this.club = club;
        this.disciplines = disciplines;
    }

    public AthleteDTO() {
    }
}
