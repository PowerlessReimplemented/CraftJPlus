package powerlessri.cjp.objects;

import powerlessri.cjp.objects.base.IDayTime;

public class Time
				extends DummyDayTime
				implements IDayTime {
	
	public int hours;
	public int minutes;
	public int seconds;
	
	public Time(int h, int m, int s) {
		super(h, m, s);
	}
	
	
	
	@Override
	public int compareTo(DummyBase b) {
		return this.compareTo((Time) b);
	}
	
	public int compareTo(Time t) {
		if(this.hours != t.hours) {
			return this.hours - t.hours;
		}
		if(this.minutes != t.minutes) {
			return this.minutes - t.minutes;
		}
		return this.seconds - t.seconds;
	}
	
}
