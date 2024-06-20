package kea3.eksamenstemplate1_backend.athlete;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/athletes")
public class AthleteController {

    private final AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }

    @GetMapping("/all")
    public List<AthleteDTO> getAllAthletes() {
        return athleteService.getAllAthletes();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<AthleteDTO> getAthleteById(@PathVariable Long id) {
        Optional<AthleteDTO> athleteDTO = Optional.ofNullable(athleteService.getAthleteById(id));
        if (athleteDTO.isPresent()) {
            return ResponseEntity.ok(athleteDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<AthleteDTO> createAthlete(@RequestBody AthleteDTO athleteDTO) {
        try {
            AthleteDTO createdAthlete = athleteService.createAthlete(athleteDTO);
            return ResponseEntity.ok(createdAthlete);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<AthleteDTO> updateAthlete(@PathVariable Long id, @RequestBody AthleteDTO athleteDTO) {
        try {
            AthleteDTO updatedAthlete = athleteService.updateAthlete(id, athleteDTO);
            return ResponseEntity.ok(updatedAthlete);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AthleteDTO> deleteAthlete(@PathVariable Long id) {
        try {
            AthleteDTO deletedAthlete = athleteService.deleteAthlete(id);
            return ResponseEntity.ok(deletedAthlete);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
