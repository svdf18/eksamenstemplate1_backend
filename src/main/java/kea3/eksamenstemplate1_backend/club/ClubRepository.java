package kea3.eksamenstemplate1_backend.club;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Club findByName(String name);
}
