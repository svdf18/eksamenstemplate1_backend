package kea3.eksamenstemplate1_backend.trackmeet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trackmeets")
public class TrackMeetController {


    private final TrackMeetService trackMeetService;

    public TrackMeetController(TrackMeetService trackMeetService) {
        this.trackMeetService = trackMeetService;
    }

    @GetMapping("/all")
    public List<TrackMeetDTO> getAllTrackMeets() {
        return trackMeetService.getAllTrackMeets();
    }
}
