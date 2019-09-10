package fr.mrwormsy.hytaleserver.excidium.lang;
 
public enum Lang {
	
	ENEMY_DAMAGED_SHELL("enemy_damaged_shell", "<team_attack> team has damaged the <team_victim>'s Shell !"),
	ENEMY_KILLED_SHELL("enemy_killed_shell", "<team_attack> has destroyed the <team_victim>'s Shell, their monster is now unveiled !"),
	ENEMY_DAMAGED_GUARDIAN("enemy_damaged_monster", "<team_victim>'s Guardian has been damaged by <team_attack> team !"),
	ENEMY_KILLED_GUARDIAN("enemy_killed_monster", "<team_victim>'s Guardian has been killed by <team_attack> team ! They won't respawn anymore."),
	
	PLAYER_RECEIVED_COINS_WINNING("player_received_coins_winning", "You received <amount> coins for winning the game !"),
	PLAYER_RECEIVED_COINS_DESTROYING_SHELL("player_received_coins_destroying_shell", "You received <amount> coins for destroying the enemy's shell !"),
	PLAYER_RECEIVED_COINS_TEAM_DESTROYING_SHELL("player_received_coins_team_destroying_shell", "You received <amount> coins because you team destroyed the enemy's shell !"),
	PLAYER_RECEIVED_COINS_DESTROYING_GUARDIAN("player_received_coins_destroying_guardian", "You received <amount> coins for killing the enemy's guardian !"),
	PLAYER_RECEIVED_COINS_TEAM_DESTROYING_GUARDIAN("player_received_coins_team_destroying_guardian", "You received <amount> coins because you team killed the enemy's guardian !"),
	PLAYER_RECEIVED_COINS_DAMAGING_SHELL("player_received_coins_damaging_shell", "You received <amount> coins for damaging the enemy's shell !"),
	PLAYER_RECEIVED_COINS_TEAM_DAMAGING_SHELL("player_received_coins_team_damaging_shell", "You received <amount> coins because you team damaged the enemy's shell !"),
	PLAYER_RECEIVED_COINS_DAMAGING_GUARDIAN("player_received_coins_damaging_guardian", "You received <amount> coins for damaging the enemy's guardian !"),
	PLAYER_RECEIVED_COINS_TEAM_DAMAGING_GUARDIAN("player_received_coins_team_damaging_guardian", "You received <amount> coins because you team damaged the enemy's guardian !"),
	
	PLAYER_RECEIVED_FAME_WINNING("player_received_coins_winning", "You received <amount> coins for winning the game !"),
	PLAYER_RECEIVED_FAME_DESTROYING_SHELL("player_received_coins_destroying_shell", "You received <amount> coins for destroying the enemy's shell !"),
	PLAYER_RECEIVED_FAME_DAMAGING_SHELL("player_received_coins_damaging_shell", "You received <amount> coins for damaging the enemy's shell !"),
	PLAYER_RECEIVED_FAME_DESTROYING_GUARDIAN("player_received_coins_destroying_guardian", "You received <amount> coins for killing the enemy's guardian !"),
	PLAYER_RECEIVED_FAME_DAMAGING_GUARDIAN("player_received_coins_damaging_guardian", "You received <amount> coins for damaging the enemy's guardian !"),
	
	TEAM_HAS_WON("team_has_won", "<winners> team is the last one standing, this team is now the best amoung the others !"),
	
	PHASE_ZERO_IS_OVER("phase_zero_is_over", "Phase zero is now over, you can destroy enemys monters' shells !");
 
    private String path;
    private String def;
    //private static YamlConfiguration LANG;

    Lang(String path, String start) {
        this.path = path;
        this.def = start;
    }
 
    /*
    
    public static void setFile(YamlConfiguration config) {
        LANG = config;
    }
    
    */
 
    @Override
    public String toString() {
        //return ChatColor.translateAlternateColorCodes('&', LANG.getString(this.path, def));
    	return this.def;
    }
 
    public String getDefault() {
        return this.def;
    }
 
    public String getPath() {
        return this.path;
    }
}