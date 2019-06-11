import csc2a.ham.Team;

public class Main {

	/* Information about both teams */
	private static final int num_members_per_team = 2;
	private static final String team_1_id = "X1_12";
	private static final String team_2_id = "X2_12";
	private static final String team_1_name = "Happy kings";
	private static final String team_2_name = "Galaxy 2A";
	private static final String team_1_slogan = "Hurray!!!!";
	private static final String team_2_slogan = "Win all day, everyday!";
	private static final String team_1_leader = "Skywalker";
	private static final String team_2_leader = "Tebza";
	private static final String[] team_1_members = {"Graid", "Davis"};
	private static final String[] team_2_members = {"Tshepise", "Jaba"};

	public static void main(String[] args) {

		// Create objects for both teams.
		Team team_1 = new Team(team_1_id, team_1_name, team_1_slogan, num_members_per_team, team_1_leader, team_1_members);
		Team team_2 = new Team(team_2_id, team_2_name, team_2_slogan, num_members_per_team, team_2_leader, team_2_members);

		// Display team information.
		System.out.println("\n --- Team 1 information --- ");

		System.out.println("Team ID: " + team_1.getID());
		System.out.println("Team name: " + team_1.getName());
		System.out.println("Team slogan: " + team_1.getSlogan());
		System.out.println("Team leader: " + team_1.getLeader());
		System.out.println("Team members: " + team_1.getMembers());

		// Display team information.
		System.out.println("\n --- Team 2 information --- ");

		System.out.println("Team ID: " + team_2.getID());
		System.out.println("Team name: " + team_2.getName());
		System.out.println("Team slogan: " + team_2.getSlogan());
		System.out.println("Team leader: " + team_2.getLeader());
		System.out.println("Team members: " + team_1.getMembers());
    }
}