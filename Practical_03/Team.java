import java.util.Scanner;

class Team {
    private String ID;
    private String name;
	private String slogan;
	private Hero leader;
	private Hero[] members;
	private int num_members;
	
	/** Constructor
	**/
	public Team(String ID, String name, String slogan, int num_members) {
		
		// Create a scanner class.
		Scanner scanner = new Scanner(System.in);
		
		// Create instance variables.
		this.ID = ID;
		this.name = name;
		this.slogan = slogan;
		
		// Set the number of members.
		this.num_members = num_members;
		
		// Prompt the user for informations
		System.out.println("Please enter team leaders name: ");
		String team_leader = scanner.nextLine();
		
		// Create a leader.
		leader = new Hero(this.ID + 'X', team_leader);
		
		// Initialize the members array.
		members = new Hero[this.num_members];
		
		// Create members for the team.
		for (int i = 0; i < this.num_members; i++) {
			
			System.out.println("Please enter hero " + (i+1) +" name: ");
			String temp_hero_name = scanner.nextLine();
			
			// Create an instance of a hero.
			members[i] = new Hero(this.ID + (char)i, temp_hero_name);
		}	
	}
	
	/** Set ID of team.
	**/
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getID() {
		return this.ID;
	}
	
	public String getSlogan() {
		return this.slogan;
	}
	
	public String getTeamInfo() {
		
		String temp = " + Leader ID: " + this.leader.getID() + '\n';
		temp += " + Leader name: " + this.leader.getName() + '\n';
		
		for (int i = 0; i < this.num_members; i++) {
			temp += " + Hero ID: " + this.members[i].getID() + '\n';
			temp += " + Hero name: " + this.members[i].getName() + '\n';
		}
		
		return temp;
	}
}