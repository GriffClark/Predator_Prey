import java.util.ArrayList;

/**
 * 
 * @author Griffin 
 *the purpose of this class is to hold the location of an actor
 *from this location, a visual representation will be generated in the form of a 2d array
 *the location is not stored in the grid in order to follow MVC (Model View Controller) format, with the main method in game class being the model, the grid being the view, and the game class being the controller (I think)
 *edits need to be made in order to ensure that this method is followed properly to reduce bugs and make the program more streamline
 */
public class Location {
	protected int x;
	protected int y;
	
	public Location(int x, int y)
	{
		this.x = x;
		this.y = y;
		checkValidLocation(x,y);
	}
	
	public boolean checkValidLocation(int x, int y)
	{
		while (x > Model.gridSize.length || y > Model.gridSize[0].length)
		{
			this.x--;
			this.y--;
			//there could also be bugs here. Need a way to say ... "pick an empty valid location"
		}
		
		ArrayList<Actor> localActors = new ArrayList<Actor>();
		boolean isLocationEmpty = true;
		for(int t = 0; t < GameMethods.getActorArrayList().size(); t++)
		{
			localActors.add((Actor)GameMethods.getActorArrayList().get(t));
			//might as well create a local copy while searching if the location is occupied
			if(localActors.get(t).getX() == x || localActors.get(t).getY() == y)
			{
				isLocationEmpty = false;
			}
		}
		
		return isLocationEmpty;

		
	}
	
	public static Location generateAtValidLocation()
	{
		int rows = Model.gridSize.length;
		int cols = Model.gridSize[0].length;
		int randomX = (int)(Math.random() * rows);
		int randomY = (int)(Math.random() * cols);
		
		ArrayList<Actor> localActors = new ArrayList<Actor>();
		
		for(int i = 0; i < GameMethods.getActorArrayList().size(); i++)
		{
			localActors.add((Actor) GameMethods.getActorArrayList().get(i));
		}
		Location finalLocation = null;
		Location testLocation = new Location(randomX, randomY );
		boolean isTestLocationValid = true;
		
		for(int i = 0; i < localActors.size(); i++)
		{
			if(testLocation == localActors.get(i).getLocation())
			{
				isTestLocationValid = false;
			}
			
		}
		
		if(isTestLocationValid == true)
		{
			testLocation = finalLocation;
		}
		return finalLocation;
		
	}
	
	public Location (int[][] location) //do I want to accept int[][] or should I force xy nomenclature?
	{
		this.x = location.length;
		this.y = location[0].length;
		checkValidLocation(x,y);
	}
	
	public int getX() { return x; }
	public int getY() { return y; }

}


