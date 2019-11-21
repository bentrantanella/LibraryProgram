import java.util.ArrayList;

public class Library {
	
	private String title;
	private String author;
	private String name;
	private int day;
	private ArrayList<Library> book = new ArrayList<Library>();
	
	public Library() {
		title = "";
		author = "";
	}
	
	public Library(String bookname, String writer) {
		title = bookname;
		author = writer;
	}
	
	public void setAuthor() {
		
	}
	
	
}
