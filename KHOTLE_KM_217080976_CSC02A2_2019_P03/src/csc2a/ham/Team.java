package csc2a.ham;

/** @author Kananelo Khotle
 *  @version 0.0.1
 */
public class Team {
	
	private String ID;
    private String name;
	private String slogan;
	private Hero leader;
	private Hero[] members;
	private int num_members;
	int counter;
	
	/** Constructor
	**/
	public Team(String ID, String name, String slogan, int num_members) {
		
		// Create instance variables.
		this.ID = ID;
		this.name = name;
		this.slogan = slogan;

		this.num_members = num_members;

		this.members = new Hero[this.num_members];
		this.counter = 0;
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

	public void setLeader(Hero leader) {
		this.leader = leader;
	}

	public String getLeader() {
		return this.leader.getName();
	}

	public void addMember(Hero member) {
		this.members[counter] = member;

		counter++;
	}

	// Return a list of team members.
	public String getMembers() {

		String members = " ";

		for (int i = 0; i < this.members.length; i++) {
			members += this.members[i].getName() + " - ";
		}

		return members;
	}
}