import java.awt.Graphics;
import java.util.Random;

public class RobberCar extends Car{
	
	private int xRatio;
	private int yRatio;
	private boolean captured = false;
	private boolean escaped = false;
	public static int escaped_Number = 0;
	public static int captured_Number = 0;
	
	RobberCar(){
		super("swag", 5000, new Engine("engine stuff", 4, 200), "red-car.jpg");
		fillUp();
		Random randX = new Random();
		Random randY = new Random();
		xRatio = randX.nextInt(11) + -5;	//makes random variables for x and y
		yRatio = randY.nextInt(11) + -5;
	}
	
	public boolean hasEscaped(){
		return escaped;
	}
	
	public void resetNum(){
		captured_Number = 0;
		escaped_Number = 0;
	}
	
	public void updateState(int height, int width){
		if(getX() >= height || getX() < 0){
			escaped =  true;
			escaped_Number = escaped_Number+1;
		}
		
		if(getY() >= width || getY() < 0){
			escaped =  true;
			escaped_Number = escaped_Number+1;
		}
		
		drive(4,xRatio, yRatio);
	}
	
	public void updateImage(Graphics g){
		super.updateImage(g);
	}
	
	public void captured(){
		if(!captured){
			xRatio = 0;
			yRatio = 0;
			setImage("jail.jpg");
			captured = true;
			captured_Number = captured_Number + 1;
		}
	}
	
	public boolean isCaptured(){
		return captured;
	}
}
