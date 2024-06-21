package kea3.eksamenstemplate1_backend.result.resultpoints;

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
public class ResultPoints extends ResultType {

        private int points;

        public ResultPoints() {
        }

        public ResultPoints(int points) {
                this.points = points;
        }

        public ResultPoints(TrackMeet trackMeet, LocalDateTime date, Athlete athlete, Discipline discipline, int points) {
                super(trackMeet, date, athlete, discipline);
                this.points = points;
        }
}
