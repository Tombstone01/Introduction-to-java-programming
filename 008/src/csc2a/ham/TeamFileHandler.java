package csc2a.ham;

import java.io.FileNotFoundException;
import java.io.File;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;

import csc2a.ham.models.TeamMissionEntity;
import csc2a.ham.models.MissionEntity;
import csc2a.ham.models.Hero;
import csc2a.ham.models.UnverifiedHero;
import csc2a.ham.models.VerifiedHero;

/** This class read binary file and text file
 *  then generates team information from
 *  read information.
 * 
 * @author Kananelo Khotle
 * @version 0.0.1
 */
public class TeamFileHandler {

  LinkedList<TeamMissionEntity> mEntities;
  Team team;

  public TeamFileHandler() {
    mEntities = null;
    team = null;
  }

  /**
   * Reads binary file, retrives team ID then read text file using team ID.
   *
   * @param file binary file to be opened.
   */
  public LinkedList<TeamMissionEntity> readMission(File file) {

    if (!file.exists()) {
      System.out.println("Sorry, the file does not exist!");
    }

    DataInputStream dataIn = null;

    try {

      FileInputStream inputStream = new FileInputStream(file);
      BufferedInputStream bufferedInput = new BufferedInputStream(inputStream);

      dataIn = new DataInputStream(bufferedInput);

      // reads file from binary file.
      String teamID = dataIn.readUTF();

      // team object from readTeam method.
      Team team = this.readTeam(new File("/data/" + teamID + ".txt"));
      
      // create TeamMissionEntities here.
      mEntities = new LinkedList<>();

      // use team object to determine how many teams
      // are in the binary file.
      for (int i = 0; i < team.getMembers().size(); i++) {
        
        String heroID = dataIn.readUTF();
        int heroRow = dataIn.readInt();
        int heroCol = dataIn.readInt();

        team.getMembers().get(i).setId(heroID);
        

        // creat MissionEntity instance with attributes read from the binary file.
        TeamMissionEntity mEntity = new TeamMissionEntity(heroRow, heroCol, team.getMembers().get(i));
        
        // adds mission entity to other mission entities.
        mEntities.add(mEntity);
      }
    } catch (IOException ex) {
      System.out.println("Error here.");
    }

    return mEntities;
  }

  /**
   * Reads information from text file about a team.
   * 
   * @param filename of the file to be read
   * @return Team object.
   */
  public Team readTeam(File file) {

    Team team = null;

    Scanner scanner = null;

    try {

      // Read file using scanner object.
      int intIncr = 0;
      scanner = new Scanner(file);

      // Read each line in the file.
      while (scanner.hasNext()) {
        StringTokenizer tokens = new StringTokenizer(scanner.nextLine(), "\t");

        if (intIncr == 0) {
          String teamID = tokens.nextToken();
          String teamName = tokens.nextToken();
          String slogan = tokens.nextToken();

          // create a team instance using provided information.
          team = new Team(teamID, teamName, slogan);

        } else {

          String heroID = tokens.nextToken();
          String heroName = tokens.nextToken();
          String attrib = tokens.nextToken();
          String heroStrength = attrib.substring(1, attrib.indexOf("|")); // attrib[0];
          String heroWeakness = attrib.substring(attrib.indexOf("|") + 1, attrib.length() - 1); // attrib[1];
          int reown = Integer.parseInt(tokens.nextToken());
          int verification = Integer.parseInt((tokens.nextToken()));

          Hero hero;

          // if verification is even
          if (Hero.verify(verification)) {
            hero = new VerifiedHero(heroID, heroName, heroWeakness, heroStrength, reown);
          } else {
            hero = new UnverifiedHero(heroID, heroName, heroWeakness, heroStrength, reown);
          }

          team.addMember(hero);
        }

        intIncr++;
      }
    } catch (FileNotFoundException e) {
      System.out.println(e);
    } finally {
      scanner.close();
    }

    return team;
  }

  /**
   * @param File to be read.
   * @return the team object.
   */
  private LinkedList<Hero> readFile(File file) {
    return team.getMembers();
  }
}