
public class SpriteMover implements Runnable{
	private Model model;
	private View view;
	
	SpriteMover(Model model_Move, View view_Move){
		 model = model_Move;
		view = view_Move;
	}
	
	public void run(){
		while(true){
			
			model.updateScene(view.getWidth(), view.getHeight());
			view.repaint();			//is this right
			
			try{
	            //sleeping for 2 milliseconds
	            Thread.sleep(2);
	        }
			catch(InterruptedException e){
	            //exception for if thread doesn't sleep
				System.out.println("Program Could Not Sleep");
	        }
		}
	}
}
