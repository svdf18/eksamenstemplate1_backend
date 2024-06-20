package kea3.eksamenstemplate1_backend.result.resulttype;

import kea3.eksamenstemplate1_backend.athlete.Athlete;
import kea3.eksamenstemplate1_backend.trackmeet.TrackMeet;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ResultTypeTest {

    @Test
    void getId() {
        ResultType result = new ResultType();
        result.setId(1L);
        assertEquals(1L, result.getId());
    }

    @Test
    void getTrackMeet() {
        ResultType result = new ResultType();
        TrackMeet trackMeet = new TrackMeet();
        trackMeet.setId(1L);
        result.setTrackMeet(trackMeet);
        assertEquals(trackMeet, result.getTrackMeet());
    }

    @Test
    void getDate() {
        ResultType result = new ResultType();
        LocalDateTime now = LocalDateTime.now();
        result.setDate(now);
        assertEquals(now, result.getDate());
    }

    @Test
    void getAthlete() {
        ResultType result = new ResultType();
        Athlete athlete = new Athlete();
        athlete.setId(1L);
        result.setAthlete(athlete);
        assertEquals(athlete, result.getAthlete());
    }

    @Test
    void setId() {
        ResultType result = new ResultType();
        result.setId(1L);
        assertEquals(1L, result.getId());
    }

    @Test
    void setTrackMeet() {
        ResultType result = new ResultType();
        TrackMeet trackMeet = new TrackMeet();
        trackMeet.setId(1L);
        result.setTrackMeet(trackMeet);
        assertEquals(trackMeet, result.getTrackMeet());
    }

    @Test
    void setDate() {
        ResultType result = new ResultType();
        LocalDateTime now = LocalDateTime.now();
        result.setDate(now);
        assertEquals(now, result.getDate());
    }

    @Test
    void setAthlete() {
        ResultType result = new ResultType();
        Athlete athlete = new Athlete();
        athlete.setId(1L);
        result.setAthlete(athlete);
        assertEquals(athlete, result.getAthlete());
    }

    @Test
    void testDefaultConstructor() {
        ResultType result = new ResultType();
        assertNotNull(result);
    }

//    @Test
//    void testParameterizedConstructor() {
//        TrackMeet trackMeet = new TrackMeet();
//        trackMeet.setId(1L);
//        LocalDateTime now = LocalDateTime.now();
//        Athlete athlete = new Athlete();
//        athlete.setId(1L);
//        Discipline discipline = new Discipline("5000m", Discipline.GenderEnum.MENS, ResultTypeEnum.TIME); // Example discipline
//        double time = 720.56; // Example time in seconds
//
//        ResultTime result = new ResultTime(trackMeet, now, athlete, discipline, time);
//
//        assertEquals(trackMeet, result.getTrackMeet());
//        assertEquals(now, result.getDate());
//        assertEquals(ResultTypeEnum.TIME, result.getResultType());
//        assertEquals(athlete, result.getAthlete());
//        assertEquals(discipline, result.getDiscipline());
//    }
}