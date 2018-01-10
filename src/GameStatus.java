import java.util.ArrayList;

/**
 * 
 * @author Griffin

 */
public class GameStatus {
	
	public ArrayList<Actor> actors;

	  //these will be recorded and data can be pulled from here

	
	public GameStatus(int step, ArrayList <Actor> actors) {
		
		this.actors = actors; //this works...?
		
		// TODO Auto-generated constructor stub
	}



	public int getNumberOfSpecificActor(String specification)
	{
		int counter = 0;
		for(int i = 0; i < actors.size(); i++)
		{
			if(actors.get(i).getName().equals(specification))
			{
				counter++;
			}
		}
		
		return counter;
	}
	
	
	
	  
	  
	  //insert all those goddam getter methods here

}
