package csc2a.hamm;

enum E_HERO_ATTRIBUTE {
	INTELLIGENCE,
	STRENGTH,
	MONEY,
	EXPERIENCE,
	TENACITY,
	INITIATIVE
}

/** @author Kananelo Khotle
 *  @version 0.0.1
 */
class Hero {
    
	/** Intance variables.
	**/
	private String ID;
	private String name;
	private E_HERO_ATTRIBUTE strength;
	private E_HERO_ATTRIBUTE weakness;
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
	public void setStrength(String strength) {
		if (strength.equalsIgnoreCase("intelligence")) {
			this.strength = E_HERO_ATTRIBUTE.INTELLIGENCE;
		} else if (strength.equalsIgnoreCase("strength")) {
			this.strength = E_HERO_ATTRIBUTE.STRENGTH;
		} else if (strength.equalsIgnoreCase("money")) {
			this.strength = E_HERO_ATTRIBUTE.MONEY;
		} else if (strength.equalsIgnoreCase("experience")) {
			this.strength = E_HERO_ATTRIBUTE.EXPERIENCE;
		} else if (strength.equalsIgnoreCase("tenacity")) {
			this.strength = E_HERO_ATTRIBUTE.TENACITY;
		} else if (strength.equalsIgnoreCase("initiative")) {
			this.strength = E_HERO_ATTRIBUTE.INITIATIVE;
		} else {
			System.out.println(" # Transmission error: Hero " + this.ID + " contains invalid strength value.");
		}
	}

	// Sets heros weakness
	public void setWeakness(String weakness) {
		if (weakness.equalsIgnoreCase("intelligence")) {
			this.strength = E_HERO_ATTRIBUTE.INTELLIGENCE;
		} else if (weakness.equalsIgnoreCase("strength")) {
			this.strength = E_HERO_ATTRIBUTE.STRENGTH;
		} else if (weakness.equalsIgnoreCase("money")) {
			this.strength = E_HERO_ATTRIBUTE.MONEY;
		} else if (weakness.equalsIgnoreCase("experience")) {
			this.strength = E_HERO_ATTRIBUTE.EXPERIENCE;
		} else if (weakness.equalsIgnoreCase("tenacity")) {
			this.strength = E_HERO_ATTRIBUTE.TENACITY;
		} else if (weakness.equalsIgnoreCase("initiative")) {
			this.strength = E_HERO_ATTRIBUTE.INITIATIVE;
		} else {
			System.out.println(" # Transmission error: Hero " + this.ID + " contains invalid weakness value.");
		}
	}

	// set heros renown.
	public void setRenown(String renown) {
		if (renown.equalsIgnoreCase("intelligence")) {
			this.strength = E_HERO_ATTRIBUTE.INTELLIGENCE;
		} else if (renown.equalsIgnoreCase("strength")) {
			this.strength = E_HERO_ATTRIBUTE.STRENGTH;
		} else if (renown.equalsIgnoreCase("money")) {
			this.strength = E_HERO_ATTRIBUTE.MONEY;
		} else if (renown.equalsIgnoreCase("experience")) {
			this.strength = E_HERO_ATTRIBUTE.EXPERIENCE;
		} else if (renown.equalsIgnoreCase("tenacity")) {
			this.strength = E_HERO_ATTRIBUTE.TENACITY;
		} else if (renown.equalsIgnoreCase("initiative")) {
			this.strength = E_HERO_ATTRIBUTE.INITIATIVE;
		} else {
			System.out.println(" # Transmission error: Hero " + this.ID + " contains invalid renown value.");
		}
	}
	
	// Returns heros strength.
	public E_HERO_ATTRIBUTE getStrength() {
		return this.strength;
	}

	// Returns heros weakness
	public E_HERO_ATTRIBUTE getWeakness() {
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