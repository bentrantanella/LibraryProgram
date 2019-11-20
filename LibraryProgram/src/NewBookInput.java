import javax.swing.*;
import BreezySwing.*;
import java.util.ArrayList;

public class NewBookInput extends GBDialog {
	
	private Library abook;
	public NewBookInput(JFrame parent, Book book) {
		super (parent);
		setTitle("New Book");
		setSize(250,250);
		setDlgCloseIndicator ("close");
		
		this.abook = book;
	}
	
	
	
	
}
