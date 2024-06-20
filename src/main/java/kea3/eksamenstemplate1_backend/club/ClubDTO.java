package kea3.eksamenstemplate1_backend.club;

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
