package csc2a.ham.models;

import csc2a.ham.models.Hero;

public class VerifiedHero extends Hero {
  public VerifiedHero(String ID, String name, String strength, String weakness, int renown) {
    super(name, ID, strength, weakness, renown);
  }

  public void issueOrder(String order, int priority) {
    System.out.println(this.name);
    System.out.println(this.ID);
    System.out.println(order);
    System.out.println(priorityLevel(priority));
    System.out.println("verified");
  }
}