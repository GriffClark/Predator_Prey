
public class Grid {
	private int r; //rows
	private int c; //columns
	public static Actor fullGrid[][];
	public static Animal animalGrid[][]; //this is because on this grid there can be collisions 
	private static char printableGrid[][]; //size to be declared later. Also called printable grid because it will reflect the grid holding actors
	
	/*Grid needs:
	 * Consider creating a JFrame to put this in instead of console output (if we have time)
	 * A way to display images to the console/output method
	 * Needs to hold the location of each Animal and other object (rocks, grass, whatever)
	 * A way to be custom set by the user
	 * display elapsed time
	 */
	
	/**
	 * Visual rep:
	 * Background 
	 * Animals and food images
	 * Play pause help buttons (we need to figure out where to put the help menu)
	 * 
	 */
	
	/**
	 * Because the char representation of Animals and Food is not final I am going to have the printableGrid generate those instead of pulling them from the actors
	 */
	
	
	public Grid(int r, int c)
	{
		fullGrid = new Actor[r][c];
		animalGrid = new Animal[r][c];
		printableGrid = new char[r][c];
		/**
		 * this 'layered' grid system works like this. The user sees the printable grid, which is just a matrix of askii characters.
		 * when animals are checking for valid moves or to reproduce, the animal grid is used
		 * when animals want to eat, they check with the fullGrid to see if there is something there to eat
		 */
		
	}
	
	public static boolean isLocationEmpty(int[][] locationToCheck)
	{
		if (animalGrid[locationToCheck.length][locationToCheck[0].length] == null)
		{
			return true;
		}
		return false;
	}
	

}
