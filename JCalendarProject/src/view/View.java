package view;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JCalendar;

import controllers.ShowEventList;


public class View {
	
	GregorianCalendar date = new GregorianCalendar();
	
	private JCalendar calendar;
	private JFrame frame;
	private JPanel contentPanel, eventPanel, buttonPanel, calendarPanel;
	private JButton btn, userEventBtn;
	private JTextPane eventList;
	private boolean todayBtnVisible = true;
	
	public JCalendar getCalendar() {
		return calendar;
	}

	public void setCalendar(JCalendar calendar) {
		this.calendar = calendar;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public void setContentPanel(JPanel contentPanel) {
		this.contentPanel = contentPanel;
	}

	public JPanel getButtonPanel() {
		return buttonPanel;
	}

	public void setButtonPanel(JPanel buttonPanel) {
		this.buttonPanel = buttonPanel;
	}

	public JPanel getCalendarPanel() {
		return calendarPanel;
	}

	public void setCalendarPanel(JPanel calendarPanel) {
		this.calendarPanel = calendarPanel;
	}

	public JButton getBtn() {
		return btn;
	}

	public void setBtn(JButton btn) {
		this.btn = btn;
	}

	public JButton getUserEventBtn() {
		return userEventBtn;
	}

	public void setUserEventBtn(JButton userEventBtn) {
		this.userEventBtn = userEventBtn;
	}

	public boolean isTodayBtnVisible() {
		return todayBtnVisible;
	}

	public void setTodayBtnVisible(boolean todayBtnVisible) {
		this.todayBtnVisible = todayBtnVisible;
	}


	
	public View()
	{
		System.out.println(date.getTime().toString());
		frame = new JFrame("Kalendarz");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setSize(800, 700);
		frame.setVisible(true);
		MainMenu mainMenu = new MainMenu(this);
		frame.setJMenuBar(mainMenu.getMenuBar());
		
		contentPanel = new JPanel(null);
		contentPanel.setBounds(0, 0, 500, 700);
		frame.add(contentPanel);

		buttonPanel = new JPanel(null);
		buttonPanel.setBounds(0, 0, 500, 50);
//		buttonPanel.setBackground(Color.cyan);
		contentPanel.add(buttonPanel);
		
		eventPanel = new JPanel();
		eventPanel.setBounds(500, -1, 300, 701);
//		eventPanel.setBackground(Color.MAGENTA);
		eventPanel.setBorder(new LineBorder(Color.gray, 1));
		contentPanel.add(eventPanel);
		
		eventList = new JTextPane();
		eventList.setBounds(0, 0, 280, 690);
		eventList.setText(ShowEventList.printEventList());
		eventList.setEditable(false);
		eventPanel.add(eventList);
		
		userEventBtn = new JButton("Dodaj wydarzenie");
		userEventBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddEvent addEvent = new AddEvent(date);
								
			}
		});
		buttonPanel.add(userEventBtn);
		userEventBtn.setSize(userEventBtn.getPreferredSize());
		userEventBtn.setLocation(10, 15);

		
		btn = new JButton("przycisk 1");
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
		btn.setLocation(160, 15);
				
		calendarPanel = new JPanel(null);
		calendarPanel.setBounds(0, 50, 500, 650);
//		calendarPanel.setBackground(Color.gray);
		contentPanel.add(calendarPanel);
		
		calendar = new JCalendar();
		calendarPanel.add(calendar);
		calendar.setBounds(20, 20, calendarPanel.getWidth()-50, calendarPanel.getHeight()-120);
		calendar.setTodayButtonVisible(todayBtnVisible);
		
		calendar.setWeekOfYearVisible(true);
		
//		//Wypisuje dzieñ który zosta³ klikniêty 
//		calendar.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
//		    public void propertyChange(PropertyChangeEvent e) {
//		    	int day = calendar.getDayChooser().getDay();
//		    	int month = calendar.getMonthChooser().getMonth()+1;
//		    	int year = calendar.getYearChooser().getYear();
////				System.out.println(e.getPropertyName()+ ": " + e.getNewValue());
//		    	System.out.println(day+"."+month+"."+year);
//				
//			}
//		});
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			
			public void propertyChange(PropertyChangeEvent arg0) {
				// TODO Auto-generated method stub
			   	int day = calendar.getDayChooser().getDay();
		    	int month = calendar.getMonthChooser().getMonth();
		    	int year = calendar.getYearChooser().getYear();
//				System.out.println(e.getPropertyName()+ ": " + e.getNewValue());
		    	date.set(year, month, day);
		    	System.out.println(date.getTime().toString());
		    	
			}
		});
	}
}
