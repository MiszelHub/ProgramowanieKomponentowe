import java.awt.Button;
import java.awt.Checkbox;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class OuterClass implements ActionListener, ItemListener {

	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == MyApplet.outerClassButton)
		{
			MyApplet.oknoKlas.setText("Outer Class1");
		}
	}

	public void itemStateChanged(ItemEvent evt) {
		if(evt.getItemSelectable() == MyApplet.checkbox22)
		{
			MyApplet.oknoKlas.setText("Outer Class2");
		}
	}		

}
