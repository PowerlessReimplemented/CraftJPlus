package qwefbine.cjp.objects;

import qwefbine.cjp.objects.base.IDataStructure;
import qwefbine.cjp.objects.base.IDateTime;
import qwefbine.cjp.objects.base.IDayTime;
import qwefbine.cjp.objects.base.IPoint;
import qwefbine.cjp.objects.base.IStringSerializable;

public class DummyBase implements IDateTime, IDayTime, IPoint, IDataStructure, IStringSerializable, Comparable<DummyBase> {
	
	protected int hours;
	protected int minutes;
	protected int seconds;
	protected int milliseconds;
	
	protected int years;
	protected int months;
	protected int days;
	protected int week;
	
	protected EMonth month;
	protected EWeek weekDay;

	@Override
	public int compareTo(DummyBase b) {
		return 0;
	}
	
	@Override
	public int dim() {
		return 0;
	}
	
	
	@Override
	public int getHour() {
		return 0;
	}
	@Override
	public int getMinute() {
		return 0;
	}
	@Override
	public int getSecond() {
		return 0;
	}
	@Override
	public int getMillisecond() {
		return 0;
	}
	
	
	@Override
	public int getYear() {
		return 1999;
	}
	@Override
	public int getDay() {
		return 1;
	}
	@Override
	public int getMonth() {
		return EMonth.JANUARY.numericalId();
	}
	@Override
	public int getWeek() {
		return EWeek.SUNDAY.numericalId();
	}
	
	
	@Override
	public EMonth getMonthM() {
		return EMonth.JANUARY;
	}
	@Override
	public EWeek getWeekW() {
		return EWeek.SUNDAY;
	}
	
	
	@Override
	public String toString() {
		return this.getOutput();
	}
	
	
	@Override
	public Object[] getData() {
		return new Object[]{};
	}
	@Override
	public Object getFormattedData() {
		return new Object();
	}
	
	
	@Override
	public String getOutput() {
		return "";
	}
	@Override
	public String getFormattedOutput() {
		return "";
	}
	
	
	@Override
	public void printData() {
		System.out.println(this.getOutput());
	}
	@Override
	public void printFormattedData() {
		System.out.println(this.getFormattedOutput());
	}
	
}
