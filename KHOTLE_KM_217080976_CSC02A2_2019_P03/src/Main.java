import csc2a.ham.TeamFileHandler;
import csc2a.ham.Team;

/** @author Kananelo Khotle
 *  @version 0.0.1
 */
public class Main {

	private static final String filename_1 = "TeamA Clean.txt";
	private static final String filename_2 = "TeamB Clean.txt";
	private static final String filename_3 = "TeamB Intercepted.txt";;

	public static void main(String[] args) {

		// An instance of TeamFileHandler class.
		TeamFileHandler fileHandler = new TeamFileHandler();

        System.out.println("\n # Reading transmitted data.\n");

		Team team_1 = fileHandler.readTeam(filename_1);
		Team team_2 = fileHandler.readTeam(filename_2);
		Team team_3 = fileHandler.readTeam(filename_3);

		System.out.println("\n # Displaying transmitted data #");

		// // Display team information.
		System.out.println("\n ### Team 1 data ###");

		System.out.println(" ## Team ID: " + team_1.getID());
		System.out.println(" ## Team name: " + team_1.getName());
		System.out.println(" ## Team slogan: " + team_1.getSlogan());
		System.out.println(" ## Team leader: " + team_1.getLeader());
		System.out.println(" ## Team members: " + team_1.getMembers());

		// // Display team information.
		System.out.println("\n ### Team 2 data ###");

		System.out.println(" ## Team ID: " + team_2.getID());
		System.out.println(" ## Team name: " + team_2.getName());
		System.out.println(" ## Team slogan: " + team_2.getSlogan());
		System.out.println(" ## Team leader: " + team_2.getLeader());
		System.out.println(" ## Team members: " + team_2.getMembers());

				// // Display team information.
		System.out.println("\n ### Team 3 data ###");

		System.out.println(" ## Team ID: " + team_3.getID());
		System.out.println(" ## Team name: " + team_3.getName());
		System.out.println(" ## Team slogan: " + team_3.getSlogan());
		System.out.println(" ## Team leader: " + team_3.getLeader());
		System.out.println(" ## Team members: " + team_3.getMembers());
    }
}