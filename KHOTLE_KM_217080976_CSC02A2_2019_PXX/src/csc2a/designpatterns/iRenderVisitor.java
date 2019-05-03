package csc2a.designpatterns;

import csc2a.model.Banana;
import csc2a.model.Monkey;
import csc2a.model.Player;
import csc2a.model.Projectile;
import csc2a.model.Rock;
import csc2a.model.Tree;

/**
 * 
 * AbstractVisitor interface Used to define all of the render functions for your
 * different GameObjects
 * 
 * @author Kananelo Khotle (217080976)
 *
 */
public interface iRenderVisitor {
	
	public void render(Player player);
	public void render(Monkey monkey);
	public void render(Projectile projectile);
	public void render(Banana banana);
	public void render(Tree tree);
	public void render(Rock rock);
}
