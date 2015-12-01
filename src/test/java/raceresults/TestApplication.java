package raceresults;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import raceresults.config.DatabaseConfig;
import raceresults.controller.HomeController;
import raceresults.entity.Athlete;
import raceresults.repository.AthleteRepository;

@EnableAutoConfiguration(exclude = DatabaseConfig.class)
@ComponentScan(basePackageClasses = { HomeController.class, Athlete.class, AthleteRepository.class })
public class TestApplication {
}
