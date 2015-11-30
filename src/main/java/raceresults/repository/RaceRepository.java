package raceresults.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import raceresults.entity.Race;

@Repository
public interface RaceRepository extends CrudRepository<Race, Long> {

    List<Race> findAll();
}
