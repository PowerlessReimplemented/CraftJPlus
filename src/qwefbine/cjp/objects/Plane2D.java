package qwefbine.cjp.objects;

import qwefbine.cjp.exceptions.IllegalArugmentsException;
import qwefbine.cjp.objects.base.IDimensionalContainer;

public class Plane2D extends DummyBase implements IDimensionalContainer {
	
	private Point2i[][] plane;
	
	private int width;
	private int height;
	
	public Plane2D(int width, int height) {
		this.width = width;
		this.height = height;
		this.plane = new Point2i[height][width];
	}
	
	
	// y
	// ^
	// | [[5, 9, 1],
	// |  [0, 3, 6],
	// |  [1, 4, 3]]     <= plane[][]
	// |
	// +---^--^--^----> x
	//
	// the first index is y on the plane,
	// the second index is x on the plane.
	
	
	/**
	 * Get a point on the plane. <br />
	 * x or y should start at <b>0</b>
	 * 
	 * @param x The x of requesting point
	 * @param y The y of requesting point
	 * @return The object at (x, y)
	 */
	public Point2i getPoint(int x, int y) {
		if(!isInBound(x, y))
			throw new IllegalArugmentsException("Index out of bound"); 
		
		return plane[y][x];
	}
	
	/**
	 * Set a point on the plane to a new value. <br />
	 * x or y should start at <b>0</b>
	 * 
	 * @param x The y of the changing point
	 * @param y The x of the changing point
	 * @param p The new value (x, y) going to be
	 * @return The old value on the point
	 */
	public Point2i setPoint(int x, int y, Point2i p) {
		if(!isInBound(x, y))
			throw new IllegalArugmentsException("Index out of bound"); 
		
		Point2i oldVal = this.plane[y][x];
		this.plane[y][x] = p;
		
		return oldVal;
	}
	
	private boolean isInBound(int x, int y) {
		if(x >= this.width || y >= this.height || x < 0 || y < 0) {
			return false;
		}
		return true;
	}
	
	
	
	@Override
	public int dim() {
		return 2;
	}
	
}
