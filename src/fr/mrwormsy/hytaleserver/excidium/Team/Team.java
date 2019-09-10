package fr.mrwormsy.hytaleserver.excidium.Team;

import java.util.ArrayList;

import fr.mrwormsy.hytaleserver.excidium.ExcidiumMain;
import fr.mrwormsy.hytaleserver.excidium.gamemode.ExcidiumPlayer;
import fr.mrwormsy.hytaleserver.excidium.gamemode.Guardian;
import fr.mrwormsy.hytaleserver.excidium.gamemode.Shell;
import fr.mrwormsy.hytaleserver.excidium.lang.Lang;
import fr.mrwormsy.hytaleserver.excidium.phase.Phase;
import fr.mrwormsy.hytaleserver.excidium.settings.Settings;
import fr.mrwormsy.hytaleserver.excidium.utils.Utils;

public class Team {

	private int id;
	private TeamName teamName;
	private ArrayList<Phase> phases;
	
	private ArrayList<ExcidiumPlayer> players;
	
	private Shell shell;
	private Guardian guardian;
	
	// Constructor
	public Team(int id, TeamName teamName) {
		
		// First we set the id of the team;
		this.setId(id);
		
		// Then the team's name
		this.setTeamName(teamName);
		
		// Then set the phase zero to the team
		this.setPhases(new ArrayList<Phase>());
		this.phases.add(Phase.ZERO);
		
		// Create an empty set of players
		this.setPlayers(new ArrayList<ExcidiumPlayer>());
		
		// Summon a Shell and a Guardian inside
		this.setShell(new Shell(id));
		this.setGuardian(new Guardian(id));
	}

	// Methods
	
	// Make the player damages the shell (we still do the test, if the phase is the good one)
	public void damageShell(ExcidiumPlayer player) {
		if (this.phases.get(this.phases.size() - 1).getId() == Phase.ONE.getId()) {
			
			// If the shell wont be broken after this time
			if (this.getShell().getHp() - 1 >= 1) {
				this.getShell().damage(1);
				Utils.sendMessageToAllPlayers(Lang.ENEMY_DAMAGED_SHELL.toString().replaceAll("<team_attack>", player.getTeam().getTeamName().getName()).replaceAll("<team_victim>", this.getTeamName().getName()));
			
				// Reward player and the team
				for (ExcidiumPlayer pl : player.getTeam().getPlayers()) {
					
					// If this is the damaging player
					if (player == pl) {
						pl.giveCoins(Settings.PLAYER_COIN_REWARD_DAMAGING_SHELL);
						pl.sendMessage(Lang.PLAYER_RECEIVED_COINS_DAMAGING_SHELL.toString().replaceAll("<amount>", String.valueOf(Settings.PLAYER_COIN_REWARD_DAMAGING_SHELL)));
						pl.giveFame(Settings.PLAYER_FAME_REWARD_DAMAGING_SHELL);
						pl.sendMessage(Lang.PLAYER_RECEIVED_FAME_DAMAGING_SHELL.toString().replaceAll("<amount>", String.valueOf(Settings.PLAYER_FAME_REWARD_DAMAGING_SHELL)));
					} else {
						pl.giveCoins(Settings.TEAM_COIN_REWARD_DAMAGING_SHELL);
						pl.sendMessage(Lang.PLAYER_RECEIVED_COINS_TEAM_DAMAGING_SHELL.toString().replaceAll("<amount>", String.valueOf(Settings.TEAM_COIN_REWARD_DAMAGING_SHELL)));
					}
				}
			}
			
			// If it will we need to notify it clearly and change the Team's phase
			else {
				Utils.sendMessageToAllPlayers(Lang.ENEMY_KILLED_SHELL.toString().replaceAll("<team_attack>", player.getTeam().getTeamName().getName()).replaceAll("<team_victim>", this.getTeamName().getName()));
			
				// Reward player and the team
				for (ExcidiumPlayer pl : player.getTeam().getPlayers()) {
					
					// If this is the damaging player
					if (player == pl) {
						pl.giveCoins(Settings.PLAYER_COIN_REWARD_DESTROYING_SHELL);
						pl.sendMessage(Lang.PLAYER_RECEIVED_COINS_DESTROYING_SHELL.toString().replaceAll("<amount>", String.valueOf(Settings.PLAYER_COIN_REWARD_DESTROYING_SHELL)));
						pl.giveFame(Settings.PLAYER_FAME_REWARD_DESTROYING_SHELL);
						pl.sendMessage(Lang.PLAYER_RECEIVED_FAME_DESTROYING_SHELL.toString().replaceAll("<amount>", String.valueOf(Settings.PLAYER_FAME_REWARD_DESTROYING_SHELL)));
					} else {
						pl.giveCoins(Settings.TEAM_COIN_REWARD_DESTROYING_SHELL);
						pl.sendMessage(Lang.PLAYER_RECEIVED_COINS_TEAM_DESTROYING_SHELL.toString().replaceAll("<amount>", String.valueOf(Settings.TEAM_COIN_REWARD_DESTROYING_SHELL)));
					}
				}
				
				this.makeTeamChangePhase();
			}
		}
	}
	
	// Make the player damages the guardian (we still do the test, if the phase is the good one)
	public void damageGuardian(ExcidiumPlayer player) {
		if (this.phases.get(this.phases.size() - 1).getId() == Phase.TWO.getId()) {
			
			// If the shell wont be broken after this time
			if (this.getGuardian().getHp() - 1 >= 1) {
				this.getGuardian().damage(1);
				Utils.sendMessageToAllPlayers(Lang.ENEMY_DAMAGED_GUARDIAN.toString().replaceAll("<team_attack>", player.getTeam().getTeamName().getName()).replaceAll("<team_victim>", this.getTeamName().getName()));
			
				// Reward player and the team
				for (ExcidiumPlayer pl : player.getTeam().getPlayers()) {
					
					// If this is the damaging player
					if (player == pl) {
						pl.giveCoins(Settings.PLAYER_COIN_REWARD_DAMAGING_GUARDIAN);
						pl.sendMessage(Lang.PLAYER_RECEIVED_COINS_DAMAGING_GUARDIAN.toString().replaceAll("<amount>", String.valueOf(Settings.PLAYER_COIN_REWARD_DAMAGING_GUARDIAN)));
						pl.giveFame(Settings.PLAYER_FAME_REWARD_DAMAGING_GUARDIAN);
						pl.sendMessage(Lang.PLAYER_RECEIVED_FAME_DAMAGING_GUARDIAN.toString().replaceAll("<amount>", String.valueOf(Settings.PLAYER_FAME_REWARD_DAMAGING_GUARDIAN)));
					} else {
						pl.giveCoins(Settings.TEAM_COIN_REWARD_DAMAGING_GUARDIAN);
						pl.sendMessage(Lang.PLAYER_RECEIVED_COINS_TEAM_DAMAGING_GUARDIAN.toString().replaceAll("<amount>", String.valueOf(Settings.TEAM_COIN_REWARD_DAMAGING_GUARDIAN)));
					}
				}
			
			}
			
			// If it will we need to notify it clearly and change the Team's phase
			else {
				Utils.sendMessageToAllPlayers(Lang.ENEMY_KILLED_GUARDIAN.toString().replaceAll("<team_attack>", player.getTeam().getTeamName().getName()).replaceAll("<team_victim>", this.getTeamName().getName()));
			
				// Reward player and the team
				for (ExcidiumPlayer pl : player.getTeam().getPlayers()) {
					
					// If this is the damaging player
					if (player == pl) {
						pl.giveCoins(Settings.PLAYER_COIN_REWARD_DESTROYING_GUARDIAN);
						pl.sendMessage(Lang.PLAYER_RECEIVED_COINS_DESTROYING_GUARDIAN.toString().replaceAll("<amount>", String.valueOf(Settings.PLAYER_COIN_REWARD_DESTROYING_GUARDIAN)));
						pl.giveFame(Settings.PLAYER_FAME_REWARD_DESTROYING_GUARDIAN);
						pl.sendMessage(Lang.PLAYER_RECEIVED_FAME_DESTROYING_GUARDIAN.toString().replaceAll("<amount>", String.valueOf(Settings.PLAYER_FAME_REWARD_DESTROYING_GUARDIAN)));
					} else {
						pl.giveCoins(Settings.TEAM_COIN_REWARD_DESTROYING_GUARDIAN);
						pl.sendMessage(Lang.PLAYER_RECEIVED_COINS_TEAM_DESTROYING_GUARDIAN.toString().replaceAll("<amount>", String.valueOf(Settings.TEAM_COIN_REWARD_DESTROYING_GUARDIAN)));
					}
				}
				
				this.makeTeamChangePhase();
			}
		}
	}
	
	// This method is used to change the phase of a team. Everything changes here...
	public void makeTeamChangePhase() {
		
		switch (this.getPhases().get(this.getPhases().size() - 1).getId()) {
		case 0:
			
			// We dont say that the team's phase has changed because every teams will change and we dont want to spam, we will set a global message...
			
			// We thus upgrade from phase 0 to phase 1
			
			// We end the last phase and add the new one
			this.getPhases().get(this.getPhases().size() - 1).setFinishingTime(System.currentTimeMillis() / 1000l);
			
			this.getPhases().add(Phase.ONE);
			
			break;
		case 1:
			
			// We thus upgrade from phase 1 to phase 2
			
			// We end the last phase and add the new one
			this.getPhases().get(this.getPhases().size() - 1).setFinishingTime(System.currentTimeMillis() / 1000l);
			
			this.getPhases().add(Phase.TWO);
			
			break;
		case 2:
			
			// We thus upgrade from phase 2 to phase 3 (The END)
			
			// We end the last phase and add the new one
			this.getPhases().get(this.getPhases().size() - 1).setFinishingTime(System.currentTimeMillis() / 1000l);
			
			this.getPhases().add(Phase.THREE);
				
			// If this team was the last last one on this phase, this latter has won !
			Team winners = null;
			int numberOfTeamAlive = 0;
			for(Team team : ExcidiumMain.gameManager.getTeams()) {
					if (team.getPhases().size() <= 3) {
					numberOfTeamAlive++;
					winners = team;
				}
			}
						
			// If only one team is alive that means that this one is the winner
			if (numberOfTeamAlive == 1) {
				Utils.sendMessageToAllPlayers(Lang.TEAM_HAS_WON.toString().replaceAll("<winners>", winners.getTeamName().getName()));
				ExcidiumMain.gameManager.endTheGame(winners);
			}
			
			break;
		}
		
	}
	
	// GETTERS AND SETTERS
	
	public TeamName getTeamName() {
		return teamName;
	}

	public void setTeamName(TeamName teamName) {
		this.teamName = teamName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Phase> getPhases() {
		return phases;
	}

	public void setPhases(ArrayList<Phase> phases) {
		this.phases = phases;
	}

	public ArrayList<ExcidiumPlayer> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<ExcidiumPlayer> players) {
		this.players = players;
	}

	public Shell getShell() {
		return shell;
	}

	public void setShell(Shell shell) {
		this.shell = shell;
	}

	public Guardian getGuardian() {
		return guardian;
	}

	public void setGuardian(Guardian guardian) {
		this.guardian = guardian;
	}
	
}
