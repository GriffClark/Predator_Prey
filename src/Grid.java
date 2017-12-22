
public class Grid {
	private int r; //rows
	private int c; //columns
	private char printableGrid[][]; //size to be declared later. Also called printable grid because it will reflect the grid holding actors
	
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
	
	
	public Grid()
	{
		r = 20;
		c = 20;
	}
	

}
