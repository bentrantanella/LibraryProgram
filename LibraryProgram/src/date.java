
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
}
