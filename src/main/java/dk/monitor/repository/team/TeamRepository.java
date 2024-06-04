package dk.monitor.repository.team;

import dk.monitor.domain.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<Team> findByName(String teamName);

}
