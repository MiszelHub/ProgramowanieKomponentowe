import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import com.toedter.calendar.JCalendar;


public class View {
	static JCalendar calendar;
	static JFrame frame;
	static JPanel contentPanel, buttonPanel, calendarPanel;
	static Button btn, userEventBtn;
	
	public static void init()
	{
		frame = new JFrame("Kalendarz");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setSize(500, 700);
		frame.setVisible(true);
		MainMenu mainMenu = new MainMenu();
		frame.setJMenuBar(mainMenu.getMenuBar());
		
		contentPanel = new JPanel(null);
		contentPanel.setBounds(0, 0, 500, 700);
		frame.add(contentPanel);
		
		buttonPanel = new JPanel(null);
		buttonPanel.setBounds(0, 0, 500, 50);
		buttonPanel.setBackground(Color.cyan);
		contentPanel.add(buttonPanel);
		
		userEventBtn = new Button("Dodaj wydarzenie");
		userEventBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(calendar.getLocale().toString());
				calendar.getDayChooser().setForeground(Color.BLUE);
				calendar.getDayChooser().setMonth(0); //zaczyna sie styczen od 0
				calendar.getMonthChooser().setMonth(0);
								
			}
		});
		buttonPanel.add(userEventBtn);
		userEventBtn.setSize(userEventBtn.getPreferredSize());
		userEventBtn.setLocation(10, 15);

		
		btn = new Button("przycisk 1");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(calendar.getLocale().toString());
				calendar.getDayChooser().setForeground(Color.BLUE);
				calendar.getDayChooser().setMonth(0); //zaczyna sie styczen od 0
				calendar.getMonthChooser().setMonth(0);
								
			}
		});
		buttonPanel.add(btn);
		btn.setSize(btn.getPreferredSize());
		btn.setLocation(140, 15);
				
		calendarPanel = new JPanel(null);
		calendarPanel.setBounds(0, 50, 500, 650);
		calendarPanel.setBackground(Color.gray);
		contentPanel.add(calendarPanel);
		
		calendar = new JCalendar();
		calendarPanel.add(calendar);
		calendar.setBounds(20, 20, calendarPanel.getWidth()-50, calendarPanel.getHeight()-120);
		calendar.setTodayButtonVisible(true);
		
		calendar.setWeekOfYearVisible(true);
		
		//Wypisuje dzieñ który zosta³ klikniêty 
		calendar.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
		    public void propertyChange(PropertyChangeEvent e) {
				 System.out.println(e.getPropertyName()+ ": " + e.getNewValue());
				
			}
		});
	}
}
