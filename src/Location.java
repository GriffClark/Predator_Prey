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
	}
	
	public Location (int[][] location) //do I want to accept int[][] or should I force xy nomenclature?
	{
		this.x = location.length;
		this.y = location[0].length;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }

}


