package csc2a.ham.Team;
import java.util.Scanner;

class Main {
	
	// These variable must not change.
	static final int num_teams = 2;
	static final int num_members = 2;
	
    public static void main(String[] args) {
		
		// Create scanner object.
		Scanner scanner = new Scanner(System.in);
		
		// An array of teams.
		Team[] team = new Team[num_teams];
		
		// loop through all teams.
		for (int i = 0; i < num_teams; i++) {
			
			
			// Prompt user for informations.
			System.out.println("Please enter ID for team " + (i+1) + ":");
			String id = scanner.nextLine();
			
			// Prompt user for information.
			System.out.println("Please enter the name of team " + (i+1) + ":");
			String name = scanner.nextLine();
			
			// Prompt user for information.
			System.out.println("Please enter the slogan for team " +(i+1) + ":");
			String slogan = scanner.nextLine();
			
			// Create an instance of team class.
			team[i] = new Team(id, name, slogan, num_members);
		}
		
		// Loop through teams.
		for (int i = 0; i < num_teams; i++) {
			
			// print out information about each team.
			System.out.println("\n --- TEAM " + (i+1) + " INFO --- \n");
			
			System.out.println(" + Team ID: " + team[i].getID());
			System.out.println(" + Team name: " + team[i].getName());
			System.out.println(" + Team slogan: " + team[i].getSlogan());
			
			System.out.println(" ---- TEAM " + (i+1) + " MEMBERS  ----- " );
			System.out.println(team[i].getTeamInfo());
		}
    }
}