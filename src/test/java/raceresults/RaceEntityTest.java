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
        Assert.assertEquals(0, races.size());
    }

    @Test
    public void createRead() throws Exception {
        Date today = new Date();
        raceRepository.save(new Race("I. Crossliget", "Crossliget", "http://crossliget.hu", today, "CX", "Budapest"));

        List<Race> races = raceRepository.findAll();
        Assert.assertEquals(1, races.size());

        Race testRace = races.get(0);
        Assert.assertEquals(testRace.getName(), "I. Crossliget");
        Assert.assertEquals(testRace.getUrl(), "http://crossliget.hu");
        Assert.assertEquals(testRace.getShortName(), "Crossliget");
        Assert.assertEquals(testRace.getLocation(), "Budapest");
        Assert.assertEquals(testRace.getType(), "CX");
    }
}