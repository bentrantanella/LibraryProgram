import java.util.ArrayList;

public class Library {
	
	private String title;
	private String author;
	private String name;
	private int day;
	private int month;
	private int year;
	private ArrayList<Library> book = new ArrayList<Library>();
	
	public Library() {
		title = "";
		author = "";
	}
	
	public Library(String bookname, String writer, String username, date newdate) {
		title = bookname;
		author = writer;
		name = username;
		day = newdate.getDay();
	}
	
	public String getAuthor() {
		return author;
	}
	
	
}
