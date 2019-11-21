import javax.swing.*;
import BreezySwing.*;
import java.util.ArrayList;

public class NewBookInput extends GBDialog {
	
	private ArrayList<Library> abook;
	public NewBookInput(JFrame parent, ArrayList<Library> book) {
		super (parent);
		setTitle("New Book");
		setSize(250,250);
		setDlgCloseIndicator ("close");
		
		this.abook = book;
	}
	
	JLabel titleLabel = addLabel("Title:",1,1,1,1);
	JTextField titleField = addTextField("",1,2,1,1);
	
	JLabel authorLabel = addLabel("Author:",2,1,1,1);
	JTextField authorField = addTextField("",2,2,1,1);
	
	JLabel nameLabel = addLabel("Name:",3,1,1,1);
	JTextField nameField = addTextField("",3,2,1,1);
	
	JLabel monthLabel = addLabel("Month:",4,1,1,1);
	JTextField monthField = addTextField("",4,2,1,1);
	
	JLabel dayLabel = addLabel("Day:",5,1,1,1);
	JTextField dayField = addTextField("",5,2,1,1);
	
	JLabel yearLabel = addLabel("Year:",6,1,1,1);
	JTextField yearField = addTextField("",6,2,1,1);
	
	JButton enterButton = addButton("Enter",7,1,2,1);
	
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == enterButton) {
			
		}
	}
	
	
	
}
