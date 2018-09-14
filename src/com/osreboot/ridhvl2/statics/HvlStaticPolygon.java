package com.osreboot.ridhvl2.statics;

import com.osreboot.ridhvl2.HvlCoord;
import com.osreboot.ridhvl2.painter.HvlPainter;
import com.osreboot.ridhvl2.painter.HvlQuad;

public class HvlStaticPolygon {

	private static HvlQuad globalQuad;


	/**
	 * Produces an instance of {@linkplain com.osreboot.ridhvl2.painter.HvlQuad HvlQuad} with the origin of the
	 * quad (specified by <code>x</code> and <code>y</code>) being the upper-left corner of the quad.
	 * 
	 * <p>
	 * 
	 * This method re-assigns the value of a global variable and returns that variable. This is an optimization 
	 * technique that removes the need for users to store their own HvlQuad instances and allows for rapid
	 * {@linkplain HvlPainter} draw calls with varying HvlPolygon values.
	 * 
	 * <p>
	 * 
	 * NOTE: this references a volatile memory location and should only be used directly inside HvlPainter
	 * draw calls!
	 * 
	 * @param x the x-origin of the quad
	 * @param y the y-origin of the quad
	 * @param xl the x-size of the quad
	 * @param yl the y-size of the quad
	 * @return an instance of HvlQuad with coordinates set to the specified values
	 */
	public static HvlQuad hvlQuad(float x, float y, float xl, float yl){
		if(globalQuad == null){
			globalQuad = new HvlQuad(
					new HvlCoord(x, y), new HvlCoord(x + xl, y), 
					new HvlCoord(x + xl, y + yl), new HvlCoord(x, y + yl)
					);
		}else{
			globalQuad.getVertices()[0].set(x, y);
			globalQuad.getVertices()[1].set(x + xl, y);
			globalQuad.getVertices()[2].set(x + xl, y + yl);
			globalQuad.getVertices()[3].set(x, y + yl);
		}
		return globalQuad;
	}

}