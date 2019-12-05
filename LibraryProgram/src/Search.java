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
	
	JTextArea outputArea = addTextArea("",3,1,2,1);
	
	

	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == searchButton) {
			if(searchField.getText().contentEquals("") == true || checkWhitespace(searchField.getText()) == true) {
				messageBox("Enter a title");
				return;
			}
			
			String[] booktitles = new String[abook.size()];
			for(int i = 0; i < abook.size(); i++) {
				Library book = abook.get(i);
				booktitles[i] = book.getTitle();
			}
			String output = "";
			for(int j = 0; j < abook.size(); j++) {
				if (searchField.getText().equalsIgnoreCase(booktitles[j]) == true) {
					Library searchedbook = abook.get(j);
					output = output + "Title: " + searchedbook.getTitle() + "\n" +  "Author: " + searchedbook.getAuthor() + "\n" + "Checked out: " + searchedbook.checkBorrowed() + "\n";
					
					if (searchedbook.checkBorrowed() == true) {
						date newdate = searchedbook.getDate();
						output = output + "Name of borrower: " + searchedbook.getName() + "\n" + "Date borrowed: " + newdate.getMonth() + "/" + newdate.getDay() + "/" + newdate.getYear() + "\n";
					}
					
					
				}
				
			}
			if (output == "")
				output = "There are no books with this title";
			
			outputArea.setText(output);
			outputArea.setEditable(false);
		}
	}
	
	private boolean checkWhitespace(String str) {
		for(int j = 0; j < str.length(); j++) {
			if(str.charAt(j) != ' ')
				return false;
		}
		return true;
	}

}
