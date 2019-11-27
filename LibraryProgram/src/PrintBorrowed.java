import javax.swing.*;
import BreezySwing.*;
import java.util.ArrayList;

public class PrintBorrowed extends GBDialog {
	private ArrayList<Library> abook = new ArrayList<Library>();
	
	public PrintBorrowed(JFrame parent, ArrayList<Library> book) {
		super(parent);
		setTitle("New Book");
		setSize(300,300);
		setDlgCloseIndicator ("a");
		
		this.abook = book;
	}
	
	JLabel printLabel = addLabel("All borrowed books:",1,1,1,1);
	JTextArea booksArea = addTextArea("",2,1,1,1);
	JButton printButton = addButton("Print",2,2,1,1);
	
	public void buttonClicked(JButton buttonObj) {
		String output = "";
		
		for(Library b : abook) {
			if (b.checkBorrowed() == true) {
				date newd = b.getDate();
				output = output + "Title: " + b.getTitle() + "\n" + "Author: " + b.getAuthor();
				output = output + "\n" + "Name of borrower: " + b.getName();
				output = output + "\n" + "Date borrowed: " + newd.getMonth() + "/" + newd.getDay() + "/" + newd.getYear();
			}
		}
		
		booksArea.setText(output);
	}
}
