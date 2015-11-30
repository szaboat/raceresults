package raceresults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String shortName;
    private String url;
    private Date date;
    private String type;
    private String location;

    protected Race() { }

    public Race(String name, String shortName, String url, Date date, String type, String location) {
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

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }
}