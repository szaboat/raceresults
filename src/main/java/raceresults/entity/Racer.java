package raceresults.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Racer {

    private String name;
    private int yearOfBirth;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    protected Racer() {}

    public Racer(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
