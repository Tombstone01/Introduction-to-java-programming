package csc2a.ham;

import java.util.LinkedList;

import csc2a.ham.models.Hero;
import csc2a.ham.models.MissionEntity;
import csc2a.ham.models.TeamMissionEntity;

/**
 * @author Kananelo Khotle
 * @version 0.0.1
 */
class Team {

  private String ID;
  private String name;
  private String slogan;

  private Hero leader;
  private LinkedList<Hero> members;

  /**
   * Constructor
   **/
  public Team(String ID, String name, String slogan) {

    this.ID = ID;
    this.name = name;
    this.slogan = slogan;

    members = new LinkedList<>();
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

  public Hero getLeader() {
    return this.leader;
  }

  /**
   * Add member to the members arrays.
   * 
   * @param member of the team.
   */
  public void addMember(Hero hero) {
    this.members.add(hero);
  }

  // Returns the number of members in
  // the team.
  public int getNumMembers() {
    return this.members.size();
  }

  // Return a list of team members.
  public LinkedList<Hero> getMembers() {

    // String[] members = new String[this.num_members];

    // for (int i = 0; i < this.num_members; i++) {
    // members[i] = this.members[i].getName();
    // }

    return this.members;
  }
}