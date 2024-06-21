package kea3.eksamenstemplate1_backend.result.resulttype;

import kea3.eksamenstemplate1_backend.athlete.Athlete;
import kea3.eksamenstemplate1_backend.discipline.Discipline;
import kea3.eksamenstemplate1_backend.result.resultdistance.ResultDistance;
import kea3.eksamenstemplate1_backend.result.resultpoints.ResultPoints;
import kea3.eksamenstemplate1_backend.result.resulttime.ResultTime;
import kea3.eksamenstemplate1_backend.trackmeet.TrackMeet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultTypeService {

    private final ResultTypeRepository resultTypeRepository;

    public ResultTypeService(ResultTypeRepository resultTypeRepository) {
        this.resultTypeRepository = resultTypeRepository;
    }

    public List<ResultTypeDTO> getAllResults() {
        List<ResultType> results = resultTypeRepository.findAll();
        return results.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ResultTypeDTO getResultById(Long id) {
        ResultType result = resultTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Result not found with ID: " + id));
        return convertToDTO(result);
    }

    public ResultTypeDTO createResult(ResultTypeDTO resultTypeDTO) {
        ResultType resultType = convertToEntity(resultTypeDTO);
        resultTypeRepository.save(resultType);
        return convertToDTO(resultType);
    }

    public ResultTypeDTO updateResult(Long id, ResultTypeDTO resultTypeDTO) {
        ResultType existingResult = resultTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Result not found with ID: " + id));

        existingResult.setTrackMeet(resultTypeDTO.getTrackMeet());
        existingResult.setDate(resultTypeDTO.getDate());
        existingResult.setAthlete(resultTypeDTO.getAthlete());
        existingResult.setDiscipline(resultTypeDTO.getDiscipline());

        if (existingResult instanceof ResultTime) {
            ((ResultTime) existingResult).setTime(resultTypeDTO.getTime());
        } else if (existingResult instanceof ResultPoints) {
            ((ResultPoints) existingResult).setPoints(resultTypeDTO.getPoints());
        } else if (existingResult instanceof ResultDistance) {
            ((ResultDistance) existingResult).setDistance(resultTypeDTO.getDistance());
        }

        resultTypeRepository.save(existingResult);
        return convertToDTO(existingResult);
    }

    public ResultTypeDTO deleteResult(Long id) {
        ResultType result = resultTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Result not found with ID: " + id));
        resultTypeRepository.delete(result);
        return convertToDTO(result);
    }

    public ResultTypeDTO convertToDTO(ResultType resultType) {
        if (resultType instanceof ResultTime) {
            ResultTime resultTime = (ResultTime) resultType;
            return new ResultTypeDTO(
                    resultTime.getId(), resultTime.getTrackMeet(), resultTime.getDate(),
                    resultTime.getAthlete(), resultTime.getDiscipline(), ResultTypeEnum.TIME,
                    resultTime.getTime(), null, null);
        } else if (resultType instanceof ResultPoints) {
            ResultPoints resultPoints = (ResultPoints) resultType;
            return new ResultTypeDTO(
                    resultPoints.getId(), resultPoints.getTrackMeet(), resultPoints.getDate(),
                    resultPoints.getAthlete(), resultPoints.getDiscipline(), ResultTypeEnum.POINTS,
                    null, resultPoints.getPoints(), null);
        } else if (resultType instanceof ResultDistance) {
            ResultDistance resultDistance = (ResultDistance) resultType;
            return new ResultTypeDTO(
                    resultDistance.getId(), resultDistance.getTrackMeet(), resultDistance.getDate(),
                    resultDistance.getAthlete(), resultDistance.getDiscipline(), ResultTypeEnum.DISTANCE,
                    null, null, resultDistance.getDistance());
        }
        return null;
    }

    private ResultType convertToEntity(ResultTypeDTO resultTypeDTO) {
        switch (resultTypeDTO.getResultType()) {
            case TIME:
                return new ResultTime(
                        resultTypeDTO.getTrackMeet(), resultTypeDTO.getDate(), resultTypeDTO.getAthlete(),
                        resultTypeDTO.getDiscipline(), resultTypeDTO.getTime());
            case POINTS:
                return new ResultPoints(
                        resultTypeDTO.getTrackMeet(), resultTypeDTO.getDate(), resultTypeDTO.getAthlete(),
                        resultTypeDTO.getDiscipline(), resultTypeDTO.getPoints());
            case DISTANCE:
                return new ResultDistance(
                        resultTypeDTO.getTrackMeet(), resultTypeDTO.getDate(), resultTypeDTO.getAthlete(),
                        resultTypeDTO.getDiscipline(), resultTypeDTO.getDistance());
            default:
                throw new IllegalArgumentException("Invalid result type");
        }
    }
}
