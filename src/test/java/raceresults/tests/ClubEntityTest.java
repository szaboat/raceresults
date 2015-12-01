package raceresults.tests;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import raceresults.entity.Club;
import raceresults.repository.ClubRepository;

import static org.junit.Assert.assertEquals;

public class ClubEntityTest extends EntityTest {

    @Autowired
    private ClubRepository clubRepository;

    @Test
    public void searchNoRacesShouldResultEmptyList() throws Exception {

        List<Club> clubs = clubRepository.findAll();
        assertEquals(0, clubs.size());
    }

    @Test
    public void createReadTest() throws Exception {
        clubRepository.save(new Club("Vegan energy food team"));

        List<Club> clubs = clubRepository.findAll();
        assertEquals(1, clubs.size());

        Club testClub = clubs.get(0);
        assertEquals("Vegan energy food team", testClub.getName());
    }
}