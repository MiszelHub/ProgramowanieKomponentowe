package view;

import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import com.toedter.components.JSpinField;

public class UpdateEvent extends AddEvent {
	
	protected JSpinField chooseId;
	protected JLabel chooseIdLabel;
	protected JButton fillData;

	public UpdateEvent(GregorianCalendar calendarDate) {
		super(calendarDate);
		
		
		frame.setSize(420,500);
		
		chooseIdLabel = new JLabel("ID wydarzenia do edycji");
		chooseIdLabel.setSize(200, 40);
		chooseIdLabel.setLocation(20, 400);
		contentPanel.add(chooseIdLabel);
		
		chooseId = new JSpinField();
		chooseId.setMinimum(0);
		chooseId.setSize(60, 20); 
		chooseId.setLocation(170, 410);
		contentPanel.add(chooseId);
		
		fillData = new JButton("Wczytaj wydarzenie");
		fillData.setSize(fillData.getPreferredSize());
		fillData.setLocation(250, 405);
		contentPanel.add(fillData);
		
		
	}
	
	public void setFillEventDataBtn(ActionListener listener){
		fillData.addActionListener(listener);
	}

	public JSpinField getChooseId() {
		return chooseId;
	}

	public void setChooseId(JSpinField chooseId) {
		this.chooseId = chooseId;
	}

	public JLabel getChooseIdLabel() {
		return chooseIdLabel;
	}

	public void setChooseIdLabel(JLabel chooseIdLabel) {
		this.chooseIdLabel = chooseIdLabel;
	}

	public JButton getFillData() {
		return fillData;
	}

	public void setFillData(JButton fillData) {
		this.fillData = fillData;
	}

	
	//getters and setters
	
	
}
