import java.awt.Graphics;

public class Bank extends Sprite{
	//always located at 300,300
	public Bank(){
		super("bank.png");
		setX(300);
		setY(300);
	}
	
	public void updateImage(Graphics g) {
		//calls update from super class Sprite
		super.updateImage(g);
	}
}
