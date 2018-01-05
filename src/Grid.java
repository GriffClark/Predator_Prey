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
 */
public class Grid {
	public Actor fullGrid[][];
	public Animal animalGrid[][]; //this is because on this grid there can be collisions 
	
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
		 * this 'layered' grid system works like this. The user sees the printable grid, which is just a matrix of askii characters.
		 * when animals are checking for valid moves or to reproduce, the animal grid is used
		 * when animals want to eat, they check with the fullGrid to see if there is something there to eat
		 */
		

	
	public Grid(int[][] size)
	{
		fullGrid= new Actor[size.length][size[0].length]; //sets equal to size
		animalGrid= new Animal[size.length][size[0].length]; //sets equal to size
	}
	
	public boolean isLocationEmpty(int[][] locationToCheck)
	{
		if (animalGrid[locationToCheck.length][locationToCheck[0].length] == null)
		{
			return true;
		}
		return false;
	}
	
	public int getLength()
	{
		return fullGrid.length; //could have been any just chose fullGrid
	}
	
	public int get0Length()
	{
		return fullGrid[0].length;
	}
	
	public static Grid generateInitialGrid(int algNo, int minnowNo, int sharkNo, int[][] gridSize)
	{
		int everything = algNo + minnowNo + sharkNo;
		Grid newGrid = new Grid (gridSize); //I need to get this grid to hold actors
		
		for(int i = 0; i < algNo; i++)
		{
			Algae al = new Algae();
			Game.everything.add(al);
		}
		
		for (int i = 0; i < minnowNo; i++)
		{
			Minnow min = new Minnow(Game.nutritionMinnowsStartWith); 
			Game.everything.add(min);
		}
		
		for (int i = 0; i < sharkNo; i++)
		{
			Shark shk = new Shark(Game.nutritionSharksStartWith);
			Game.everything.add(shk);
		}
		
		for(int i = 0; i < Game.everything.size(); i++)
		{
			//based on what is in everything<> objects will be added to their appropriate ArrayLists so that the data can be accessed
			Actor actor = Game.everything.get(i);
			switch (Game.everything.get(i).getName())
			{
			case "Minnow": Game.totalMinnows.add((Minnow) actor); //I think that's correct because bob should already be a Minnow
			
			case "Shark": Game.totalSharks.add((Shark)actor);
			
			default: /*if it isn't a shark or a minnow it must be food*/ Game.totalFood.add(actor);
			}
		}
		
		//now to add everything to the grid that will be returned
		
		for(int i = 0; i < Game.everything.size(); i++)
		{
			int randomX = (int)(Math.random() * newGrid.getLength()); //not getLenght - 1 right? because Math.random starts at 0
			int randomY = (int)(Math.random() * newGrid.get0Length());
			
			while(Game.everything.get(i).getLocation() == null)
			{
				int[][] check = new int[randomX][randomY];
				if(newGrid.isLocationEmpty(check) == false) 
				{
					Game.everything.get(i).setLocation(check);
				}
				//if there is nothing at that location add everything(i) onto the grid at that location. Keep looping until you find a valid spot

			}
		}
		
		return newGrid; //this newGrid should be populated
	}
	
	public void placeObject(Actor actor, int[][] location)
	{
		
		if(fullGrid.isLocationEmpty(location) == true) //confused why this is throwing an error at me
		{
			fullGrid[location.length][location[0].length] = actor; 
			
		}
		/*
		 * add a clause that if the actor is an animal add it to the animal grid
		 */
	}
	
	public static boolean makeValidMove(Animal animal, int[][] moveRequest) //need to encorporate speed into this request
	
	//this methods takes an animal that wants to move and checks if the move it wants to make is valid. If it is, it makes the move and returns true. Otherwise, it returns false
	{//this move request will be the result of calling  Animal.genreateMoveRequest()
		if(animalGrid.isLocationEmpty(moveRequest) == true) //so I don't want animalGrid to be static because I want to access the grid being used in Game. How do I do that?
		{
			animal.setLocation(moveRequest);
			return true;
		}
		else //if there is already someone at that location
		{
			return false;
		}
	} //also not sure that this belongs in GameMethods and not in Animal
	
	public void printGrid()
	{
		for(int i = 0; i < fullGrid.length; i++)
		{
			for(int j = 0; j < fullGrid[0].length; j++)
			{
				if(fullGrid[i][j] != null)
				{
					System.out.print(fullGrid[i][j].getAskiiRep() + " ");
				}
				
				else
				{
					System.out.print(". ");
				}
			}
			System.out.println();
		}
	}
}



