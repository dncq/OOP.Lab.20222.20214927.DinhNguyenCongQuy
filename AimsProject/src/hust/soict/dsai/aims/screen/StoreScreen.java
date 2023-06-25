package hust.soict.dsai.aims.screen;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;





public class StoreScreen extends JFrame {
	
	private Store store;
	
	public StoreScreen() {
		// TODO Auto-generated constructor stub
	}
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(getLayout());
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
}
