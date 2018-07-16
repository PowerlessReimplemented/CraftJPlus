package powerlessri.cjp.objects.base;

public interface IPoint {
	
	/**
	 * Get the dimension of the specific class, like
	 * a point on a 2D plane should return 2, a point 
	 * in a 3D space should return 3.
	 * 
	 * @return The dimension of this class
	 */
	int dim();
	
}
