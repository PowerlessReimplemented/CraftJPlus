package powerlessri.cjp.objects;

import powerlessri.cjp.objects.base.DummyBase;
import powerlessri.cjp.objects.base.IPoint;

public class Point1i extends DummyBase implements IPoint {
	
	public int x;
	
	public Point1i(int x) {
		this.x = x;
	}
	
	@Override
	public int dim() {
		return 1;
	}
	
}
