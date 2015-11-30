package raceresults.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import raceresults.entity.Athlete;

import java.util.List;

@Repository
public interface AthleteRepository extends CrudRepository<Athlete, Long>{
    List<Athlete> findAll();
}
