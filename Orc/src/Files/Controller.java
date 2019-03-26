package Files;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


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

class KeyPress implements KeyListener {

	public void keyTyped(KeyEvent e) {
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if(Model.getAction() == "run") {
			if (e.getKeyChar() == 'j')
				Model.setAction("jump");
			if (e.getKeyChar() == 'f')
				Model.setAction("fire");
		}
	}
}