package kea3.eksamenstemplate1_backend.club;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClubTest {

        @Test
        void testGettersAndSetters() {
            Club club = new Club();

            // Test ID
            club.setId(1L);
            assertEquals(1L, club.getId());

            // Test Name
            club.setName("Best Club");
            assertEquals("Best Club", club.getName());
        }
}