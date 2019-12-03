import javax.swing.*;
import BreezySwing.*;
import java.util.ArrayList;

public class LoanBook extends GBDialog {
	private ArrayList<Library> abook = new ArrayList<Library>();
	
	public LoanBook(JFrame parent, ArrayList<Library> book) {
		super (parent);
		setTitle("New Book");
		setSize(400,400);
		setDlgCloseIndicator ("a");
		this.abook = book;
		
		dateLabel.setVisible(false);
		monthLabel.setVisible(false);
		monthField.setVisible(false);
		dayLabel.setVisible(false);
		dayField.setVisible(false);
		yearLabel.setVisible(false);
		yearField.setVisible(false);
		nameLabel.setVisible(false);
		nameField.setVisible(false);
		checkoutButton.setVisible(false);
		clearButton.setVisible(false);
	}
	
	JLabel loanLabel = addLabel("Enter the title of the book you wish to loan out",1,1,2,1);
	JTextField searchField = addTextField("",2,1,1,1);
	JButton searchButton  = addButton("Search",2,2,1,1);
	JButton exitButton = addButton("Exit",2,3,1,1);
	JLabel dateLabel = addLabel("Checkout date:",3,1,2,1);
	JLabel monthLabel = addLabel("Month:", 4,1,1,1);
	IntegerField monthField = addIntegerField(0,4,2,1,1);
	JLabel dayLabel = addLabel("Day:", 5,1,1,1);
	IntegerField dayField = addIntegerField(0,5,2,1,1);
	JLabel yearLabel = addLabel ("Year:", 6,1,1,1);
	IntegerField yearField = addIntegerField(0,6,2,1,1);
	JLabel nameLabel = addLabel("Name of borrower", 7,1,1,1);
	JTextField nameField = addTextField("",7,2,1,1);
	JButton checkoutButton = addButton("Check out book",8,1,1,1);
	JButton clearButton = addButton("Clear", 8,2,1,1);
	
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
			
			searchField.setEnabled(false);
			searchButton.setEnabled(false);
			dateLabel.setVisible(true);
			monthLabel.setVisible(true);
			monthField.setVisible(true);
			dayLabel.setVisible(true);
			dayField.setVisible(true);
			yearLabel.setVisible(true);
			yearField.setVisible(true);
			nameLabel.setVisible(true);
			nameField.setVisible(true);
			checkoutButton.setVisible(true);
			clearButton.setVisible(true);
			
			monthField.requestFocus();
			monthField.selectAll();
			
		}
		
		if (buttonObj == checkoutButton) {
			searchedbook.setBorrowed(true);
			date checkoutdate = new date(dayField.getNumber(), monthField.getNumber(), yearField.getNumber());
			searchedbook.setDate(checkoutdate);
			searchedbook.setName(nameField.getText());
			try {
				checkoutdate.isValid(checkoutdate);
			} catch (Exception e) {
				messageBox(e.getMessage());
				checkoutdate = checkoutdate.changeDate(checkoutdate);
			}
			
			messageBox("You have checked out the book " + searchedbook.getTitle() + " by " + searchedbook.getAuthor() + " on " + checkoutdate.getMonth() + "/" + checkoutdate.getDay() + "/" + checkoutdate.getYear());
			
		}
		
		if (buttonObj == clearButton) {
			monthField.setText("");
			dayField.setText("");
			yearField.setText("");
			nameField.setText("");
			
			searchField.setEnabled(true);
			searchButton.setEnabled(true);
			searchField.setText("");
			dateLabel.setVisible(false);
			monthLabel.setVisible(false);
			monthField.setVisible(false);
			dayLabel.setVisible(false);
			dayField.setVisible(false);
			yearLabel.setVisible(false);
			yearField.setVisible(false);
			nameLabel.setVisible(false);
			nameField.setVisible(false);
			checkoutButton.setVisible(false);
			clearButton.setVisible(false);
		}
		
		if (buttonObj == exitButton) {
			dispose();
		}
	}
}
