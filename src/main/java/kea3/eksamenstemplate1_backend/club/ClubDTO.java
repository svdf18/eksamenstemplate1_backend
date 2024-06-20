package kea3.eksamenstemplate1_backend.club;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClubDTO {
    private Long id;
    private String name;
    private String city;

    public ClubDTO(Long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }
}
