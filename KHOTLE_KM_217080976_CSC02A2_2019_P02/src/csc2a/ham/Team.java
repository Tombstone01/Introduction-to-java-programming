package csc2a.ham;

public class Team {
	
	private String ID;
    private String name;
	private String slogan;
	private Hero leader;
	private Hero[] members;
	private int num_members;
	
	/** Constructor
	**/
	public Team(String ID, String name, String slogan, int num_members, String leader, String[] members) {
		
		// Create instance variables.
		this.ID = ID;
		this.name = name;
		this.slogan = slogan;
		
		// Set the number of members.
		this.num_members = num_members;
		
		// Create a leader.
		this.leader = new Hero(this.ID + 'X', leader);
		
		// Initialize the members array.
		this.members = new Hero[this.num_members];
		
		// Create members for the team.
		for (int i = 0; i < this.num_members; i++) {
			
			String hero_name = members[i];
			
			// Create an instance of a hero.
			this.members[i] = new Hero(this.ID + i, hero_name);
		}	
	}
	
	// Set ID of team.
	public void setID(String ID) {
		this.ID = ID;
	}
	
	// Set team name.
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	
	// Get team name.
	public String getName() {
		return this.name;
	}
	
	// Get team ID.
	public String getID() {
		return this.ID;
	}
	
	// Returns the slogan of a team.
	public String getSlogan() {
		return this.slogan;
	}

	// Return team leaders name.
	public String getLeader() {
		return this.leader.getName();
	}

	// Return a list of team members.
	public String getMembers() {
		return "{" + this.members[0].getName() + ", " + this.members[1].getName() + "}";
	}
}