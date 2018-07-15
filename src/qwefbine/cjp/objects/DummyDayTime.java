package qwefbine.cjp.objects;

import qwefbine.cjp.objects.base.IDayTime;

public class DummyDayTime
				extends DummyBase
				implements IDayTime {
	
	protected int hours;
	protected int minutes;
	protected int seconds;
	protected int milliseconds;
	
	public DummyDayTime(int hours, int minutes, int seconds) {
		this(hours, minutes, seconds, 0);
	}
	
	public DummyDayTime(int hours, int minutes, int seconds, int milliseconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
		this.milliseconds = milliseconds;
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
	public String getData() {
		return this.hours + ":" + this.minutes + ":" + this.seconds + " " + this.milliseconds;
	}
	
}
