package raceresults;

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
import raceresults.entity.Racer;
import raceresults.repository.RacerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestPersistenceContext.class })
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class })
public class RacerEntityTest {

    @Autowired
    private RacerRepository racerRepository;

    @Test
    public void searchNoRacesShouldResultEmptyList() throws Exception {

        List<Racer> races = racerRepository.findAll();
        Assert.assertEquals(0, races.size());
    }

    @Test
    public void createReadTest() throws Exception {
        racerRepository.save(new Racer("Arvay Denes", 1981));

        List<Racer> racers = racerRepository.findAll();
        Assert.assertEquals(1, racers.size());

        Racer denes = racers.get(0);
        Assert.assertEquals("Arvay Denes", denes.getName());
        Assert.assertEquals(1981, denes.getYearOfBirth());
    }
}