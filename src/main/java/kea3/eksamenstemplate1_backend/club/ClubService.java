package kea3.eksamenstemplate1_backend.club;

import kea3.eksamenstemplate1_backend.athlete.Athlete;
import kea3.eksamenstemplate1_backend.athlete.AthleteDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubService {

    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public List<ClubDTO> getAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ClubDTO getClubById(Long id) {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Club not found with ID: " + id));
        return convertToDTO(club);
    }

    public ClubDTO convertToDTO(Club club) {
        return new ClubDTO(club.getId(), club.getName(), club.getCity());
    }
}
