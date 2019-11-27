import javax.swing.*;
import BreezySwing.*;
import java.util.ArrayList;

public class LibraryGUI extends GBFrame {
	
	public static void main(String[] args) {
		JFrame frm = new LibraryGUI();
		frm.setTitle("Ben's Library");
		frm.setSize(300, 300);
		frm.setVisible(true);
	}
	
	JButton newbookButton = addButton("New Book", 1,1,1,1);
	JButton searchButton = addButton("Search",1,2,1,1);
	JButton loanButton = addButton("Loan a book",2,1,1,1);
	JButton returnButton = addButton("Return a book",2,2,1,1);
	JButton printBorrowedButton = addButton("Borrowed books",3,1,1,1);
	JButton printOverdueButton = addButton("Overdue books",3,2,1,1);
	
	ArrayList<Library> books = new ArrayList<Library>();
	
	public LibraryGUI() {
		searchButton.setEnabled(false);
		loanButton.setEnabled(false);
		returnButton.setEnabled(false);
		printBorrowedButton.setEnabled(false);
		printOverdueButton.setEnabled(false);
	}
	
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == newbookButton) {
			NewBookInput input = new NewBookInput(this, books);
			input.setVisible(true);
			
			if (books.size() > 0) {
				searchButton.setEnabled(true);
				loanButton.setEnabled(true);
			}
		}
		
		if (buttonObj == searchButton) {
			Search search = new Search(this, books);
			search.setVisible(true);
		}
		
		if (buttonObj == loanButton) {
			LoanBook loan = new LoanBook(this, books);
			loan.setVisible(true);
			
			for(Library b : books) {
				if (b.checkBorrowed() == true) {
					returnButton.setEnabled(true);
					printBorrowedButton.setEnabled(true);
					printOverdueButton.setEnabled(true);
					return;
				}
			}
		}
		
		if (buttonObj == returnButton) {
			ReturnBook r = new ReturnBook(this, books);
			r.setVisible(true);
			
			for (Library b : books) {
				if (b.checkBorrowed() == true)
					return;
			}
			
			printBorrowedButton.setEnabled(false);
			printOverdueButton.setEnabled(false);
		}
		
		if (buttonObj == printBorrowedButton) {
			PrintBorrowed borrowed = new PrintBorrowed(this, books);
			borrowed.setVisible(true);
		}
		
		if (buttonObj == printOverdueButton) {
			
		}
	}

}
