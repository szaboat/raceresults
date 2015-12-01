package raceresults.tests;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import raceresults.entity.Race;
import raceresults.entity.Race.Type;
import raceresults.repository.RaceRepository;

import static org.junit.Assert.assertEquals;

public class RaceEntityTest extends EntityTest {

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

    @Test
    public void testCreateRaceWithResults() throws Exception {

    }

}