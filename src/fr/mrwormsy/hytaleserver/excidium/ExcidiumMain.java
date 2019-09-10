package fr.mrwormsy.hytaleserver.excidium;

import fr.mrwormsy.hytaleserver.excidium.gamemanager.GameManager;

public class ExcidiumMain {

	public static GameManager gameManager;
	
	public static void main(String[] args) {
		
		
		// TEST
		
		// First create a GameManager
		gameManager = new GameManager();
		
		gameManager.launch();
	}

}
