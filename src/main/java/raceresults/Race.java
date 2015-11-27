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

    public String getName() {
        return name;
    }
}
