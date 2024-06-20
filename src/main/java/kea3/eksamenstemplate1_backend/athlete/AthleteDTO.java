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
    private AgeGroupEnum ageGroupName;
    private Club club;
    private List<Discipline> disciplines;
    private List<ResultType> results;

    public AthleteDTO() {
    }

    public AthleteDTO(Long id, String name, String gender, int age, AgeGroupEnum ageGroupName, Club club, List<Discipline> disciplines, List<ResultType> results) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.ageGroupName = ageGroupName;
        this.club = club;
        this.disciplines = disciplines;
        this.results = results;
    }
}
