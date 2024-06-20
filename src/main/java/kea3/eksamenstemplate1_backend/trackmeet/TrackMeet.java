package kea3.eksamenstemplate1_backend.trackmeet;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TrackMeet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public TrackMeet() {}

    public TrackMeet(String name) {
        this.name = name;
    }
}
