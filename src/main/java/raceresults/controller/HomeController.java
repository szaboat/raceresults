package raceresults.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import raceresults.entity.Race;
import raceresults.repository.RaceRepository;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    RaceRepository repository;

    @RequestMapping("/")
    public String home(Model model) {

        List<Race> races = repository.findAll();
        model.addAttribute("races", races);

        return "home";
    }
}
