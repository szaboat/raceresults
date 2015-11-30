package raceresults.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Result {

	public enum Status {
		OK, DNF, DSQ, DNS
	}

	@Embeddable
	public static class Key implements Serializable {

		private long racerId;
		private long raceId;

		protected Key() {
		}

		public Key(long racerId, long raceId) {
			this.racerId = racerId;
			this.raceId = raceId;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Key key = (Key) o;
			return racerId == key.racerId &&
					raceId == key.raceId;
		}

		@Override
		public int hashCode() {
			return Objects.hash(racerId, raceId);
		}
	}

	@EmbeddedId
	private Key key;

	private int totalTime;
	private int position;
	private String raceNumber;

	@Temporal(TemporalType.TIMESTAMP)
	private Date importedAt;

	protected Result() {
	}

	public Result(long racerId, long raceId, int totalTime, int position, String raceNumber, Date importedAt) {
		this.key = new Key(racerId, raceId);
		this.totalTime = totalTime;
		this.position = position;
		this.raceNumber = raceNumber;
		this.importedAt = importedAt;
	}

	public long getRacerId() {
		return key.racerId;
	}

	public long getRaceId() {
		return key.raceId;
	}

	public Key getKey() {
		return key;
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

	public Date getImportedAt() {
		return importedAt;
	}
}
