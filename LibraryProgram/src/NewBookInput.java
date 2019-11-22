import javax.swing.*;
import BreezySwing.*;
import java.util.ArrayList;

public class NewBookInput extends GBDialog {
	
	private ArrayList<Library> abook = new ArrayList<Library>();
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
		
	JButton enterButton = addButton("Enter",7,1,2,1);
	
	public void buttonClicked(JButton buttonObj) {
		if (buttonObj == enterButton) {
			String name = null;
			date checkoutdate = new date();
			abook.add(new Library(titleField.getText(), authorField.getText(), checkoutdate));
		}
	}
	
	
	
}
