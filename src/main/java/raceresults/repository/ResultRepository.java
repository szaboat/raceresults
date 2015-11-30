package raceresults.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import raceresults.entity.Result;

import java.util.List;

@Repository
public interface ResultRepository extends CrudRepository<Result, Result.Key> {

	List<Result> findAll();

}
