//Gas tank class for Car
//by John Connolly
//last edited: 8/24/16

public class GasTank {
	GasTank(int inst_capacity){		//constructor	
		capacity = inst_capacity;	//capacity set to input
		if(capacity < 0){
			capacity = 0;
		}
	}
	
	public int getCapacity(){
		return capacity;
	}
	public double getLevel(){
		return level;
	}
	public void setLevel(double levelIn){
		//sets levelIn equal to level unless out of scope
		level = levelIn;				//set level
		if (level < 0){					//if level is negative
			level = 0;
		}
		if (level > capacity){			//if level is larger than capacity
			level = capacity;
		}
	}
	
	//private initializations
	private int capacity;	//maximum the car can be filled
	private	double level;	//current level
}