package csc2a.designpatterns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import csc2a.model.Banana;
import csc2a.model.Monkey;
import csc2a.model.Player;
import csc2a.model.Projectile;
import csc2a.model.Rock;
import csc2a.model.Tree;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * ConcreteVisitor class Used to visit each GameObject and render them onto the
 * GameCanvas
 * 
 * @author Kananelo Khotle (217080976)
 *
 */
public class RenderGameObjectVisitor implements iRenderVisitor {

  // Attributes
  GraphicsContext gc = null;
  private Image player_image = null;
  private Image monkey_image = null;
  private Image rock_image = null;
  private Image tree_image = null;
  // private Image bomb_image = null;

  public RenderGameObjectVisitor() {
    try {
      player_image = new Image(new FileInputStream("resources/train.png"));
      monkey_image = new Image(new FileInputStream("resources/monkey.png"));
      rock_image = new Image(new FileInputStream("resources/rock.png"));
      tree_image = new Image(new FileInputStream("resources/tree.png"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * Mutator for the GraphicsContext from the GameCanvas Used to set gc so the
   * Visitor can draw things on the Canvas
   * 
   * @param gc the GraphicsContext from the GameCanvas
   */
  public void setGraphicsContext(GraphicsContext gc) {
    this.gc = gc;
  }

  public void render(Player player) {
    gc.drawImage(player_image, player.getXLocation() - player.getWidth() / 2,
        player.getYLocation() - player.getHeight() / 2, player.getWidth(), player.getHeight());
  }

  @Override
  public void render(Monkey monkey) {

    gc.drawImage(monkey_image, monkey.getXLocation() - monkey.getWidth() / 2,
        monkey.getYLocation() - monkey.getHeight() / 2, monkey.getWidth(), monkey.getHeight());
  }

  @Override
  public void render(Banana banana) {
    gc.setFill(Color.BLACK);
    gc.strokeOval(banana.getXLocation(), banana.getYLocation(), 20, 20);
    gc.setFill(Color.RED);
    gc.fillOval(banana.getXLocation(), banana.getYLocation(), 20, 20);
  }

  @Override
  public void render(Projectile projectile) {
    gc.setFill(Color.DIMGRAY);
    gc.fillOval(projectile.getXLocation(), projectile.getYLocation(), 10, 10);
  }

  @Override
  public void render(Tree tree) {
    gc.drawImage(tree_image, tree.getXLocation() - tree.getWidth(), tree.getYLocation() - tree.getHeight(),
        tree.getWidth(), tree.getHeight());
  }

  @Override
  public void render(Rock rock) {
    gc.drawImage(rock_image, rock.getXLocation(), rock.getYLocation(), rock.getWidth(), rock.getHeight());
  }
}
