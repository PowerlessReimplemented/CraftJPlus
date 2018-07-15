package qwefbine.cjp.objects;

import qwefbine.cjp.objects.base.ISimpleData;
import qwefbine.cjp.objects.base.IStringSerializable;

public class DummyBase
				implements ISimpleData, IStringSerializable, Comparable<DummyBase> {

	@Override
	public int compareTo(DummyBase b) {
		return 0;
	}
	
	
	
	@Override
	public String toString() {
		return (String) this.getData();
	}
	
	
	@Override
	public Object getData() {
		return "";
	}
	@Override
	public void printData() {
		System.out.println(this.getData());
	}
	
}
