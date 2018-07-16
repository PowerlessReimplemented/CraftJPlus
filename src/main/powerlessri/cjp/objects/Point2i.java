package powerlessri.cjp.objects;

import powerlessri.cjp.objects.base.IPoint;

public class Point2i extends DummyBase implements IPoint {
	
	public int x;
	public int y;
	
	public Point2i(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int dim() {
		return 2;
	}
}
