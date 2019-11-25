import javax.swing.*;
import BreezySwing.*;
import java.util.ArrayList;

public class LoanBook extends GBDialog {
	private ArrayList<Library> abook = new ArrayList<Library>();
	
	public LoanBook(JFrame parent, ArrayList<Library> book) {
		super (parent);
		setTitle("New Book");
		setSize(300,300);
		setDlgCloseIndicator ("a");
		this.abook = book;
		
		dateLabel.setVisible(false);
		monthLabel.setVisible(false);
		monthField.setVisible(false);
		dayLabel.setVisible(false);
		dayField.setVisible(false);
		yearLabel.setVisible(false);
		yearField.setVisible(false);
		checkoutButton.setVisible(false);
	}
	
	JLabel loanLabel = addLabel("Enter the title of the book you wish to loan out",1,1,2,1);
	JTextField searchField = addTextField("",2,1,1,1);
	JButton searchButton  = addButton("Search",2,2,1,1);
	JLabel dateLabel = addLabel("Checkout date:",3,1,2,1);
	JLabel monthLabel = addLabel("Month:", 4,1,1,1);
	IntegerField monthField = addIntegerField(0,4,2,1,1);
	JLabel dayLabel = addLabel("Day:", 5,1,1,1);
	IntegerField dayField = addIntegerField(0,5,2,1,1);
	JLabel yearLabel = addLabel ("Year:", 6,1,1,1);
	IntegerField yearField = addIntegerField(0,6,2,1,1);
	JButton checkoutButton = addButton("Check out book",6,1,2,1);
	
	Library searchedbook = new Library();
	
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == searchButton) {
			String title = searchField.getText();
			
			String[] booktitles = new String[abook.size()];
			for(int i = 0; i < abook.size(); i++) {
				Library book = abook.get(i);
				booktitles[i] = book.getTitle();
			}
			
			boolean found = false;
			for(int j = 0; j < abook.size(); j++) {
				if (title.equals(booktitles[j]) == true) {
					searchedbook = abook.get(j);
					found = true;
					break;
				}
			}
			
			if (found == false) {
				messageBox("There are no books with this title");
				return;
			}
			
			if (searchedbook.checkBorrowed() == true) {
				messageBox("This book is already checked out");
				return;
			}
			
			messageBox("Book found:" + "\n" + "Title: " + searchedbook.getTitle() + "\n" + "Author: " + searchedbook.getAuthor());
			
			dateLabel.setVisible(true);
			monthLabel.setVisible(true);
			monthField.setVisible(true);
			dayLabel.setVisible(true);
			dayField.setVisible(true);
			yearLabel.setVisible(true);
			yearField.setVisible(true);
			checkoutButton.setVisible(true);
			
		}
		if (buttonObj == checkoutButton) {
			
		}
	}
}
