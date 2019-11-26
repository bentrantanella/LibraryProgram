import java.util.ArrayList;

public class Library {
	
	private String title;
	private String author;
	private String name;
	private ArrayList<Library> book = new ArrayList<Library>();
	private date date = new date();
	private boolean isborrowed;
	
	public Library() {
		title = "";
		author = "";
		isborrowed = false;
	}
	
	public Library(String bookname, String writer, String username, date newdate, boolean borrowed) {
		title = bookname;
		author = writer;
		name = username;
		date = newdate;
		isborrowed = borrowed;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public date getDate() {
		return date;
	}
	
	public void setDate(date d) {
		date = d;
	}
	
	public boolean checkBorrowed() {
		return isborrowed;
	}
	
	public void setBorrowed(boolean borrowed) {
		isborrowed = borrowed;
	}
}
