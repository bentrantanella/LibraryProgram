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
	}
	
	JLabel loanLabel = addLabel("Enter the title of the book you wish to loan out",1,1,2,1);
	JTextField searchField = addTextField("",2,1,1,1);
	JButton searchButton  = addButton("Search",2,2,1,1);
	
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == searchButton) {
			String title = loanLabel.getText();
			
			String[] booktitles = new String[abook.size()];
			for(int i = 0; i < abook.size(); i++) {
				Library book = abook.get(i);
				booktitles[i] = book.getTitle();
			}
			boolean found = false;
			for(int j = 0; j < abook.size(); j++) {
				if (searchField.getText().equals(booktitles[j]) == true) {
					Library searchedbook = abook.get(j);
					found = true;
					break;
				}
				if (found == false)
					messageBox("There are no books with this title");
			}
		}
	}
}
