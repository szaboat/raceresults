package raceresults.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Club {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    protected Club() { }

    public Club(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
