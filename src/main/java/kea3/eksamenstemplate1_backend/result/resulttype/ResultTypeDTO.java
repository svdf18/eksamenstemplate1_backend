package kea3.eksamenstemplate1_backend.result.resulttype;

import kea3.eksamenstemplate1_backend.athlete.Athlete;
import kea3.eksamenstemplate1_backend.discipline.Discipline;
import kea3.eksamenstemplate1_backend.trackmeet.TrackMeet;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResultTypeDTO {

    private Long id;
    private TrackMeet trackMeet;
    private LocalDateTime date;
    private Athlete athlete;
    private Discipline discipline;
    private ResultTypeEnum resultType;
    private Double time;
    private Integer points;
    private Double distance;

    public ResultTypeDTO() {
    }

    public ResultTypeDTO(Long id, TrackMeet trackMeet, LocalDateTime date, Athlete athlete, Discipline discipline, ResultTypeEnum resultType, Double time, Integer points, Double distance) {
        this.id = id;
        this.trackMeet = trackMeet;
        this.date = date;
        this.athlete = athlete;
        this.discipline = discipline;
        this.resultType = resultType;
        this.time = time;
        this.points = points;
        this.distance = distance;
    }
}