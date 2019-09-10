package fr.mrwormsy.hytaleserver.excidium.gamemode;

import fr.mrwormsy.hytaleserver.excidium.settings.Settings;

public class Shell {

	private int hp;

	public Shell(int teamId) {
		this.hp = Settings.SHELL_STARTING_LIFE;
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void damage(int damages) {
		this.hp -= damages;
	}
	
	public void heal(int health) {
		this.hp += health;
	}
	
}
