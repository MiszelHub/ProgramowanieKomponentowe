import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class MainMenu extends JMenuBar{
	private static final long serialVersionUID = -1252406631918788989L;

	//Where the GUI is created:
	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem menuItem;
	JRadioButtonMenuItem rbMenuItem;
	JCheckBoxMenuItem cbMenuItem;
	
	public JMenuBar getMenuBar(){
		return menuBar;
	}

	MainMenu(){
		//Create the menu bar.
		menuBar = new JMenuBar();
	
		//Build the first menu.
		menu = new JMenu("A Menu");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		menuBar.add(menu);
	
		//a group of JMenuItems
		
		//XML menu
		menuItem = new JMenuItem("Eksportuj do XML",
		                         KeyEvent.VK_E);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
								KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menu.add(menuItem);
	
		menuItem = new JMenuItem("Importuj z XML", 
								KeyEvent.VK_M);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
								KeyEvent.VK_2, ActionEvent.ALT_MASK));
		menu.add(menuItem);
		//End of XML menu
		
		menu.addSeparator();
	
		menuItem = new JMenuItem("Zamknij",
								KeyEvent.VK_Z);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_X, ActionEvent.ALT_MASK));
		menu.add(menuItem);
		//End of DataBase menu
	
		//Build second menu in the menu bar.
		menu = new JMenu("Ustawienia");
		menu.setMnemonic(KeyEvent.VK_U);
		menuBar.add(menu);
		
		//przycisk do pokazywania buttona "dzisiaj" powracaj¹cego do obecnej daty
		cbMenuItem = new JCheckBoxMenuItem("Poka¿/ukryj przycisk \"Dzisiaj\"");
		cbMenuItem.setState(true);
		cbMenuItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				View.calendar.setTodayButtonVisible(View.todayBtnVisible = !View.todayBtnVisible);				
			}
		});
		menu.add(cbMenuItem);
		
		//Info o programie
		menuItem = new JMenuItem("O programie",
                				KeyEvent.VK_O);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
								KeyEvent.VK_5, ActionEvent.ALT_MASK));
		menu.add(menuItem);
	} //MainMenu constructor END
}
