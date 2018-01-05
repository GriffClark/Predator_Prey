import java.util.Scanner;

/**
 * 
 * @author Griffin 
 *
 *
 *Methods here:  note that all methods here should be static
 *	getDistance
 *	record
 */
public class GameMethods {
	
	/*
	 * Holds the methods that Game will use
	 * pause/play
	 * speed up
	 * stop
	 * get info (displays no. of animals)
	 * reset
	 * customize grid
	 * cusomise animals
	 */
	
	public static int getDistance(Actor a, Actor b)
	{
		//returns the distance of two actors from each other
		double dis;
		int x1 = a.getX();
		int y1 = a.getY();
		int x2 = b.getX();
		int y2 = b.getY();
		
		dis=Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
		//double check my math
		
		int valueToBeReturned = (int)(dis + 0.5); //this should take care of rounding properly too
		return valueToBeReturned;
		 
	}
	
	public static Grid getNewGrid()
	{
		
		/**
		 * will build the initial grid based around user input. We could also make a defualt grid that uses random numbers, too. But this gives us more control for testing
		 */
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How big would you like your grid? 'x''y'");
		
		int x = keyboard.nextInt();
		int y = keyboard.nextInt();
		int[][] gridSize = new int [x][y];
		
		System.out.println("How many algae do you want?"); //or should I automatically make the number of algae a function of the number of minnows?
		
		int algNo = keyboard.nextInt();
		
		if(algNo >= x * y)
		{
			//error
			System.out.println("Unhandled error about someone putting to much shit in the grid");
		}
		
		System.out.println("how many minnows do you want?"); //should we make it so that the number of minnows has to be less then the number of algae?
		
		int minnowNo = keyboard.nextInt();
		
		if(minnowNo >= x * y)
		{
			//error
			System.out.println("Unhandled error about someone putting to much shit in the grid");
		}
		
		System.out.println("how many sharks do you want?");
		
		int sharkNo = keyboard.nextInt();
		
		if(sharkNo >= x * y)
		{
			//error
			System.out.println("Unhandled error about someone putting to much shit in the grid");
		}
		
		Grid grid = Grid.generateInitialGrid(algNo, minnowNo, sharkNo, gridSize);
		return grid;
	}
	
	public static void start()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("how many steps would you like to see?");
		int input = keyboard.nextInt(); //input will be re-used. Steps will be a constant value 
		Game.steps = input;
		
		//is this the correct way of going about starting?
	}
	
	

	

}
