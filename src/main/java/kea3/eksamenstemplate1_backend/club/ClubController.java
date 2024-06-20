package kea3.eksamenstemplate1_backend.club;

import kea3.eksamenstemplate1_backend.athlete.AthleteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/all")
    public List<ClubDTO> getAllClubs() {
        return clubService.getAllClubs();
    }

    @GetMapping("/id/{id}")

    public ResponseEntity<ClubDTO> getClubById(@PathVariable Long id) {
        Optional<ClubDTO> clubDTO = Optional.ofNullable(clubService.getClubById(id));
        return clubDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
