package raceresults.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Set;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Racer racer = (Racer) o;
        return id == racer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
