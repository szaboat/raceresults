package raceresults;

import java.util.List;

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
import raceresults.repository.AthleteRepository;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestPersistenceContext.class })
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class })
public class AthleteEntityTest {

    @Autowired
    private AthleteRepository athleteRepository;

    @Test
    public void searchNoRacesShouldResultEmptyList() throws Exception {

        List<Athlete> races = athleteRepository.findAll();
        assertEquals(0, races.size());
    }

    @Test
    public void createReadTest() throws Exception {
        athleteRepository.save(new Athlete("Arvay Denes", 1981));

        List<Athlete> athletes = athleteRepository.findAll();
        assertEquals(1, athletes.size());

        Athlete denes = athletes.get(0);
        assertEquals("Arvay Denes", denes.getName());
        assertEquals(1981, denes.getYearOfBirth());
    }
}