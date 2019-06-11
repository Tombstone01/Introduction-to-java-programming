package csc2a.ham.models;

import csc2a.ham.models.MissionEntity;
import csc2a.ham.models.Hero;

public class TeamMissionEntity extends MissionEntity {

	Hero hero;

  public TeamMissionEntity(int row, int col, Hero hero) {
      super(row, col);

      this.hero = hero;
  }

  public Hero getHero() {
    return this.hero;
  }

  public int getRow() {
    return this.row;
  }

  public int getCol() {
    return this.col;
  }
}