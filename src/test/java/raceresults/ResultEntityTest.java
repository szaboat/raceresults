package raceresults;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import raceresults.entity.Race;
import raceresults.entity.Race.Type;
import raceresults.entity.Result;
import raceresults.repository.RaceRepository;
import raceresults.repository.ResultRepository;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestPersistenceContext.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionDbUnitTestExecutionListener.class})
public class ResultEntityTest {

	@Autowired
	private ResultRepository resultRepository;

	@Test
	public void searchNoResultsShouldResultEmptyList() {
		List<Result> results = resultRepository.findAll();
		Assert.assertEquals(0, results.size());
	}

	@Test
	public void createRead() throws Exception {
		Date today = new Date();
		Result r = new Result(1, 2, 3, 4, "H12", today);
		resultRepository.save(r);

		List<Result> results = resultRepository.findAll();
		Assert.assertEquals(1, results.size());

		Result testResult = results.get(0);
		Assert.assertEquals(1, testResult.getRacerId());
		Assert.assertEquals(2, testResult.getRaceId());
		Assert.assertEquals(3, testResult.getTotalTime());
		Assert.assertEquals(4, testResult.getPosition());
		Assert.assertEquals("H12", testResult.getRaceNumber());
		Assert.assertEquals(today, testResult.getImportedAt());
	}
}