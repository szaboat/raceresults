package raceresults.repository;

import org.springframework.data.repository.CrudRepository;
import raceresults.entity.Racer;

import java.util.List;

public interface RacerRepository extends CrudRepository<Racer, Long>{
    List<Racer> findAll();
}
