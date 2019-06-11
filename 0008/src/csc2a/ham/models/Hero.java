package csc2a.ham.models;

import csc2a.ham.models.iOrderable;

import javafx.scene.paint.Color;

/**
 * @author Kananelo Khotle
 * @version 0.0.1
 */
public abstract class Hero implements iOrderable {

  /**
   * Intance variables.
   **/
  protected String ID;
  protected String name;
  protected E_HERO_ATTRIBUTE strength;
  protected E_HERO_ATTRIBUTE weakness;
  protected int renown;

  public enum E_HERO_ATTRIBUTE {
    INTELLIGENCE, STRENGTH, MONEY, EXPERIENCE, TENACITY, INITIATIVE
  }

  // Constructor.
  public Hero(String ID, String name, String strength, String weakness, int renown) {
    this.ID = ID;
    this.name = name;

    this.strength = heroAttribute(strength);
    this.weakness = heroAttribute(weakness);
    this.renown = renown;
  }

  // Sets the name of hero.
  public void setName(String name) {
    this.name = name;
  }

  // Set ID of the hero.
  public void setId(String ID) {
    this.ID = ID;
  }

  // Sets heros strength.
  public void setStrength(E_HERO_ATTRIBUTE strength) {
    this.strength = strength;
  }

  // Sets heros weakness
  public void setWeakness(E_HERO_ATTRIBUTE weakness) {
    this.weakness = weakness;
  }

  // set heros renown.
  public void setRenown(int renown) {
    this.renown = renown;
  }

  // Returns heros strength.
  public Color getStrength() {

    Color color = null;

    if (this.strength == E_HERO_ATTRIBUTE.INTELLIGENCE) {
      color = Color.web("#a316b7");
    } else if (this.strength == E_HERO_ATTRIBUTE.STRENGTH) {
      color = Color.web("#1d37ad");
    } else if (this.strength == E_HERO_ATTRIBUTE.MONEY) {
      color = Color.web("#08adad");
    } else if (this.strength == E_HERO_ATTRIBUTE.EXPERIENCE) {
      color = Color.web("#0dbc24");
    } else if (this.strength == E_HERO_ATTRIBUTE.TENACITY) {
      color = Color.web("#dbadad");
    } else if (this.strength == E_HERO_ATTRIBUTE.INITIATIVE) {
      color = Color.web("#dbcead");
    }

    return color;
  }

  public Color getWeakness() {

    Color color = null;

    if (this.strength == E_HERO_ATTRIBUTE.INTELLIGENCE) {
      color = Color.web("#bf9bc4");
    } else if (this.strength == E_HERO_ATTRIBUTE.STRENGTH) {
      color = Color.web("#979fc4");
    } else if (this.strength == E_HERO_ATTRIBUTE.MONEY) {
      color = Color.web("#8db5b5");
    } else if (this.strength == E_HERO_ATTRIBUTE.EXPERIENCE) {
      color = Color.web("#b8d6bc");
    } else if (this.strength == E_HERO_ATTRIBUTE.TENACITY) {
      color = Color.web("#cc1a1a");
    } else if (this.strength == E_HERO_ATTRIBUTE.INITIATIVE) {
      color = Color.web("#d89b04");
    }

    return color;
  }

  // Returns heros renown.
  public int getRenown() {
    return this.renown;
  }

  // Get ID of hero.
  public String getID() {
    return this.ID;
  }

  // Get name of hero.
  public String getName() {
    return this.name;
  }

  /** If verification number is even, return true, else return false.
   * 
   * @param verification
   * @return boolean value.
   */
  public static boolean verify(int verification) {
    return verification % 2 == 0 ? true : false;
  }

  protected String priorityLevel(int priority) {
    if (priority == 1) {
      return "Top";
    } else if (priority == 2 || priority == 3) {
      return "High";
    } else if (priority > 3 || priority <= 6) {
      return "Moderate";
    } else {
      return "Low";
    }
  }

  private E_HERO_ATTRIBUTE heroAttribute(String attribute) {

    E_HERO_ATTRIBUTE attr = null;

    if (attribute.equalsIgnoreCase("intelligence")) {
      attr = E_HERO_ATTRIBUTE.INTELLIGENCE;
    } else if (attribute.equalsIgnoreCase("strength")) {
      attr = E_HERO_ATTRIBUTE.STRENGTH;
    } else if (attribute.equalsIgnoreCase("money")) {
      attr = E_HERO_ATTRIBUTE.MONEY;
    } else if (attribute.equalsIgnoreCase("experience")) {
      attr = E_HERO_ATTRIBUTE.EXPERIENCE;
    } else if (attribute.equalsIgnoreCase("tenacity")) {
      attr = E_HERO_ATTRIBUTE.TENACITY;
    } else if (attribute.equalsIgnoreCase("initiative")) {
      attr = E_HERO_ATTRIBUTE.INITIATIVE;
    }
    return attr;
  }

  // abstract method.
  public abstract void issueOrder(String order, int priority);
}