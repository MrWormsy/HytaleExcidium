package fr.mrwormsy.hytaleserver.excidium.phase;

public enum Phase {

	ZERO(0),
	ONE(1),
	TWO(2),
	THREE(3);
	
	private int id;
	private long startingTime;
	private long finishingTime;
	
	private Phase(int id) {
		this.id = id;
		this.startingTime = System.currentTimeMillis() / 1000l;
		this.finishingTime = -1l;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(long startingTime) {
		this.startingTime = startingTime;
	}

	public long getFinishingTime() {
		return finishingTime;
	}

	public void setFinishingTime(long finishingTime) {
		this.finishingTime = finishingTime;
	}
}
