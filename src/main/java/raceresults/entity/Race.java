package raceresults.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Race {

    public enum Type {
       XCO, CX, XCM, ROAD, XCU
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String shortName;
    private String url;
    private Date date;

    @Enumerated(EnumType.STRING)
    private Type type;
    private String location;

    protected Race() { }

    public Race(String name, String shortName, String url, Date date, Type type, String location) {
        this.name = name;
        this.shortName = shortName;
        this.url = url;
        this.date = date;
        this.type = type;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getUrl() {
        return url;
    }

    public Date getDate() {
        return date;
    }

    public Type getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return id == race.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}