package kea3.eksamenstemplate1_backend.trackmeet;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackMeetRepository extends JpaRepository<TrackMeet, Long> {
    TrackMeet findByName(String name);
}
