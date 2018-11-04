import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;

class Model
{
    private ArrayList<Sprite> sprite = new ArrayList<Sprite>();
    private int imageNumber = 0;
    
    Model() throws IOException {
    	Bank first_Bank = new Bank();
    	sprite.add(first_Bank);
    }

    public void update(Graphics g) {
    	synchronized(sprite){
	    	for(int i = 0; i < sprite.size(); i++){
	    		sprite.get(i).updateImage(g);
	    	}
    	}
    }
    
    public void addSprite(int X, int Y){
    	//String imageName = "cop-car.jpg";
    	synchronized(sprite){
    		Car model_Car;
	    	if(imageNumber == 0){
	    		model_Car = new CopCar();		//makes every other car a cop car
	    		imageNumber = 1;
	    	}
	    	
	    	else{
	    		model_Car = new RobberCar();		//makes every other car a robbercar
	    		imageNumber = 0;
	    	}
	    	
	    	sprite.add(model_Car);
	    	sprite.get(sprite.size()-1).setX(X);
	    	sprite.get(sprite.size()-1).setY(Y);
    	}
    }
    
    public void updateScene(int width, int height){
    	//window_Height = height;
    	//window_Width = width;
    	//checks if robber and cop overlaps.
	    synchronized(sprite){
	    	for(int robs = 0; robs < sprite.size(); robs++){
	    		sprite.get(robs).updateState(height, width);
	    		for(int cops = 0; cops < sprite.size(); cops++){
	    			if((sprite.get(robs) instanceof RobberCar) && (sprite.get(cops) instanceof CopCar)){
	    				if(sprite.get(robs).overlaps(sprite.get(cops)) && ((RobberCar)sprite.get(robs)).isCaptured() != true){
	    					((RobberCar)sprite.get(robs)).captured();    					
	    				}
	    			}
	    		}
	    	}
	    }
    	//checks escaping of RobberCar and deletes it if it has escaped
    	
    	synchronized(sprite){
	    	java.util.Iterator<Sprite> esc = sprite.iterator();
	    	while(esc.hasNext()){
	    		Sprite s = esc.next();
	    		if((s instanceof RobberCar) && ((RobberCar) s).hasEscaped() == true){
	    			esc.remove();
					System.out.println("I'm Free");
	    		}
	    		
	    	}
    	}//end of synchronized
    }//scene function end
    
    public void initialize(){
    	synchronized(sprite){
    		((RobberCar)sprite.get(2)).resetNum();
    		sprite.removeAll(sprite);
	    	Bank first_Bank = new Bank();
	    	sprite.add(first_Bank);
    	}
    }//end of initialize function
    
}//model class end














