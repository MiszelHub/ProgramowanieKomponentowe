
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.toedter.calendar.JCalendar;

public class Program {
	
	static JCalendar calendar;
	
	public static void main(String[] args) {

		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		
		ActionListener actionBtn = new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(calendar.getLocale().toString());
				calendar.getDayChooser().setForeground(Color.BLUE);
				calendar.getDayChooser().setMonth(0); //zaczyna sie styczen od 0
				calendar.getMonthChooser().setMonth(0);
								
			}
		};

		JFrame frame = new JFrame("Kalendarz");
		frame.addWindowListener(l);
		frame.setSize(500, 700);
		JPanel pnlCalendar = new JPanel(null);
		frame.add(pnlCalendar);
		
//		JTextFieldDateEditor spin = new JTextFieldDateEditor();
//		pnlCalendar.add(spin);
//		spin.setBounds(100, 20, 200, 200);
		
		
		Button btn = new Button("przycisk 1");
		btn.addActionListener(actionBtn);
		pnlCalendar.add(btn);
		btn.setBounds(40, 25, 70, 25);
		
//		JDateChooser chooser = new JDateChooser();
//		pnlCalendar.add(chooser);
//		chooser.setBounds(20, 60, 100, 40);
		
		
		calendar = new JCalendar();
		pnlCalendar.add(calendar);
		calendar.setBounds(20, 60, frame.getWidth()-50, frame.getHeight()-120);
		calendar.setTodayButtonVisible(true);
		
		calendar.setWeekOfYearVisible(true);
//		calendar.setWeekdayForeground(Color.blue);    //zmienia kolor nazw dni tygodnia 
//		frame.pack();
		
//		frame.setBounds(0, 0,
//				(int) frame.getPreferredSize().getWidth() + 200, (int) frame
//						.getPreferredSize().getHeight() + 250);
		frame.setVisible(true);
	}

}
