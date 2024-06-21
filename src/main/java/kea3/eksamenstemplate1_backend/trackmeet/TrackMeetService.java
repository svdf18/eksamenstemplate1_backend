package kea3.eksamenstemplate1_backend.trackmeet;

import kea3.eksamenstemplate1_backend.club.Club;
import kea3.eksamenstemplate1_backend.club.ClubDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrackMeetService {


    private final TrackMeetRepository trackMeetRepository;

    public TrackMeetService(TrackMeetRepository trackMeetRepository) {
        this.trackMeetRepository = trackMeetRepository;
    }

    public List<TrackMeetDTO> getAllTrackMeets() {
        List<TrackMeet> trackMeets = trackMeetRepository.findAll();
        return trackMeets.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public TrackMeetDTO convertToDTO(TrackMeet trackMeet) {
        return new TrackMeetDTO(trackMeet.getId(), trackMeet.getName());
    }
}
