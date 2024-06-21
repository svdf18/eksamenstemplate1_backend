package kea3.eksamenstemplate1_backend.trackmeet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrackMeetDTO {

        private Long id;
        private String name;

        public TrackMeetDTO(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public TrackMeetDTO() {
        }
}
