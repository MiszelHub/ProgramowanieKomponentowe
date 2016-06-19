package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import controllers.*;

import javax.swing.*;

/**
* this class represents a main menu of the application
*
*
*/
public class MainMenu extends JMenuBar{
	private static final long serialVersionUID = -1252406631918788989L;

	//Where the GUI is created:
	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem exportXml, importXml, close, aboutProgram;
	JRadioButtonMenuItem rbMenuItem;
	JCheckBoxMenuItem cbMenuItem;

	public JMenuBar getMenuBar(){
		return menuBar;
	}

	/**
	 * constructor needs a view formal parameter
	 * @param view
	 */
	MainMenu(final View view){
		//Create the menu bar.
		menuBar = new JMenuBar();

		//Build the first menu.
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_M);
		menu.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		menuBar.add(menu);

		//a group of JMenuItems

		//XML menu
		exportXml = new JMenuItem("Eksportuj do XML",
		                         KeyEvent.VK_E);
		exportXml.setAccelerator(KeyStroke.getKeyStroke(
								KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menu.add(exportXml);
		exportXml.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
//				XMLActions.saveEventsToXML();
			}
		});

		importXml = new JMenuItem("Importuj z XML",
								KeyEvent.VK_M);
		importXml.setAccelerator(KeyStroke.getKeyStroke(
								KeyEvent.VK_2, ActionEvent.ALT_MASK));
		menu.add(importXml);
		importXml.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
//				XMLActions.loadEventsFromXML();
				System.out.println("load XML");
			}
		});
		//End of XML menu

		menu.addSeparator();

		close = new JMenuItem("Zamknij",
								KeyEvent.VK_Z);
		close.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_X, ActionEvent.ALT_MASK));
		menu.add(close);
		close.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
			}
		});
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
				view.setTodayBtnVisible(!view.isTodayBtnVisible());
				view.getCalendar().setTodayButtonVisible(view.isTodayBtnVisible());
			}
		});
		menu.add(cbMenuItem);

		//Info o programie
		aboutProgram = new JMenuItem("O programie",
                				KeyEvent.VK_O);
		aboutProgram.setAccelerator(KeyStroke.getKeyStroke(
								KeyEvent.VK_5, ActionEvent.ALT_MASK));
		menu.add(aboutProgram);
		aboutProgram.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				AboutProgram about = new AboutProgram();

			}
		});
	} //MainMenu constructor END

	public void setExportXmlBtn(ActionListener listener){
		exportXml.addActionListener(listener);
	}

	public void setImportXmlBtn(ActionListener listener){
		importXml.addActionListener(listener);
	}
}
