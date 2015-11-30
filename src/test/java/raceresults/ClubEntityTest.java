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
import raceresults.entity.Club;
import raceresults.repository.ClubRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestPersistenceContext.class })
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class })
public class ClubEntityTest {

    @Autowired
    private ClubRepository clubRepository;

    @Test
    public void searchNoRacesShouldResultEmptyList() throws Exception {

        List<Club> clubs = clubRepository.findAll();
        Assert.assertEquals(0, clubs.size());
    }

    @Test
    public void createReadTest() throws Exception {
        clubRepository.save(new Club("Vegan energy food team"));

        List<Club> clubs = clubRepository.findAll();
        Assert.assertEquals(1, clubs.size());

        Club testClub = clubs.get(0);
        Assert.assertEquals("Vegan energy food team", testClub.getName());
    }
}