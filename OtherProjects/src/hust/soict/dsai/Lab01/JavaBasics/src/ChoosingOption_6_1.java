package hust.soict.dsai.Lab01.JavaBasics.src;

import javax.swing.JOptionPane;
public class ChoosingOption_6_1 {
	public static void main(String[] arg) {
		int option = JOptionPane.showConfirmDialog(null, 
				"Do you want to change to the first class ticket?");
		
		JOptionPane.showMessageDialog(null, "You've chosen: "
				+ (option == JOptionPane.YES_OPTION?"Yes":"No"));
		System.exit(0);
	}
}
