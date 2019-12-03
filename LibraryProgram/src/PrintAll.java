import javax.swing.*;
import BreezySwing.*;
import java.util.ArrayList;

public class PrintAll  extends GBDialog {
	private ArrayList<Library> abook = new ArrayList<Library>();
	
	public PrintAll(JFrame parent, ArrayList<Library> book) {
		super(parent);
		setTitle("New Book");
		setSize(300,300);
		setDlgCloseIndicator ("a");
		
		this.abook = book;
		JLabel allbooksLabel = addLabel("All books in the library:",1,1,1,1);
		JTextArea booksArea = addTextArea("",2,1,2,1);
		String output = "";
		
		for(Library b : abook) {
			output = output + "Title: " + b.getTitle() + "\n" + "Author: " + b.getAuthor() + "\n" + "\n";
		}
		
		if (output == "") 
			output = "There are no books in the library";
		
		booksArea.setText(output);
		booksArea.setEditable(false);
	}
}
