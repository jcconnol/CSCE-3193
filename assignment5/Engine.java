//Engine class for Car
//by John Connolly
//last edited: 8/24/16

public class Engine {
	
	//private variables
	private String description; //description of engine
	private int mpg;			//miles per gallon
	private int max_speed;		//vroom vroom
	
	//Engine constructor
	Engine(String eng_number, int eng_mile, int eng_speed){
		description = eng_number;			//setting variable
		mpg = eng_mile;						//setting variable
		max_speed = eng_speed;				//setting variable
		if(description.length() == 0){ 
			description = "Generic engine";
		}
		if(mpg < 0){
			mpg = 0;
		}
		if(max_speed < 0){
			max_speed = 0;
		}
	}
	
	//public get functions
	public int getMpg(){
		return mpg;
	}
	
	public int getMaxSpeed(){
		return max_speed;
	}
	
	public String getDescription(){
		String full_Description = description + " (MPG: " + mpg + ", Max speed: " + max_speed +")";
		return full_Description;	//returns description... all three variables returned?
	}
}