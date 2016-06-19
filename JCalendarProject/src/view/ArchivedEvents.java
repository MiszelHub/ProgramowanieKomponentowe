package view;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class ArchivedEvents {
	
	private JFrame frame;
	private JPanel contentPanel;
	private JTextPane eventList;
	private Button exitBtn;
	private JScrollPane scroll;
	
	public ArchivedEvents(){
		frame = new JFrame("Wydarzenia Archiwalne");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
		frame.setSize(700, 500);
		frame.setVisible(true);
		frame.setResizable(false);
	
		contentPanel = new JPanel(null);
		contentPanel.setBounds(0, 0, 700, 400);
		frame.add(contentPanel);
		
		eventList = new JTextPane();
		eventList.setBounds(0, 0, 680, 400);
		eventList.setText("wydarzenia archiwalne");
		eventList.setEditable(false);
		
		scroll = new JScrollPane(eventList);
		scroll.setBounds(0, 0, 680, 400);
		contentPanel.add(scroll);
		
		exitBtn = new Button("Zamknij");
		exitBtn.setBounds(contentPanel.getWidth()/2-30, 420, 60, 30);
		contentPanel.add(exitBtn);
		exitBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		
	}

	public JTextPane getEventList() {
		return eventList;
	}

	public void setEventList(JTextPane eventList) {
		this.eventList = eventList;
	}
	
	
}
