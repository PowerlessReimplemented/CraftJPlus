package qwefbine.cjp.objects.base;

public interface IDimensionalContainer {
	
	/**
	 * Get dimension of a specific container.
	 * e.g. Should return 1 if this container holds
	 * IPoint with dim() -> 1 
	 * 
	 * @return The dimension of this container
	 */
	int dim();
	
}
