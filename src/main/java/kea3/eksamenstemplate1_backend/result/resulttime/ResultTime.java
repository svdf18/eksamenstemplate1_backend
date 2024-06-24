package kea3.eksamenstemplate1_backend.result.resulttime;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import kea3.eksamenstemplate1_backend.athlete.Athlete;
import kea3.eksamenstemplate1_backend.discipline.Discipline;
import kea3.eksamenstemplate1_backend.result.resulttype.ResultType;
import kea3.eksamenstemplate1_backend.trackmeet.TrackMeet;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class ResultTime extends ResultType {

        @Convert(converter = LocalTimeConverter.class)
        private LocalTime time;

        public ResultTime() {
        }

        public ResultTime(LocalTime time) {
                this.time = time;
        }

        public ResultTime(TrackMeet trackMeet, LocalDateTime date, Athlete athlete, Discipline discipline, LocalTime time) {
                super(trackMeet, date, athlete, discipline);
                this.time = time;
        }
}
