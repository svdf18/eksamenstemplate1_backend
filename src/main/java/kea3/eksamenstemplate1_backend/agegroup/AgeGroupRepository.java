package kea3.eksamenstemplate1_backend.agegroup;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgeGroupRepository extends JpaRepository<AgeGroup, Long> {
    AgeGroup findByAgeGroupName(AgeGroupEnum ageGroupName);
}
