package view;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AboutProgram {
	private JFrame frame;
	private JPanel contentPanel;
	private Button exitBtn;
	private JTextArea txt;
	private String about = "Program stworzony przez\nKonrad Nojman\nMicha³ Andrzejczak";
	
	public AboutProgram(){
		frame = new JFrame("Kalendarz");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setSize(300, 400);
		frame.setVisible(true);
		
		contentPanel = new JPanel(null);
		contentPanel.setBounds(0, 0, 300, 400);
		frame.add(contentPanel);
		
		txt = new JTextArea(about);
		txt.setEditable(false);
		txt.setAlignmentX(1);
		txt.setBounds(50, 50, 200, 200);
		contentPanel.add(txt);
		
		exitBtn = new Button("Zamknij");
		exitBtn.setBounds(120, 250, 60, 30);
		contentPanel.add(exitBtn);
		exitBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
	} //end of constructor
}
