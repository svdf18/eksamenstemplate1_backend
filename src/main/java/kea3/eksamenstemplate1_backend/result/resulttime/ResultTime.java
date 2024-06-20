package kea3.eksamenstemplate1_backend.result.resulttime;

import jakarta.persistence.Entity;
import kea3.eksamenstemplate1_backend.athlete.Athlete;
import kea3.eksamenstemplate1_backend.discipline.Discipline;
import kea3.eksamenstemplate1_backend.result.resulttype.ResultType;
import kea3.eksamenstemplate1_backend.result.resulttype.ResultTypeEnum;
import kea3.eksamenstemplate1_backend.trackmeet.TrackMeet;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ResultTime extends ResultType {

        private double time;

        public ResultTime() {
        }

        public ResultTime(double time) {
                this.time = time;
        }

        public ResultTime(TrackMeet trackMeet, LocalDateTime date, Athlete athlete, Discipline discipline, double time) {
                super(trackMeet, date, athlete, discipline); // Use discipline's result type
                this.time = time;
        }
}
