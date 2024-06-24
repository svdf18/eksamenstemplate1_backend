package kea3.eksamenstemplate1_backend.agegroup;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AgeGroupEnumTest {

    @Test
    void testGetMinAge() {
        assertEquals(0, AgeGroupEnum.CHILD.getMinAge());
        assertEquals(10, AgeGroupEnum.YOUTH.getMinAge());
        assertEquals(14, AgeGroupEnum.JUNIOR.getMinAge());
        assertEquals(23, AgeGroupEnum.SENIOR.getMinAge());
        assertEquals(41, AgeGroupEnum.VETERAN.getMinAge());
    }

    @Test
    void testGetMaxAge() {
        assertEquals(9, AgeGroupEnum.CHILD.getMaxAge());
        assertEquals(13, AgeGroupEnum.YOUTH.getMaxAge());
        assertEquals(22, AgeGroupEnum.JUNIOR.getMaxAge());
        assertEquals(40, AgeGroupEnum.SENIOR.getMaxAge());
        assertEquals(Integer.MAX_VALUE, AgeGroupEnum.VETERAN.getMaxAge());
    }

    @Test
    void testGetAgeGroupByAge() {
        assertEquals(AgeGroupEnum.CHILD, AgeGroupEnum.getAgeGroupByAge(5));
        assertEquals(AgeGroupEnum.YOUTH, AgeGroupEnum.getAgeGroupByAge(12));
        assertEquals(AgeGroupEnum.JUNIOR, AgeGroupEnum.getAgeGroupByAge(18));
        assertEquals(AgeGroupEnum.SENIOR, AgeGroupEnum.getAgeGroupByAge(30));
        assertEquals(AgeGroupEnum.VETERAN, AgeGroupEnum.getAgeGroupByAge(50));
    }

    @Test
    void testGetAgeGroupByAgeInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AgeGroupEnum.getAgeGroupByAge(-1);
        });
        assertEquals("No age group found for age: -1", exception.getMessage());
    }
}