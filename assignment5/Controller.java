
import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

class Controller implements MouseListener, KeyListener {
	
    Model model;
    View view;
    private boolean holder = true;
    
    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
        //view.addKeyListener(this);
    }
    
	public void update(Graphics g) {
        model.update(g);
    }

    public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			// Gets here is left mouse button was clicked
			if(holder == true){
				model.addSprite(e.getPoint().x, e.getPoint().y);
				holder = false;
			}
			else{
				model.addSprite(300, 300);
				holder = true;
			}
			view.repaint();
		} else if (SwingUtilities.isRightMouseButton(e))  {
			// Gets here if right mouse button was clicked
			model.updateScene(view.getWidth(), view.getHeight());
			view.repaint();
		}
    }    
    
	public void keyTyped(KeyEvent e) {
        char key_pressed = e.getKeyChar();
        if(key_pressed == 'h'){
        	System.out.println("hello world");
        }
        if(key_pressed == 'r'){
        	model.initialize();
        	view.repaint();
        }
        
        if(key_pressed == 'n'){
        	System.out.println("Robbers escaped: " + RobberCar.escaped_Number + "		Robbers Captured: " + RobberCar.captured_Number);
        }
        
        if(key_pressed == 's'){
        	(new Thread(new SpriteMover(model, view))).start();
        	
        }
	}
	//Other mouse pressed stuff
    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }
    //Other key stuff
    public void keyPressed(KeyEvent e) {	}
    public void keyReleased(KeyEvent e) {	}


    public static void main(String[] args) throws IOException, Exception{
        new Controller();
    }

}