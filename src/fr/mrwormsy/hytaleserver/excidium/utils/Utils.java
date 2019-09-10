package fr.mrwormsy.hytaleserver.excidium.utils;

import fr.mrwormsy.hytaleserver.excidium.ExcidiumMain;
import fr.mrwormsy.hytaleserver.excidium.gamemode.ExcidiumPlayer;

public class Utils {

	public static void sendMessageToAllPlayers(String message) {
		System.out.println(message);
	}
	
	public static void handlePlayerJoin(String name) {
		ExcidiumMain.gameManager.getPlayers().add(new ExcidiumPlayer(name));
	}
	
	public static void handlePlayerQuit(ExcidiumPlayer player) {
		
		// First we need to set the player offline
		player.setOnline(false);
		
		
	}
	
}
