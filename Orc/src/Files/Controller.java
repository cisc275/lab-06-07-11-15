package Files;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Do not modify this file without permission from your TA.
 **/

public class Controller {

	private Model model;
	private View view;
	public static Boolean running = true;
	
	public Controller(){
		view = new View();
		model = new Model(view.getWidth(), view.getHeight(), view.getImageWidth(), view.getImageHeight());
	}
	
        //run the simulation
	public void start(){
		for(int i = 0; i < 5000; i++)
		{
			if(running) {
				//increment the x and y coordinates, alter direction if necessary
				model.updateLocationAndDirection();
				//update the view
				view.update(model.getX(), model.getY(), model.getDirect());
			} else {
				while(!running) {
					try {
			            Thread.sleep(1);
			        } catch (InterruptedException e) {
			            e.printStackTrace();
			        }
				}
			}
		}
		
		
	}
}

class ButtonListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Controller.running = !Controller.running;
	}
}