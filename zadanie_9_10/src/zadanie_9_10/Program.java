package zadanie_9_10;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.plaf.FileChooserUI;

public class Program  implements ActionListener{

	  JTextArea output;
	    JScrollPane scrollPane;
	    static JFrame frame ;
	    JMenuBar menuBar;
	     JMenu menu;
	     JMenuItem menuItem;
	     JRadioButtonMenuItem rbMenuItem;
	     JCheckBoxMenuItem cbMenuItem;
	     ComboBox mycombobox;
	     JFileChooser filechooser;
public Program(){
    filechooser = new JFileChooser();
	filechooser.addActionListener(this);
}
	     public JMenuBar createMenuBar() {


		        //Create the menu bar.
		        menuBar = new JMenuBar();

		        //Build the first menu.
		        menu = new JMenu("A Menu");
		        menu.setMnemonic(KeyEvent.VK_A);
		        menu.getAccessibleContext().setAccessibleDescription(
		                "The only menu in this program that has menu items");
		        menuBar.add(menu);

		        //a group of JMenuItems
		        menuItem = new JMenuItem("Exit",
		                                 KeyEvent.VK_T);

		        menuItem.addActionListener(this);
		        menu.add(menuItem);

		       // ImageIcon icon = createImageIcon("middle.gif");
		        menuItem = new JMenuItem("Open any file");
		        menuItem.addActionListener(this);
		        menuItem.setMnemonic(KeyEvent.VK_B);
		        menu.add(menuItem);


		        return menuBar;
		    }
	     public void showDialog(){




	     }

	private static void createAndShowGUI() {
	        //Create and set up the window.
	        frame = new JFrame("HelloWorldSwing");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        //Add the ubiquitous "Hello World" label.
	        JLabel label = new JLabel("Hello World");
	        frame.getContentPane().add(label);


	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	        //Create and set up the content pane.
	        Program demo = new Program();


	        frame.setJMenuBar(demo.createMenuBar());
	        frame.setContentPane(demo.createContentPane());
	        frame.add(demo.mycombobox = new ComboBox());



	        //Display the window.
	        frame.setSize(450, 260);
	        frame.setVisible(true);
	    }
	public Container createContentPane() {
        //Create the content-pane-to-be.
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setOpaque(true);

        //Create a scrolled text area.
        output = new JTextArea(5, 30);
        output.setEditable(false);
        scrollPane = new JScrollPane(output);

        //Add the text area to the content pane.
        contentPane.add(scrollPane, BorderLayout.CENTER);

        return contentPane;
    }


    // Returns just the class name -- no package info.
    protected String getClassName(Object o) {
        String classString = o.getClass().getName();
        int dotIndex = classString.lastIndexOf(".");
        return classString.substring(dotIndex+1);
    }

	public static void main(String[] args) {
	    //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==menu.getItem(0))
		{
			frame.dispose();
		}
		else if(e.getSource() == menu.getItem(1))
		{

			filechooser.showOpenDialog(frame);
			File file = filechooser.getSelectedFile();
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.open(file);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}



		}

	}

}
