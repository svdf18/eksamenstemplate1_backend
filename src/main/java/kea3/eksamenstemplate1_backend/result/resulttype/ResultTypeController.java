package kea3.eksamenstemplate1_backend.result.resulttype;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/results")
public class ResultTypeController {

    private final ResultTypeService resultTypeService;

    public ResultTypeController(ResultTypeService resultTypeService) {
        this.resultTypeService = resultTypeService;
    }

    @GetMapping("/all")
    public List<ResultTypeDTO> getAllResults() {
        return resultTypeService.getAllResults();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResultTypeDTO> getResultById(@PathVariable Long id) {
        Optional<ResultTypeDTO> resultTypeDTO = Optional.ofNullable(resultTypeService.getResultById(id));
        if (resultTypeDTO.isPresent()) {
            return ResponseEntity.ok(resultTypeDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResultTypeDTO> createResult(@RequestBody ResultTypeDTO resultTypeDTO) {
        try {
            ResultTypeDTO createdResult = resultTypeService.createResult(resultTypeDTO);
            return ResponseEntity.ok(createdResult);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<ResultTypeDTO> updateResult(@PathVariable Long id, @RequestBody ResultTypeDTO resultTypeDTO) {
        try {
            ResultTypeDTO updatedResult = resultTypeService.updateResult(id, resultTypeDTO);
            return ResponseEntity.ok(updatedResult);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResultTypeDTO> deleteResult(@PathVariable Long id) {
        try {
            ResultTypeDTO deletedResult = resultTypeService.deleteResult(id);
            return ResponseEntity.ok(deletedResult);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
