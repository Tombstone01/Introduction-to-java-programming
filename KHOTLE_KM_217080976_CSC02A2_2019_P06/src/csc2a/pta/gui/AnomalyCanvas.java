package csc2a.pta.gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import csc2a.pta.model.Anomaly;

import java.util.ArrayList;

/** This class draws items, both scanned and unscanned to the canvas
 * 
 *  @author Kananelo Khotle
 * 
 */
public class AnomalyCanvas extends Canvas
{
	private ArrayList<Anomaly> items;

	private ProbeGraphicsVisitor visitor;

	/** Default constructor
	 */
	public AnomalyCanvas()
	{
		super(800, 480);
	
		items = null;
		visitor = new ProbeGraphicsVisitor();
	}

	/** This method actually draws to 
	 *  the canvas.
	 */
	public void redrawCanvas() {
		repaintCanvas();
	}

	/** This methods sets the items
	 * 
	 * 	@param items an array of items.
	 */
	public void setItems(ArrayList<Anomaly> items)
	{
		this.items = items;

		// re-render contents of canvas.
		redrawCanvas();
	}

	/** This function draws anomalies to the canvas 
	 */
	public void repaintCanvas()
	{
		/* TODO: get GraphicsContext */
		GraphicsContext gc = getGraphicsContext2D();

		/* TODO: set Visitor GraphicsContext */
		visitor.setGraphicsContext(gc);

		/* TODO: loop through EACH item */
		for (int r = 0; r < this.items.size(); r++) {
			this.items.get(r).accept(visitor);
		}
	}
}
