/**
 * 
 * @author Griffin 
 *
 *
 *Methods here:
 *	isLocationEmpty
 *	getLength
 *	get0Length
 *	generateInitialGrid
 *	placeObject
 *	makeValidMove
 *	printGrid
 *
 *also this grid needs to be reworked to follow MVC. It should be nothing more then a visual representation of the model
 */
public class Grid {
 public char[][] grid;	
	
	public Grid(int[][] size)
	{
		grid = new char[size.length][size[0].length];
		//not sure if I need this constructor or not
	}
	
	public Grid (int x, int y)
	{
		grid = new char[x][y];
	}
	
		
	}



