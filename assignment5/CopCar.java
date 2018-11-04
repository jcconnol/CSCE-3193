import java.awt.Graphics;
import java.util.Random;


public class CopCar extends Car{
	private static int xRatio;
	private static int yRatio;
	private int xDirection = 1;
	private int yDirection = 1;
	private boolean direct;
	
	CopCar()
	{
		super("swag", 5000, new Engine("engine stuff", 2, 200), "cop-car.jpg");
		direct = false;
		fillUp();
		Random randX = new Random();
		Random randY = new Random();
		xRatio = randX.nextInt(11) + -5;
		yRatio = randY.nextInt(11) + -5;
	}
	       
	//fix this
	public void updateState(int height, int width)
	{
		if(direct == false)
		{
			drive(2, xRatio * xDirection, yRatio * yDirection);
			if(getX() + 60 >= width || getX() < 0){
				xDirection *= -1;
			}
			if(getY() + 60 >= height || getY() < 0){
				yDirection *= -1;
			}
		}
		else
		{
			drive(2, xRatio, yRatio);
		}
		
	}
	
	public void updateImage(Graphics g){
		//shows but doesn't drive
		super.updateImage(g);
	}
}
