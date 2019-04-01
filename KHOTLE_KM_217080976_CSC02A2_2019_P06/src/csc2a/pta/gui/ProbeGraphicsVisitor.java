package csc2a.pta.gui;

/* TODO: Imports */
import csc2a.pta.model.IProbeVisitor;
import csc2a.pta.model.EAnomalyType;
import csc2a.pta.model.UnscannedAnomaly;
import csc2a.pta.model.ScannedAnomaly;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/* TODO: JavaDoc */
public class ProbeGraphicsVisitor implements IProbeVisitor {

	private GraphicsContext	gc;
	public static final int	DEFAULT_SIZE	= 100;

	/* TODO: JavaDoc */
	public GraphicsContext getGraphicsContext()
	{
		return gc;
	}

	/* TODO: JavaDoc */
	public void setGraphicsContext(GraphicsContext gc)
	{
		this.gc = gc;
	}
	
	/* TODO: JavaDoc */
	@Override
	public void probe(UnscannedAnomaly unscanned)
	{
		/* TODO: Get location to start drawing */
		Point2D location = unscanned.getLocation();

		/* TODO: Draw with correct colour */
		gc.setFill(getColor(unscanned.getType()));

		/* TODO: Draw with correct shape(s) */
		gc.fillOval(location.getX(), location.getY(), 20, 20);
		/* TODO: Draw textual information */

		// gc.strokeText(unscanned.toString(), location.getX(), location.getY());
	}

	/** This method draws an anomaly to the
   *  canvas
   * 
   *  @param scanned anomaly type
   */
	@Override
	public void probe(ScannedAnomaly scanned)
	{		

		/* TODO: Get location to start drawing */
		Point2D location = scanned.getLocation();

		/* TODO: Draw with correct colour */
		gc.setFill(getColor(scanned.getType()));

		/* TODO: Draw with correct shape(s) */
		gc.fillRect(location.getX(), location.getY(), 20, 20);

		/* TODO: Draw textual information */
		gc.strokeText(scanned.toString(), location.getX(), location.getY());
	}

  /** This method takes type as an argument
   *  then return color.
   * 
   *  @param type anomaly type.
   * 
   */
	private Color getColor(EAnomalyType type) {

		Color color = Color.BLACK;

		if (type == EAnomalyType.GEOLOGICAL) {
			color =  Color.GREEN;
		} else if (type == EAnomalyType.GRAVITATIONAL) {
			color = Color.YELLOW;
		} else if (type == EAnomalyType.SPATIAL) {
		  color = Color.CYAN;
		} else if (type == EAnomalyType.TEMPORAL) {
      color = Color.MAGENTA;
		}
		
		return color;
	}
}
