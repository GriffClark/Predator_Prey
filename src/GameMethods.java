import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Griffin 
 *
 *
 *Methods here:  note that all methods here should be static
 */
public class GameMethods {
	
	public static Location aquireIntercept(Location targetLocation,  int speed, Location myLocation)
	{
		//neeed to make sure that this method is only called in a valid context, because this cannot handle errors
		int numberOfTries = 0;
		while(true) //will loop until it finds a valid location
		{
			Location testLocation = GameMethods.generateValidLocation();
			if(GameMethods.getDistance(targetLocation, testLocation) <= 2)
			{
				if(GameMethods.getDistance(targetLocation, myLocation)<= speed )
				{
					return testLocation;
				}
				else
				{
					numberOfTries++;
					if(numberOfTries > 50)
					{
						return null; //prevents an infinate loop
					}
				}
			}
		}
		
	}
	public static int getDistance(Location a, Location b)
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
	
	//this needs to be moved into model
	public static Location generateValidLocation()
	{
		int rows = Model.singleModel.gridSize.length; 
		int cols = Model.singleModel.gridSize[0].length;
		int randomX = (int)(Math.random() * rows);
		int randomY = (int)(Math.random() * cols);
		
		ArrayList<Actor> localActors = new ArrayList<Actor>();
		int numberOfActors = GameMethods.getActorArrayList().size();
		for(int i = 0; i < numberOfActors; i++)
		{
			localActors.add((Actor) GameMethods.getActorArrayList().get(i));
		}
		Location finalLocation = null;
		
		while(finalLocation == null)
		{
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
				finalLocation = testLocation;
			}
			
		}


		
		
		return finalLocation;
		
	}
	
	public static ArrayList<Actor> getActorArrayList()
	{
		Model localModel = Model.getGameModel();
		ArrayList<Actor> localActors = new ArrayList<Actor>();
		
		for (int i = 0; i < Model.getActorsSize(); i++)
		{
			localActors.add((Actor) localModel.copyOfActors().get(i));
		}	
		
		return localActors;
	}

	
	public static void moveToRandomLocation(Location location, int speed)
	{
		boolean foundValidLocation = false;
		do
		{
			Location randomLocation = GameMethods.generateValidLocation();
			if(GameMethods.getDistance(location, randomLocation) <= speed)
			{
				location = randomLocation;
			}
		}while(foundValidLocation == false);
	}
	
	
	public static void start() throws InterruptedException, IOException
	{
		/**
		 * I think the runtime error here is that singleModel.actors<> or whatever its called isnt initializing until I put things into it
		 */
		Model.getGameModel();  // make sure the model is initialized
		Scanner keyboard = new Scanner(System.in);
		System.out.println("how many steps would you like to see?");
		int input = keyboard.nextInt(); //input will be re-used. Steps will be a constant value 
		if(input == 666)
		{
			singleModel.desiredSteps = 50;
			singleModel.numberOfMinnows = 40;
			singleModel.numberOfSharks = 20;
			singleModel.numberOfAlgae = Model.numberOfMinnows *2; //just an idea not a solution
		}
		else
		{
			Model.desiredSteps = input;
			//we should add a defualt number of sharks and minnows to start with
			System.out.println("how many sharks would you like to start with?");
			int sharkStart = keyboard.nextInt();
			System.out.println("how many minnows do you want to start with?");
			int minnowStart = keyboard.nextInt();
			System.out.println("One second while the game initializes...");
			Thread.sleep(500); //half a second
			singleModel.numberOfMinnows = minnowStart;
			singleModel.numberOfSharks = sharkStart;
			singleModel.numberOfAlgae = minnowStart *2; //just an idea not a solution
		}
		
		System.out.println("..."); //getting stuck here not sure why. Trying a different solution with minnows but cannot come up with a desicive reason why this keeps happening
		for(int i = 0; i < singleModel.numberOfMinnows; i++)
		{
			Location validLocation = GameMethods.generateValidLocation();
			Minnow m = new Minnow(validLocation, Model.nutritionMinnowsStartWith);
			Controller.actorsThatNeedAHome.add(m);
			System.out.println("minnow added");
			
		}
		for(int i = 0; i < singleModel.numberOfSharks; i++)
		{
			Location validLocation = GameMethods.generateValidLocation();
			Shark s = new Shark(validLocation, Model.nutritionSharksStartWith);
			Controller.actorsThatNeedAHome.add(s);
			System.out.println("shark added");
		}
		for(int i = 0; i < singleModel.numberOfAlgae; i++)
		{
			Location validLocation = GameMethods.generateValidLocation();
			Algae al = new Algae(validLocation, 5);
			Controller.actorsThatNeedAHome.add(al);
			System.out.println("algae added");
		}
		Thread.sleep(500);
		System.out.println("Model has been initialized!");
		
		//is this the correct way of going about starting?
	}
	
	public static ArrayList<Actor> getActorOfSpecifiedType (String specification)
	{ //based on the current status of the game gets you all actors of a specific type
		GameStatus currentStatus = Model.getCurrentStatus();
		ArrayList<Actor> localCopyOfAllActors = currentStatus.actors; //is this a valid way of copying it? To tired to figure it out
		ArrayList<Actor> specifiedActors = new ArrayList<Actor>();
		
		int actorSize = Model.getActorsSize();
		for(int i = 0; i < actorSize; i++)
		{
			if(localCopyOfAllActors.get(i).getName().equals(specification))
			{
				specifiedActors.add(localCopyOfAllActors.get(i));
			}
		}
		
		return specifiedActors;
		//this way I don't need to create a new getter for each type of actor created
		
		
	}
	/**
	 * make sure that there is a constant check running to make sure that no two objects occupy the same loocation
	 * @return
	 * @throws IOException 
	 */
	
	//this needs to be moved to Model
	public static void generateActorAtRandomLocation(String specification) throws IOException
	{
		switch(specification)
		{
		//check if there is something here to get around the NullPointerException error
			case "Minnow": //generating a minnow with null location
				Minnow minnow = new Minnow(GameMethods.generateValidLocation(), Model.nutritionMinnowsStartWith);
				singleModel.addActor(minnow);
			case "Shark":
				Shark shark = new Shark(GameMethods.generateValidLocation(), Model.nutritionSharksStartWith); //assertionError here...?
				singleModel.addActor(shark);
			case "Algae":
				Algae algae = new Algae(GameMethods.generateValidLocation(), 5);
				singleModel.addActor(algae);
		
				
		
		}
		
	
	}

	

}
