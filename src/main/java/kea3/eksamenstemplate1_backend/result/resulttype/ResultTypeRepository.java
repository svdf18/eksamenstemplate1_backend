package kea3.eksamenstemplate1_backend.result.resulttype;

import kea3.eksamenstemplate1_backend.athlete.Athlete;
import kea3.eksamenstemplate1_backend.discipline.Discipline;
import kea3.eksamenstemplate1_backend.trackmeet.TrackMeet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultTypeRepository extends JpaRepository<ResultType, Long> {
    ResultType findByTrackMeetAndAthleteAndDiscipline(TrackMeet trackMeet, Athlete athlete, Discipline discipline);
}
