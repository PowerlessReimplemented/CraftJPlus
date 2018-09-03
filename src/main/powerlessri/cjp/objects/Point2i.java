package powerlessri.cjp.objects;

import powerlessri.cjp.objects.base.DummyBase;
import powerlessri.cjp.objects.base.IPoint;

public class Point2i<T>
    extends DummyBase
    implements IPoint {
	
	public final int x;
	public final int y;
	public final T value;
	
	public Point2i(T val, int x, int y) {
		this.x = x;
		this.y = y;
		this.value = val;
	}
	
	@Override
	public int dim() {
		return 2;
	}
}
