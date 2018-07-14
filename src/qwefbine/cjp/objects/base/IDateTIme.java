package qwefbine.cjp.objects.base;

public interface IDateTIme extends ITime {
	
	public static enum EWeek implements IStringSerializable {
		SUNDAY("Sunday", "Sun."),
		MONDAY("Monday", "Mon."),
		TUESDAY("Tuesday", "Tues."),
		WEDNESDAY("Wednesday", "Wed."),
		THURSDAY("Thursday", "Thurs."),
		FRIDAY("Friday", "Fri."),
		SATURDAY("Saturday", "Sat.");
		
		private String fullName;
		private String shorthand;
		
		private EWeek(String fullName, String shorthand) {
			this.fullName = fullName;
			this.shorthand = shorthand;
		}
		
		public String getName() {
			return this.fullName;
		}
		
		public String getShorthand() {
			return this.shorthand;
		}
		
		
		@Override
		public String toString() {
			return this.getName();
		}
	}
	
	int getYear();
	int getMonth();
	int getDay();
	
	int getWeek();
	
	EWeek getWeekDay();

}
