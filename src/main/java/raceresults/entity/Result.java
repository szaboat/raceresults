package raceresults.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Result {

	public enum Status {
		FINISHED, DNF, DSQ, DNS
	}

	@Embeddable
	public static class Key implements Serializable {

		@ManyToOne
		private Racer racer;
		@ManyToOne
		private Race race;

		protected Key() {
		}

		public Key(Racer racer, Race race) {
			this.racer = racer;
			this.race = race;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Key key = (Key) o;
			return Objects.equals(racer, key.racer) &&
					Objects.equals(race, key.race);
		}

		@Override
		public int hashCode() {
			return Objects.hash(racer, race);
		}
	}

	@EmbeddedId
	private Key key;

	private int totalTime;
	private int position;
	private String raceNumber;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date importedAt;

	protected Result() {
	}

	public Result(Racer racer, Race race, int totalTime, int position, String raceNumber, Status status, Date importedAt) {
		this.key = new Key(racer, race);
		this.totalTime = totalTime;
		this.position = position;
		this.raceNumber = raceNumber;
		this.status = status;
		this.importedAt = importedAt;
	}

	public Race getRace() {
		return key.race;
	}

	public Racer getRacer() {
		return key.racer;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public int getPosition() {
		return position;
	}

	public String getRaceNumber() {
		return raceNumber;
	}

	public Status getStatus() {
		return status;
	}

	public Date getImportedAt() {
		return importedAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Result result = (Result) o;
		return Objects.equals(key, result.key);
	}

	@Override
	public int hashCode() {
		return Objects.hash(key);
	}
}
