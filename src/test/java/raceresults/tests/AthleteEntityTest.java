package raceresults.tests;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import raceresults.entity.Athlete;
import raceresults.repository.AthleteRepository;

import static org.junit.Assert.assertEquals;

public class AthleteEntityTest extends EntityTest {

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