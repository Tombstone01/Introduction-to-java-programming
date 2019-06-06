package csc2a.ham;

public class Hero {
    
	/** Intance variables.
	**/
	private String ID;
	private String name;
	private int strength;
	private int weakness;
	private int renown;
	
	// Constructor.
	public Hero(String ID, String name) {
		this.ID = ID;
		this.name = name;
	}

	// Sets the name of hero.
	public void setName(String name) {
			this.name = name;
		}
	// Set ID of the hero.
	public void setId(String ID) {
		this.ID = ID;
	}

	// Sets heros strength.
	public void setStrength(int strength) {
		this.strength = strength;
	}

	// Sets heros weakness
	public void setWeakness(int weakness) {
		this.weakness = weakness;
	}

	// set heros renown.
	public void setRenown(int renown) {
		this.renown = renown;
	}
	
	// Returns heros strength.
	public int getStrength() {
		return this.strength;
	}

	// Returns heros weakness
	public int getWeakness() {
		return this.weakness;
	}

	// Returns heros renown.
	public int getRenown() {
		return this.renown;
	}

	// Get ID of hero.
	public String getID() {
		return this.ID;
	}
	
	// Get name of hero.
	public String getName() {
		return this.name;
	}
}