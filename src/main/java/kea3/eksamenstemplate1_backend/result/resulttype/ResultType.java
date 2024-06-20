package kea3.eksamenstemplate1_backend.result.resulttype;

import jakarta.persistence.*;
import kea3.eksamenstemplate1_backend.athlete.Athlete;
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
    TrackMeet trackMeet;
    private LocalDateTime date;

    private ResultTypeEnum resultType;

    @ManyToOne
    private Athlete athlete;

    public ResultType(TrackMeet trackMeet, LocalDateTime date, ResultTypeEnum resultType, Athlete athlete) {
        this.trackMeet = trackMeet;
        this.date = date;
        this.resultType = resultType;
        this.athlete = athlete;
    }

    public ResultType() {
    }
}
