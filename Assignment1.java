import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Assignment1 extends JFrame implements KeyListener{
	private static final long serialVersionUID = 1L;
	
	public void keyTyped(KeyEvent e) {
        char key_pressed = e.getKeyChar();
        if(key_pressed == 'h'){
        	System.out.println("hello world");
        }
        if(key_pressed == 'r'){
        	System.out.println("hello world");
        }
        
        if(key_pressed == 'n'){
        	System.out.println("Robbers escaped: ");
        }
        
        if(key_pressed == 's'){
        	System.out.println("hello world");
        }
	}
	
	public Assignment1() throws Exception{
        this.setTitle("Assignment 1");
        this.setSize(400,300);
        this.getContentPane().add(new JButton("Click"));
        this.setVisible(true);
	}

    public static void main(String[] args) throws Exception{
        new Assignment1();
        
        //extra testing
        Component frame = null;
        Object[] options = {"Yes, please", "No way!"};
        JOptionPane.showOptionDialog(frame,
			"Are you sure you want to Quit",
			"A Silly Question",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			null,     //do not use a custom Icon
			options,  //the titles of buttons
			options[0]); //default button title
    }

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
}