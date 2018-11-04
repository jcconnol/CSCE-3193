//Car class for Car
//by John Connolly
//last edited: 8/24/16

import static java.lang.Math.sqrt;

public class Car {
	//Car constructor
	Car(String overall_descrip, int capacity, Engine reference){
		my_GasTank = new GasTank(capacity);
		car_descr = overall_descrip;
		my_Engine = reference;
		if(car_descr.length() == 0){
			car_descr = "Generic car";		//setting cars description to generic car if empty
		}
		if(reference == null){
			my_Engine = new Engine("",0,0);	//if no engine object then new engine made with empty string and zeros
		}
	}
	
	//implemented functions
	public String getDescription(){
		//formats the full car description string and returns it
		String full_car_descr = car_descr + " (engine: " + my_Engine.getDescription() +"), fuel: " + String.format("%.2f", getFuelLevel()) + "/" + my_GasTank.getCapacity() + " location: (" + X + "," + Y + ")";
		return full_car_descr;		//returns engine description layed out in variable
	}
	public int getX(){
		return X;
	}
	public int getY(){
		return Y;
	}
	public double getFuelLevel(){
		return my_GasTank.getLevel();	//returns Level
	}
	public int getMPG(){
		return my_Engine.getMpg();		//returns mpg
	}
	public void fillUp(){
		my_GasTank.setLevel(my_GasTank.getCapacity());	//set level to capacity
	}
	public int getMaxSpeed(){
		return getMaxSpeed();
	}
	public double drive(int distance, double xRatio, double yRatio){
		//initializations
		double slope = 0;			//finding the slope
		int holder_X = 0;
		int holder_Y = 0;
		
		//assuming level and capacity are in gallons, distance is in miles and car is starting at (0,0).
		double possible_Distance = getFuelLevel() * my_Engine.getMpg();	//mpg * gallons = miles
		
		if (possible_Distance < distance){
			System.out.println("Ran out of gas after only going " + possible_Distance + " miles.");
		}
		else{
			possible_Distance = distance;
		}
		
		if(xRatio != '0'){
			slope = yRatio / xRatio;	//divide by zero exception?
		}
		else{
			slope = 0;
		}
		
		my_GasTank.setLevel(getFuelLevel() - (possible_Distance / getMPG()));
		
		//finding location setting X and Y respectively
		if (xRatio >= 0){
			holder_X = (int) (possible_Distance / (sqrt(1 + (slope *slope)))) + X;
			holder_Y = (int) ((slope * possible_Distance) / (sqrt(1 + (slope * slope)))) + Y;
		}
		
		else if(xRatio < 0){
			holder_X = (int) ((-1 * possible_Distance) / (sqrt(1+(slope * slope)))) + X;
			holder_Y = (int) ((-1 * slope * possible_Distance) / (sqrt(1+(slope * slope)))) + Y;
		}
		
		X = holder_X;
		Y = holder_Y;
		
		String.format("%.2f", possible_Distance);	//shows two decimal places
		return possible_Distance;		//returns double of number of miles driven
	}
	
	//private variables
	private String car_descr;	//description of car
	private int X;				//coordinate X value
	private int Y;				//coordinate Y value
	private GasTank my_GasTank;	//instance of gas tank variable?
	private Engine my_Engine;	//instance of Engine variable?
	
}