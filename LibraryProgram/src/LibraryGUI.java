import javax.swing.*;
import BreezySwing.*;

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
	
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == newbookButton) {
			
		}
		
		if (buttonObj == searchButton) {
			
		}
		
		if (buttonObj == loanButton) {
			
		}
		
		if (buttonObj == returnButton) {
			
		}
		
		if (buttonObj == printBorrowedButton) {
			
		}
		
		if (buttonObj == printOverdueButton) {
			
		}
	}

}
