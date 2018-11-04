import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


class Sprite
{
	//private String jpgName;
	private int locationX;
	private int locationY;
	private Image image;

	public Sprite(String jpgName)
	{
		setImage(jpgName);
		locationX = 0;
		locationY = 0;
	}
	
	public int getX() {	return locationX; }
	public int getY() {	return locationY; }
	public void setX(int x) { locationX = x; }
	public void setY(int y) { locationY = y; }
	
	public void setImage(String imagePath) {
		try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
	}
	public Image getImage() { return image; }	
	
	public void updateImage(Graphics g) {
        //Move the sprite with locations x and y
		g.drawImage(getImage(), locationX, locationY, 60, 60, null);
	}
	
	public void updateState(int height, int width){
		
	}
	
	public void updateScene(int x, int y){
		
	}
	
	public boolean overlaps(Sprite s){
		//Make two rectangle objects because they have their own intersects method. Makes it easy.
		
		Rectangle this_S = new Rectangle(locationX, locationY, 60, 60);
		Rectangle incoming_S = new Rectangle(s.getX(), s.getY(), 60, 60);
		
		return incoming_S.intersects(this_S);
	}
}
