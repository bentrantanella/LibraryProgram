import javax.swing.*;
import BreezySwing.*;
import java.util.ArrayList;

public class LoanBook extends GBDialog {
	
	public LoanBook(JFrame parent, ArrayList<Library> book) {
		super (parent);
		setTitle("New Book");
		setSize(300,300);
		setDlgCloseIndicator ("a");
		
	}
	
	JLabel loanLabel = addLabel("Enter the title of the book you wish to loan out",1,1,2,1);
	JTextField searchField = addTextField("",2,1,1,1);
	JButton searchButton  = addButton("Search",2,2,1,1);
	
	

}
