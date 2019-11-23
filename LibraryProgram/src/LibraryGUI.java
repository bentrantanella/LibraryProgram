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
	
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == newbookButton) {
			NewBookInput input = new NewBookInput(this, books);
			input.setVisible(true);
			
			
			
		}
		
		if (buttonObj == searchButton) {
			Search search = new Search(this, books);
			search.setVisible(true);
		}
		
		if (buttonObj == loanButton) {
			LoanBook loan = new LoanBook(this, books);
			loan.setVisible(true);
		}
		
		if (buttonObj == returnButton) {
			
		}
		
		if (buttonObj == printBorrowedButton) {
			
		}
		
		if (buttonObj == printOverdueButton) {
			
		}
	}

}
