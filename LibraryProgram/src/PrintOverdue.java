import javax.swing.*;
import BreezySwing.*;
import java.util.ArrayList;

public class PrintOverdue extends GBDialog {
	private ArrayList<Library> abook = new ArrayList<Library>();
	
	public PrintOverdue(JFrame parent, ArrayList<Library> book) {
		super(parent);
		setTitle("Print all overdue books");
		setSize(300,300);
		setDlgCloseIndicator ("a");
		
		this.abook = book;
	}
	
	JLabel dateLabel = addLabel("Enter the current date",1,1,1,1);
	JLabel monthLabel = addLabel("Month:", 2,1,1,1);
	IntegerField monthField = addIntegerField(0,2,2,1,1);
	JLabel dayLabel = addLabel("Day:", 3,1,1,1);
	IntegerField dayField = addIntegerField(0,3,2,1,1);
	JLabel yearLabel = addLabel ("Year:", 4,1,1,1);
	IntegerField yearField = addIntegerField(0,4,2,1,1);
	JButton displayButton = addButton("Print",5,1,1,1);
	
	public void buttonClicked(JButton buttonObj) {
		
		int month = monthField.getNumber();
		int day = dayField.getNumber();
		int year = yearField.getNumber();
		String output = "";
		date rdate = new date(day, month, year);
		
		JTextArea outputArea = addTextArea("",6,1,2,1);
		
		for(int j = 0; j < abook.size(); j++) {
			Library book = abook.get(j);
			if (rdate.isOverdue(book.getDate(), rdate) == true) {
				output = output + "Title: " + book.getTitle() + "\n" + "Author: " + book.getAuthor();
				output = output + "\n" + "Name of borrower: " + book.getName() + "\n" + "\n"; 
			}
		}
		if(output.contentEquals(""))
			output = "There are no overdue books";
		
		outputArea.setText(output);
		outputArea.setEditable(false);
		revalidate();
	}
}
