package csc2a.pta.model;

import csc2a.pta.model.UnscannedAnomaly;
import csc2a.pta.model.ScannedAnomaly;

/* TODO: JavaDoc */
public interface IProbeVisitor
{
	/* TODO: JavaDoc */
	/* TODO: visit (probe) methods */

	/** Who knows what this method does.
	 * 
	 * @param scannedAnomaly some other variables.
	 * 
	 */
	public void probe(ScannedAnomaly scannedAnomaly);

	/** Who knows what this method does.
	 * 
	 * @param unscannedAnomaly some other variable.
	 * 
	 */
	public void probe(UnscannedAnomaly unscannedAnomaly);
}
