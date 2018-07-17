package powerlessri.cjp.objects.base;

public interface IDateTime extends ITime {
	
	public static enum EMonth implements IStringSerializable {
		JANUARY("January", 1),
		FEBRUARY("February", 2),
		MARCH("March", 3),
		APRIL("April", 4),
		MAY("May", 5),
		JUNE("June", 6),
		JULY("July", 7),
		AUGUST("August", 8),
		SEPTEMBER("September", 9),
		OCTOBER("October", 10),
		NOVEMBER("November", 11),
		DECEMBER("December", 12);
		
		private String name;
		private int month;
		
		private EMonth(String name, int id) {
			this.name = name;
			this.month = id;
		}
		
		public String getName() {
			return this.name;
		}
		
		public int numericalId() {
			return this.month;
		}
		
		@Override
		public String toString() {
			return this.getName();
		}
		
		
		
		public static EMonth getMonthById(int m) {
			return EMonth.values()[m];
		}
 	}
	
	public static enum EWeek implements IStringSerializable {
		MONDAY("Monday", "Mon.", 1),
		TUESDAY("Tuesday", "Tues.", 2),
		WEDNESDAY("Wednesday", "Wed.", 3),
		THURSDAY("Thursday", "Thurs.", 4),
		FRIDAY("Friday", "Fri.", 5),
		SATURDAY("Saturday", "Sat.", 6),
		SUNDAY("Sunday", "Sun.", 7);
		
		private String fullName;
		private String shorthand;
		private int id;
		
		private EWeek(String fullName, String shorthand, int id) {
			this.fullName = fullName;
			this.shorthand = shorthand;
			this.id = id;
		}
		
		public String getName() {
			return this.fullName;
		}
		
		public String getShorthand() {
			return this.shorthand;
		}
		
		public int numericalId() {
			return this.id;
		}
		
		
		@Override
		public String toString() {
			return this.getName();
		}
		
		
		
		public static EWeek getWeekById(int w) {
			return EWeek.values()[w - 1];
		}
	}
	
	int getYear();
	int getMonth();
	int getDay();
	
	int getWeek();
	
	EMonth getMonthM();
	EWeek getWeekW();

}
