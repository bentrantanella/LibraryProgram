import javax.swing.*;
import BreezySwing.*;
import java.util.ArrayList;

public class ReturnBook extends GBDialog{
private ArrayList<Library> abook = new ArrayList<Library>();
	
	public ReturnBook(JFrame parent, ArrayList<Library> book) {
		super (parent);
		setTitle("New Book");
		setSize(300,300);
		setDlgCloseIndicator ("a");
		
		this.abook = book;
	}
	
	JLabel returnLabel = addLabel("Enter the title of the book you would like to return: ",1,1,2,1);
	JTextField returnField = addTextField("",2,1,1,1);
	JButton returnButton = addButton("Return",3,1,1,1);
	
	Library rbook = new Library();
	boolean found = false;
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == returnButton) {
			for(Library b : abook) {
				if (returnField.getText().equalsIgnoreCase(b.getTitle()) == true) {
					found = true;
					rbook = b;
				}
				
				if (found = false) {
					messageBox("Book not found");
					return;
				}
				
				if (rbook.checkBorrowed() == false) {
					messageBox("This book was not checked out");
					return;
				}
				
				messageBox("You have returned the book " + rbook.getTitle() + " by " + rbook.getAuthor());
				
				
				rbook.setBorrowed(false);
				rbook.setName(null);
				rbook.setDate(null);
				
				dispose();
			}
		}
	}
}
