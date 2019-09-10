package fr.mrwormsy.hytaleserver.excidium.gamemanager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import fr.mrwormsy.hytaleserver.excidium.Team.Team;
import fr.mrwormsy.hytaleserver.excidium.Team.TeamName;
import fr.mrwormsy.hytaleserver.excidium.gamemode.ExcidiumPlayer;
import fr.mrwormsy.hytaleserver.excidium.lang.Lang;
import fr.mrwormsy.hytaleserver.excidium.settings.Settings;
import fr.mrwormsy.hytaleserver.excidium.utils.Utils;

public class GameManager {

	private enum State {STARTING, WAITING, FARMING, PVP, ENDING};
	
	private ArrayList<Team> teams;
	private ArrayList<ExcidiumPlayer> players;
	
	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}

	public GameManager() {
		
		
		// First we add the teams (we choose randomly the teams between the 8 ones)
		teams = new ArrayList<Team>();

		ArrayList<Integer> teamIds = new ArrayList<Integer>();
		for(int i = 0; i < 8; i++) {
			teamIds.add(i);
		}

		Collections.shuffle(teamIds);
		
		for(int i = 0; i < Settings.NUMBER_OF_TEAMS; i++) {
			teams.add(new Team(i, TeamName.getTeamNameFromId(teamIds.get(i))));
			
			// DEBUG
			// System.out.println(teams.get(i).getTeamName());
		}
		
	}

	// METHODS
	
	// Launch the game and open it to the players
	public void launch() {
		
		// Here we need to wait x minutes to set all the team to phase 1
		new Timer().schedule( 
		        new TimerTask() {
		            @Override
		            public void run() {
		                // Set all the team to phase 1
		            	
		            	Utils.sendMessageToAllPlayers(Lang.PHASE_ZERO_IS_OVER.toString());
		            	
		            	for (Team team : teams) {
		            		team.makeTeamChangePhase();
		            	}
		            }
		        }, Settings.DURATION_PHASE_ZERO * 1000l);
	}
	
	// End the game : rewards ect...
	public void endTheGame(Team winners) {
		
		// Give rewards (even for the ones who disconnected)
		for (ExcidiumPlayer player : winners.getPlayers()) {
			player.giveCoins(Settings.PLAYER_COIN_REWARD_WINNING);
			player.sendMessage(Lang.PLAYER_RECEIVED_COINS_WINNING.toString().replaceAll("<amount>", String.valueOf(Settings.PLAYER_COIN_REWARD_WINNING)));
			player.giveFame(Settings.PLAYER_FAME_REWARD_WINNING);
			player.sendMessage(Lang.PLAYER_RECEIVED_FAME_WINNING.toString().replaceAll("<amount>", String.valueOf(Settings.PLAYER_FAME_REWARD_WINNING)));
		}	
	}

	// Get an ExcidiumPlayer from his name
	public ExcidiumPlayer getExcidiumPlayerFromName(String name) {
		for (ExcidiumPlayer excidiumPlayer : players) {
			if (excidiumPlayer.getName().equalsIgnoreCase(name)) {
				return excidiumPlayer;
			}
		}
		
		return null;
	}
	
	// GETTERS AND SETTERS
	
	public ArrayList<ExcidiumPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<ExcidiumPlayer> players) {
		this.players = players;
	}
	
}
