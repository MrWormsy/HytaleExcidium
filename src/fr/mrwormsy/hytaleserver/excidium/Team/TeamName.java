package fr.mrwormsy.hytaleserver.excidium.Team;

public enum TeamName {

	BLUE(0, "Blue Team", ""),
	RED(1, "Red Team", ""),
	YELLOW(2, "Yelow Team", ""),
	PURPLE(3, "Purple Team", ""),
	GREEN(4, "Green Team", ""),
	ORANGE(5, "Orange Team", ""),
	BLACK(6, "Black Team", ""),
	WHITE(7, "White Team", "");
	
	private int id;
	private String name;
	private String color;
	
	private TeamName(int id, String name, String color) {
		this.id = id;
		this.name = name;
		this.color = color;
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}
	
	public static TeamName getTeamNameFromId(int id) {
		for (TeamName teamName : TeamName.values()) {
			
			if (teamName.getId() == id) {
				return teamName;
			}
		}
		
		return TeamName.BLUE;
	}
}
