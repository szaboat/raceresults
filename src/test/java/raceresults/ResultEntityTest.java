package raceresults;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import raceresults.entity.Athlete;
import raceresults.entity.Race;
import raceresults.entity.Race.Type;
import raceresults.entity.Result;
import raceresults.entity.Result.Status;
import raceresults.repository.RaceRepository;
import raceresults.repository.AthleteRepository;
import raceresults.repository.ResultRepository;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestPersistenceContext.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionDbUnitTestExecutionListener.class})
public class ResultEntityTest {

	@Autowired
	private ResultRepository resultRepository;

	@Autowired
	private RaceRepository raceRepository;

	@Autowired
	private AthleteRepository athleteRepository;

	@Test
	public void searchNoResultsShouldResultEmptyList() {
		List<Result> results = resultRepository.findAll();
		assertEquals(0, results.size());
	}

	@Test
	public void createRead() throws Exception {
		Date date = new Date();

		Athlete athlete = new Athlete("Attila", 1981);
		athleteRepository.save(athlete);

		Race race = new Race("24 oras verseny 2016. julius", "24h 2016", "http://sportaktiv.hu", date, Type.XCU, "Zanka");
		raceRepository.save(race);

		Result result = new Result(athlete, race, 24*60*60, 1, "H12", Status.FINISHED, date);
		resultRepository.save(result);

		List<Result> results = resultRepository.findAll();
		assertEquals(1, results.size());

		Result testResult = results.get(0);
		assertEquals(athlete, result.getRacer());
		assertEquals(race, result.getRace());
		assertEquals(24*60*60, testResult.getTotalTime());
		assertEquals(1, testResult.getPosition());
		assertEquals("H12", testResult.getRaceNumber());
		assertEquals(Status.FINISHED, testResult.getStatus());
		assertEquals(date, testResult.getImportedAt());
	}
}