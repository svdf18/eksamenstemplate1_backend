package kea3.eksamenstemplate1_backend.athlete;

import kea3.eksamenstemplate1_backend.agegroup.AgeGroupEnum;
import kea3.eksamenstemplate1_backend.club.Club;
import kea3.eksamenstemplate1_backend.discipline.Discipline;
import kea3.eksamenstemplate1_backend.result.resulttype.ResultType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AthleteTest {

    @Test
    void testGettersAndSetters() {
        Athlete athlete = new Athlete();

        // Test ID
        athlete.setId(1L);
        assertEquals(1L, athlete.getId());

        // Test Name
        athlete.setName("John Doe");
        assertEquals("John Doe", athlete.getName());

        // Test Gender
        athlete.setGender("Male");
        assertEquals("Male", athlete.getGender());

        // Test Age
        athlete.setAge(25);
        assertEquals(25, athlete.getAge());

        // Test AgeGroup assignment
        athlete.assignAgeGroup();
        assertEquals(AgeGroupEnum.SENIOR, athlete.getAgeGroup().getAgeGroupName());

        // Test Club
        Club club = new Club();
        club.setId(1L);
        club.setName("Best Club");
        athlete.setClub(club);
        assertEquals(club, athlete.getClub());

        // Test Disciplines
        Discipline discipline1 = new Discipline();
        discipline1.setId(1L);
        discipline1.setName("100m");

        Discipline discipline2 = new Discipline();
        discipline2.setId(2L);
        discipline2.setName("Long Jump");

        List<Discipline> disciplines = new ArrayList<>();
        disciplines.add(discipline1);
        disciplines.add(discipline2);
        athlete.setDisciplines(disciplines);
        assertEquals(disciplines, athlete.getDisciplines());
    }

    @Test
    void testConstructor() {
        Club club = new Club();
        club.setId(1L);
        club.setName("Best Club");

        Discipline discipline1 = new Discipline();
        discipline1.setId(1L);
        discipline1.setName("100m");

        Discipline discipline2 = new Discipline();
        discipline2.setId(2L);
        discipline2.setName("Long Jump");

        List<Discipline> disciplines = new ArrayList<>();
        disciplines.add(discipline1);
        disciplines.add(discipline2);

        ResultType result1 = new ResultType();
        result1.setId(1L);

        ResultType result2 = new ResultType();
        result2.setId(2L);

        List<ResultType> results = new ArrayList<>();
        results.add(result1);
        results.add(result2);

        Athlete athlete = new Athlete("John Doe", "Male", 25, "hhh", null, club, disciplines);
        athlete.assignAgeGroup();

        assertEquals("John Doe", athlete.getName());
        assertEquals("Male", athlete.getGender());
        assertEquals(25, athlete.getAge());
        assertEquals("hhh", athlete.getImageUrl());
        assertEquals(AgeGroupEnum.SENIOR, athlete.getAgeGroup().getAgeGroupName());
        assertEquals(club, athlete.getClub());
    }
}