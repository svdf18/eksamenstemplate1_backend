package kea3.eksamenstemplate1_backend.result.resultdistance;

import jakarta.persistence.Entity;
import kea3.eksamenstemplate1_backend.athlete.Athlete;
import kea3.eksamenstemplate1_backend.discipline.Discipline;
import kea3.eksamenstemplate1_backend.result.resulttype.ResultType;
import kea3.eksamenstemplate1_backend.trackmeet.TrackMeet;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ResultDistance extends ResultType {

    private double distance;

    public ResultDistance() {
    }

    public ResultDistance(double distance) {
        this.distance = distance;
    }

    public ResultDistance(ResultType resultType, double distance) {
        super();
        this.distance = distance;
    }

    public ResultDistance(TrackMeet trackMeet, LocalDateTime date, Athlete athlete, Discipline discipline, double distance) {
        super(trackMeet, date, athlete, discipline); // Use discipline's result type
        this.distance = distance;
    }
}
