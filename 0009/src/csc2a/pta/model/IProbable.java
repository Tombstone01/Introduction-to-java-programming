package csc2a.pta.model;

import csc2a.pta.model.IProbeVisitor;

/* TODO: JavaDoc */
public interface IProbable
{
	/* TODO: JavaDoc */
	/* TODO: accept method */

	/** This method accepts something
	 *  @param visitor the person that
	 *  actually visits.
	 */
	public void accept(IProbeVisitor visitor);
}
