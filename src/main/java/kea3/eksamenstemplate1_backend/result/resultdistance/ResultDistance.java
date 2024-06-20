package kea3.eksamenstemplate1_backend.result.resultdistance;

import jakarta.persistence.Entity;
import kea3.eksamenstemplate1_backend.result.resulttype.ResultType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ResultDistance extends ResultType {

    private double distance;
}
