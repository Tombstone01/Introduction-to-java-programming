package csc2a.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import csc2a.model.Banana;
import csc2a.model.GameObject;
import csc2a.model.Monkey;
import csc2a.model.Player;
import csc2a.model.Rock;
import csc2a.model.Tree;
import csc2a.ui.GameCanvas;

/**
 * 
 * Class to handle all interactions with files
 * 
 * @author Kananelo Khotle (217080976)
 *
 */
public class GameFileHandler {

  public static int NUM_ROCKS = 300;
  public static int NUM_MONKEYS = 25;
  public static int NUM_TREES = 200;
  public static int NUM_BANANAS = 10;
	
	public static ArrayList<GameObject> readTextFile(File file, GameCanvas canvas) {
    
    ArrayList<GameObject> items = new ArrayList<>();

    Scanner scanner = null;

    try {
      scanner = new Scanner(file);
    } catch (FileNotFoundException e) {
      e.getStackTrace();
    }

    while (scanner.hasNext()) {
      StringTokenizer tokens = new StringTokenizer(scanner.nextLine(), " ");
      
      // read variables values from the text file.
      NUM_BANANAS = Integer.parseInt(tokens.nextToken());
      NUM_MONKEYS = Integer.parseInt(tokens.nextToken());
      NUM_ROCKS = Integer.parseInt(tokens.nextToken());
      NUM_TREES = Integer.parseInt(tokens.nextToken());
    }

    // this is the initial location of the player.
    double player_x = canvas.getWidth() / 2;
    double player_y = canvas.getHeight() / 2;

    // create the ob
    Player player = new Player(player_x, player_y, 70, 70);

    // this for loop creates rock objects.
    for (int i = 0; i < NUM_ROCKS; i++) {

      double x = Math.random() * canvas.getWidth();
      double y = Math.random() * canvas.getHeight();

      double w = Math.random() * 30;

      Rock rock = new Rock(x, y, w, w);
      items.add(rock);
    }


    // this for loop create monkeys.
    for (int i = 0; i < NUM_MONKEYS; i++) {

      double x = Math.random() * canvas.getWidth();
      double y = Math.random() * canvas.getHeight();
    
      Monkey monkey = new Monkey(Math.floor(x), Math.floor(y), 50, 50);
      items.add(monkey);
    }

    // this for loop creates trees.
    for (int i = 0; i < NUM_TREES; i++) {
      double x = Math.random() * canvas.getWidth();
      double y = Math.random() * canvas.getHeight();

      double dim = Math.random() * 100;

      Tree tree = new Tree(x, y, dim, dim);
      items.add(tree);
    }

    // this loop creates bananas.
    for (int i = 0; i < NUM_BANANAS; i++) {
      double x = Math.random() * canvas.getWidth();
      double y = Math.random() * canvas.getHeight();

      Banana banana = new Banana(x, y, 30, 30);
      items.add(banana);
    }

    items.add(player);
    
		return items;
	}

  public static void writeBinaryFile(ArrayList<GameObject> items) {

    ObjectOutputStream objectOutputStream = null;
    try {
      objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("data/saved_game.bat")));
      objectOutputStream.writeObject(items);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        objectOutputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static ArrayList<GameObject> readBinaryFile() {
    ArrayList<GameObject> items = new ArrayList<>();

    ObjectInputStream objectInputStream = null;

    try {
      objectInputStream = new ObjectInputStream(new FileInputStream(new File("data/saved_game.bat"))); 
      
      Object object = objectInputStream.readObject();
      items = (ArrayList<GameObject>)object;
    } catch (Exception e) {
      e.getStackTrace();
    } finally {
      try {
        objectInputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return items;
  }
}
