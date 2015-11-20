package raceresults;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RaceRepository extends CrudRepository<Race, Long> {

    List<Race> findAll();
}
