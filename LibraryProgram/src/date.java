
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
		day = null;
		month = null;
	}
	
	public int getDay() {
		return day;
	}
}
