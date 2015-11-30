package raceresults.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import raceresults.entity.Racer;

import java.util.List;

@Repository
public interface RacerRepository extends CrudRepository<Racer, Long>{
    List<Racer> findAll();
}
