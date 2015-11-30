package raceresults.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import raceresults.entity.Club;

import java.util.List;

@Repository
public interface ClubRepository extends CrudRepository<Club, Long>{
    List<Club> findAll();
}
