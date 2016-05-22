package zadanie_9_10;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

public class Program {

	  JTextArea output;
	    JScrollPane scrollPane;

	private static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("HelloWorldSwing");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        //Add the ubiquitous "Hello World" label.
	        JLabel label = new JLabel("Hello World");
	        frame.getContentPane().add(label);

	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	        //Create and set up the content pane.
	        Program demo = new Program();
	        menu m = new menu();
	        frame.setJMenuBar(m.createMenuBar());
	        frame.setContentPane(demo.createContentPane());
	        frame.add(new ComboBox());

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

}
