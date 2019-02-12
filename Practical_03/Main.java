import java.util.Scanner;

class Main {
    public static void main(String[] args) {
	
		int num_teams = 2;
		int num_members = 2;
		
		Team[] team = new Team[num_teams];
		
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < num_teams; i++) {
			
			System.out.println("Please enter ID for team " + (i+1) + ":");
			String id = scanner.nextLine();
			
			System.out.println("Please enter the name of team " + (i+1) + ":");
			String name = scanner.nextLine();
			
			System.out.println("Please enter the slogan for team " +(i+1) + ":");
			String slogan = scanner.nextLine();
			
			team[i] = new Team(id, name, slogan, num_members);
		}
		
		for (int i = 0; i < num_teams; i++) {
			
			System.out.println("\n --- TEAM " + (i+1) + " INFO --- \n");
			
			System.out.println(" + Team ID: " + team[i].getID());
			System.out.println(" + Team name: " + team[i].getName());
			System.out.println(" + Team slogan: " + team[i].getSlogan());
			
			System.out.println(" ---- TEAM " + (i+1) + MEMBERS  ----- " );
			System.out.println(team[i].getTeamInfo());
		}
    }
}