
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
	
	public date isValid (date newdate) throws InvalidInput {
		
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
			newdate.setDay(31);
			throw new InvalidInput("Invalid day");
		} else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
			newdate.setDay(30);
			throw new InvalidInput("Invalid day");
		} else if ((month == 2 && isleap == true && day > 29) || (month == 2 && isleap == false && day > 28)) {
			if (isleap == true)
				newdate.setDay(29);
			else newdate.setDay(28);
			throw new InvalidInput("Invalid day");
		}
		
		return newdate;
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
	
	private int dayConverter(int month, int day, int year) {
		int[] adder = {0,31,59,90,120,151,181,212,243,273,304,334,365};
		if (isLeap(year) == true) {
			for(int j = 2; j < adder.length; j++)
				adder[j]++;
		}
		
		int total = adder[month-1] + day;
		System.out.println(total);
		return total;
 
		
	}
	
	public boolean isOverdue (date cd, date rd) {
		int year1 = cd.getYear();
		int year2 = rd.getYear();
		int month1 = cd.getMonth();
		int month2 = rd.getMonth();
		int day1 = cd.getDay();
		int day2 = rd.getDay();
		
		int date1 = dayConverter(month1,day1,year1);
		int date2 = dayConverter(month2,day2,year2);
		
		if (date2 - date1 >= 14 && year1 == year2)
			return true;
		else if (year2 - year1 == 1 && date1 - date2 <= 351)
			return true;
		

		
		return false;
	}
}
