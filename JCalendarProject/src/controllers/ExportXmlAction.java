package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.View;

class ExportXmlAction implements ActionListener{
	View view;
	SQLConnection sqlConnection;

	public ExportXmlAction(View view, SQLConnection sqlConnection) {
		super();
		this.view = view;
		this.sqlConnection = sqlConnection;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		JFileChooser chooser = new JFileChooser();
//	    FileNameExtensionFilter filter = new FileNameExtensionFilter("xml","xml");
//	    chooser.setFileFilter(filter);
//	    int returnVal = chooser.showSaveDialog(view.getFrame());
//	    if(returnVal == JFileChooser.APPROVE_OPTION) {
//	    	if(!chooser.getSelectedFile().exists()){
//	    		
//	    		File fileToSave = chooser.getSelectedFile();
//	    		
//
//		    	try{
//		    		
//		    		BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave));
//		    		ArrayList<EventBase> list = sqlConnection.getAllEvents().getEventList();
//		    		for(EventBase ev : list){
//		    			writer.write(ev.toString());
//		    			System.out.println(ev.toString());
//		    		}
//		    		fileToSave.createNewFile();
//		    		writer.close();
//		    		
//		    	}
//		    	catch(IOException ee){
//		    		ee.printStackTrace();
//		    	}
//	    	}
//	    	
//	    	
//	    	
//	       System.out.println("You chose to save this file: " +
//	            chooser.getSelectedFile().getAbsolutePath());
//	    }
		XMLActions.setEventRepo(sqlConnection.getAllEvents());
		XMLActions.saveEventsToXML();
		
	}
	
}
