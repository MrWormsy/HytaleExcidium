package fr.mrwormsy.hytaleserver.excidium.gamemode;

import fr.mrwormsy.hytaleserver.excidium.settings.Settings;

public class Guardian {

	private int hp;
	
	public Guardian(int teamId) {
		this.hp = Settings.GUARDIAN_STARTING_LIFE;
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
