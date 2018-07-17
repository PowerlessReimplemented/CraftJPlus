package powerlessri.cjp.objects.base;

public class DummyDateTime
				extends DummyBase
				implements IDateTime {
	
	protected int years;
	protected int months;
	protected int days;
	protected int week;
	
	protected EMonth month;
	protected EWeek weekDay;
	
	public DummyDateTime(int years, int months, int days, int week) {
		this.years = years;
		this.months = months;
		this.days = days;
		this.week = week;
		
		this.month = EMonth.getMonthById(months);
		this.weekDay = EWeek.getWeekById(week);
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
	
}
