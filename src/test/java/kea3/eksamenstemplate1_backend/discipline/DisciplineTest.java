package kea3.eksamenstemplate1_backend.discipline;

import kea3.eksamenstemplate1_backend.result.resulttype.ResultTypeEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisciplineTest {

    @Test
    void getId() {
        Discipline discipline = new Discipline();
        discipline.setId(1L);
        assertEquals(1L, discipline.getId());
    }

    @Test
    void getName() {
        Discipline discipline = new Discipline();
        discipline.setName("100m Sprint");
        assertEquals("100m Sprint", discipline.getName());
    }

    @Test
    void setName() {
        Discipline discipline = new Discipline();
        discipline.setName("Long Jump");
        assertEquals("Long Jump", discipline.getName());
    }

    @Test
    void getResultType() {
        Discipline discipline = new Discipline();
        discipline.setResultType(ResultTypeEnum.DISTANCE);
        assertEquals(ResultTypeEnum.DISTANCE, discipline.getResultType());
    }

    @Test
    void setResultType() {
        Discipline discipline = new Discipline();
        discipline.setResultType(ResultTypeEnum.TIME);
        assertEquals(ResultTypeEnum.TIME, discipline.getResultType());
    }

    @Test
    void testDefaultConstructor() {
        Discipline discipline = new Discipline();
        assertNotNull(discipline);
    }

    @Test
    void testParameterizedConstructor() {
        Discipline discipline = new Discipline("High Jump", Discipline.GenderEnum.WOMENS, ResultTypeEnum.DISTANCE);
        assertEquals("High Jump", discipline.getName());
        assertEquals(Discipline.GenderEnum.WOMENS, discipline.getGender());
        assertEquals(ResultTypeEnum.DISTANCE, discipline.getResultType());
    }
}