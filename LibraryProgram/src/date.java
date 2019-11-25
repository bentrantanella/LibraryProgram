
public class date {
	private int day;
	private int month;
	private int year;
	
	public date(int inpday, int inpmonth, int inpyear) {
		day = inpday;
		month = inpmonth;
		year = inpyear;
	}
	
	public date() {
		
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setDay(int d) {
		day = d;
	}
	
	public void setMonth(int m) {
		month = m;
	}
	
	public void setYear(int y) {
		year = y;
	}
	
	public void isValid (date newdate) throws InvalidInput {
		boolean valid = true;
		
		int day = newdate.getDay();
		int month = newdate.getMonth();
		int year = newdate.getYear();
		
		if (month > 12 || month < 0) {
			throw new InvalidInput("Invalid month");
		} else if (year < 0) {
			throw new InvalidInput("Invalid year");
		}
		
		boolean isleap = isLeap(year);
		
		if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day > 31) {
			throw new InvalidInput("Invalid day");
		} else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
			throw new InvalidInput("Invalid day");
		} else if ((month == 2 && isleap == true && day > 29) || (month == 2 && isleap == false && day > 28)) {
			throw new InvalidInput("Invalid day");
		}
		
		
	}
	
	private boolean isLeap (int year) {
		boolean leap = false;
		if (year % 100 == 0 && year % 400 == 0) 
			leap = true;
		else if (year % 100 != 0 && year % 4 == 0)
			leap = true;
		else leap = false;
		
		return leap;
	}
}
