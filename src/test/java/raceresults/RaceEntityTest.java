package raceresults;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
import raceresults.repository.RaceRepository;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestPersistenceContext.class })
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class })
public class RaceEntityTest {

    @Autowired
    private RaceRepository raceRepository;

    @Test
    public void searchNoRacesShouldResultEmptyList() throws Exception {

        List<Race> races = raceRepository.findAll();
        assertEquals(0, races.size());
    }

    @Test
    public void createReadTest() throws Exception {
        Date today = new Date();

        raceRepository.save(new Race("I. Crossliget", "Crossliget", "http://crossliget.hu", today, Type.CX, "Budapest"));

        List<Race> races = raceRepository.findAll();
        assertEquals(1, races.size());

        Race testRace = races.get(0);
        assertEquals(testRace.getName(), "I. Crossliget");
        assertEquals(testRace.getUrl(), "http://crossliget.hu");
        assertEquals(testRace.getShortName(), "Crossliget");
        assertEquals(testRace.getLocation(), "Budapest");
        assertEquals(testRace.getType(), Type.CX);
    }
}