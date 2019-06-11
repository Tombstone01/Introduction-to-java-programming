// Author: Kananelo Maxwell
// Student#: 217080976
// Practical: 01

class NameConverter {
  
  private String heroName;
  private String secretName;

  String[] text = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
  "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
  "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", " "};

  String[] scram = {"D", "U", "P", "1", "Q", "C", "I", "O", "5",
  "7", "Z", "6", "V", "8", "W", "H", "T", "L",
  "E", "0", "M", "J", "B", "4", "G", "9", "X",
  "N", "3", " ", "2", "R", "Y", "K",
  "S", "F", "A"};
  
  public NameConverter() {
    this.secretName = "";
    this.heroName = "";
  } 

  public String scramble(String name) {

    this.heroName = toUpper(name);

    for (int i = 0; i < this.heroName.length(); i++) {
      
      int index = -1;
      char temp = this.heroName.charAt(i);
      
      for (int j = 0; j < 37; j++) {
        if (this.text[j].charAt(0) == temp) {
          index = j;
        }

        if (index != -1) {
          this.secretName += scram[index];
        }
      }
    }

    return this.secretName;    
  }

  public String unscramble(String secretName) {
    this.secretName = this.toUpper(secretName);

    for (int i = 0; i < this.secretName.length(); i++) {
      int index = -1;
      char temp = this.secretName.charAt(i);

      for (int j = 0; j < 37; j++) {
        if (scram[j].charAt(0) == temp) {
          index = j;
        }

        if (index != -1) {
          this.heroName+=text[index];
        }
      }
    }

    return this.heroName;
  }

  String getHeroName() {
    return this.heroName;
  }

  String getSecretName() {
    return this.secretName;
  }

  public void setHeroName(String heroName) {
    this.heroName = heroName;
  }

  public void setSecretName(String secretName) {
    this.secretName = secretName;
  }

  private String toUpper(String message) {
    return message.toUpperCase();
  }
}