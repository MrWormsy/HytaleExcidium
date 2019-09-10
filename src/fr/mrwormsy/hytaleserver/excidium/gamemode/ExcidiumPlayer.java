package fr.mrwormsy.hytaleserver.excidium.gamemode;

import fr.mrwormsy.hytaleserver.excidium.Team.Team;

public class ExcidiumPlayer {

	private String name;
	private int coins;
	private int fame;
	private boolean online;
	private Team team;
	
	// Create an Excidum Player and retrieving all its stats from the database (those stats will be saved when the player disconnects)
	public ExcidiumPlayer(String name) {
		this.setName(name);
		this.setOnline(true);
		this.setTeam(null);;
	}
	
	public Team getTeam() {
		return this.team;
	}

	public void giveCoins(int coins) {
		this.coins += coins;
	}

	public void giveFame(int coins) {
		this.fame += coins;
	}
	
	// Send a message to a Player
	public void sendMessage(String message) {
		
	}
	
	// Save player's stats
	public void saveStats() {
		
	}

	// GETTERS AND SETTERS
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public int getFame() {
		return fame;
	}

	public void setFame(int fame) {
		this.fame = fame;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
}
