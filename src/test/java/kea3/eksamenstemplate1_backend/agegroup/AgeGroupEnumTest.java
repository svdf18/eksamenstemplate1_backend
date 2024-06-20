package kea3.eksamenstemplate1_backend.agegroup;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AgeGroupEnumTest {

    @Test
    void testGetMinAge() {
        assertEquals(10, AgeGroupEnum.YOUTH.getMinAge());
        assertEquals(14, AgeGroupEnum.JUNIOR.getMinAge());
        assertEquals(23, AgeGroupEnum.ADULT.getMinAge());
        assertEquals(41, AgeGroupEnum.SENIOR.getMinAge());
    }

    @Test
    void testGetMaxAge() {
        assertEquals(13, AgeGroupEnum.YOUTH.getMaxAge());
        assertEquals(22, AgeGroupEnum.JUNIOR.getMaxAge());
        assertEquals(40, AgeGroupEnum.ADULT.getMaxAge());
        assertEquals(Integer.MAX_VALUE, AgeGroupEnum.SENIOR.getMaxAge());
    }

    @Test
    void testGetAgeGroupByAge() {
        assertEquals(AgeGroupEnum.YOUTH, AgeGroupEnum.getAgeGroupByAge(12));
        assertEquals(AgeGroupEnum.JUNIOR, AgeGroupEnum.getAgeGroupByAge(18));
        assertEquals(AgeGroupEnum.ADULT, AgeGroupEnum.getAgeGroupByAge(30));
        assertEquals(AgeGroupEnum.SENIOR, AgeGroupEnum.getAgeGroupByAge(50));
    }

    @Test
    void testGetAgeGroupByAgeInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AgeGroupEnum.getAgeGroupByAge(5);
        });
        assertEquals("No age group found for age: 5", exception.getMessage());
    }
}
