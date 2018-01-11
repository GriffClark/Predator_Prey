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
	
	public static Location generateValidLocation()
	{
		int rows = Model.gridSize.length - 1;
		int cols = Model.gridSize[0].length-1;
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
	
	public static void placeSpawn(Actor child, Actor parentA, Actor parentB)
	{
		Location a = parentA.getLocation();
		Location b = parentB.getLocation();
		boolean valid = false;
		Location newLocation = GameMethods.generateValidLocation();
		
		while(valid == false)
		{
			if(GameMethods.getDistance(newLocation, a) <= 2 || GameMethods.getDistance(newLocation, b) <=2)
			{
				valid = true;
			}
			else
			{
				newLocation = GameMethods.generateValidLocation();
			}
			
			child.setLocation(newLocation);
		}
		
		}
		
		public static void placeSpawn(Actor child, Actor parentA, Location location)
		{
			Location a = parentA.getLocation();
			Location b = location;
			boolean valid = false;
			Location newLocation = GameMethods.generateValidLocation();
			
			while(valid == false)
			{
				if(GameMethods.getDistance(newLocation, a) <= 2 || GameMethods.getDistance(newLocation, b) <=2)
				{
					valid = true;
				}
				else
				{
					newLocation = GameMethods.generateValidLocation();
				}
				
				child.setLocation(newLocation);
			}

	}
	
	public static void subractNutrition()
	{
		for(int i = 0; i < GameMethods.getActorArrayList().size(); i++)
		{
			((Animal) GameMethods.getActorArrayList().get(i)).subtractNutrition();
			//is algae going to cause this to error out?
		}
	}
	
	public static ArrayList getActorArrayList()
	{
		Model localModel = Model.getGameModel();
		ArrayList<Actor> localActors = new ArrayList<Actor>();
		
		for (int i = 0; i < Model.getActorsSize(); i++)
		{
			localActors.add((Actor) localModel.copyOfActors().get(i));
		}	
		
		return localActors;
	}
	
	public static void moveToRandomLocation(Animal fred)
	{
		boolean foundValidLocation = false;
		do
		{
			Location randomLocation = GameMethods.generateValidLocation();
			if(GameMethods.getDistance(fred.getLocation(), randomLocation) <= fred.getSpeed())
			{
				fred.move(randomLocation);
			}
		}while(foundValidLocation == false);
		
		
	
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
	
	
	public static void start() throws InterruptedException
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("how many steps would you like to see?");
		int input = keyboard.nextInt(); //input will be re-used. Steps will be a constant value 
		Model.desiredSteps = input;
		//we should add a defualt number of sharks and minnows to start with
		System.out.println("how many sharks would you like to start with?");
		int sharkStart = keyboard.nextInt();
		System.out.println("how many minnows do you want to start with?");
		int minnowStart = keyboard.nextInt();
		System.out.println("One second while the game initializes...");
		Thread.sleep(500); //half a second
		Model.numberOfMinnows = minnowStart;
		Model.numberOfSharks = sharkStart;
		Model.numberOfAlgae = minnowStart *2; //just an idea not a solution
		System.out.println("...");
		for(int i = 0; i < Model.numberOfMinnows; i++)
		{
			GameMethods.generateActorAtRandomLocation("Minnow");
		}
		for(int i = 0; i < Model.numberOfSharks; i++)
		{
			GameMethods.generateActorAtRandomLocation("Shark");
		}
		for(int i = 0; i < Model.numberOfAlgae; i++)
		{
			GameMethods.generateActorAtRandomLocation("Algae");
		}
		Thread.sleep(500);
		System.out.println("Model has been initialized!");
		
		//debug check
		for(int i = 0; i < GameMethods.getActorArrayList().size(); i++)
		{
			System.out.println(GameMethods.getActorArrayList().get(i).toString());
		}
		
		//is this the correct way of going about starting?
	}
	
	public static ArrayList getActorOfSpecifiedType (String specification)
	{ //based on the current status of the game gets you all actors of a specific type
		GameStatus currentStatus = Model.getCurrentStatus();
		ArrayList<Actor> localCopyOfAllActors = currentStatus.actors; //is this a valid way of copying it? To tired to figure it out
		ArrayList<Actor> specifiedActors = new ArrayList<Actor>();
		
		
		for(int i = 0; i < Model.getActorsSize(); i++)
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
	 */
	
	public static void generateActorAtRandomLocation(String specification)
	{
		switch(specification)
		{
			case "Minnow":
				Minnow minnow = new Minnow(GameMethods.generateValidLocation(), Model.nutritionMinnowsStartWith);
				Model.addActor(minnow);
			case "Shark":
				Shark shark = new Shark(GameMethods.generateValidLocation(), Model.nutritionSharksStartWith);
				Model.addActor(shark);
			case "Algae":
				Algae algae = new Algae(GameMethods.generateValidLocation());
				Model.addActor(algae);
		
				
		
		}
		
	
	}
	
	


	

}
