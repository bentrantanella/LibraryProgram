import javax.swing.*;
import BreezySwing.*;
import java.util.ArrayList;

public class Search extends GBDialog {
	private ArrayList<Library> abook = new ArrayList<Library>();
	
	public Search(JFrame parent, ArrayList<Library> book) {
		super (parent);
		setTitle("New Book");
		setSize(300,300);
		setDlgCloseIndicator ("a");
		
		this.abook = book;
	}
	
	JLabel searchLabel = addLabel("Search for a book by title:",1,1,1,1);
	JTextField searchField = addTextField("",1,2,1,1);
	JButton searchButton  = addButton("Search",2,1,2,1);
	
	JLabel titleLabel = addLabel("",3,1,1,1);
	JLabel authorLabel = addLabel("",4,1,1,1);
	JLabel borrowedLabel = addLabel("",5,1,1,1);
	
	

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == searchButton) {
			String[] booktitles = new String[abook.size()];
			for(int i = 0; i < abook.size(); i++) {
				Library book = abook.get(i);
				booktitles[i] = book.getTitle();
			}
			boolean found = false;
			for(int j = 0; j < abook.size(); j++) {
				if (searchField.getText().equals(booktitles[j]) == true) {
					Library searchedbook = abook.get(j);
					titleLabel.setText("Title: " + searchedbook.getTitle());
					authorLabel.setText("Author: " +searchedbook.getAuthor());
					borrowedLabel.setText("Checked out: " + searchedbook.checkBorrowed() + "");
					
					if (searchedbook.checkBorrowed() == true) {
						date newdate = searchedbook.getDate();
						JLabel nameLabel = addLabel("Name of borrower: " + searchedbook.getName(), 6,1,1,1);
						JLabel dateLabel = addLabel("Date borrowed: " + newdate.getMonth() + "/" + newdate.getDay() + "/" + newdate.getYear(),7,1,1,1);
						revalidate();
					}
					found = true;
					break;
				}
				if (found == false)
					messageBox("There are no books with this title");
			}
		}
	}

}
