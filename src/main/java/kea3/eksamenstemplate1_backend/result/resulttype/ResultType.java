package kea3.eksamenstemplate1_backend.result.resulttype;

import jakarta.persistence.*;
import kea3.eksamenstemplate1_backend.athlete.Athlete;
import kea3.eksamenstemplate1_backend.discipline.Discipline;
import kea3.eksamenstemplate1_backend.trackmeet.TrackMeet;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ResultType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TrackMeet trackMeet;

    private LocalDateTime date;

    @ManyToOne
    private Athlete athlete;

    @ManyToOne
    private Discipline discipline;


    public ResultType(TrackMeet trackMeet, LocalDateTime date, Athlete athlete, Discipline discipline) {
        this.trackMeet = trackMeet;
        this.date = date;
        this.athlete = athlete;
        this.discipline = discipline;
    }

    public ResultType() {
    }
}
