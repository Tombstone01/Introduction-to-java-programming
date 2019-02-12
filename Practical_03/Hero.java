
class Hero {
    
	/** Intance variables.
	**/
	private String ID;
	private String name;
	private String strength;
	private String weakness;
	private int renown;
	
	// Constructor.
	public Hero(String ID, String name) {
		this.ID = ID;
		this.name = ID;
	}
	
	// Set ID of the hero.
	public void setId(String ID) {
		this.ID = ID;
	}
	
	// Sets the name of hero.
	public void setName(String name) {
		this.name = name;
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