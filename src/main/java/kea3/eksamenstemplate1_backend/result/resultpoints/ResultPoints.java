package kea3.eksamenstemplate1_backend.result.resultpoints;

import jakarta.persistence.Entity;
import kea3.eksamenstemplate1_backend.result.resulttype.ResultType;
import lombok.Getter;
import lombok.Setter;

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

        public ResultPoints(ResultType resultType, int points) {
                super();
                this.points = points;
        }
}
