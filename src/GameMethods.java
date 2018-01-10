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
	
	public static ArrayList getActorArrayList()
	{
		Model localModel = Model.getGameModel();
		ArrayList<Actor> localActors = new ArrayList<Actor>();
		
		for (int i = 0; i < Model.getActorsSize(); i++)
		{
			localActors.add((Actor) localModel.copyOfActors().get(i)); //cast should have no effect
		}	
		
		return localActors;
	}
	
	
	public static void start()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("how many steps would you like to see?");
		int input = keyboard.nextInt(); //input will be re-used. Steps will be a constant value 
		Model.desiredSteps = input;
		
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
	
	public Actor generateActorAtRandomLocation(String specification)
	{
		switch(specification)
		{
			case "Minnow":
				Minnow minnow = new Minnow(Location.generateAtValidLocation(), Model.nutritionMinnowsStartWith);
				return minnow;
			case "Shark":
				Shark shark = new Shark(Location.generateAtValidLocation(), Model.nutritionSharksStartWith);
				return shark;
			case "Algae":
				Algae algae = new Algae(Location.generateAtValidLocation());
				return algae;
			default:
				//if nothing worked
				return null;
				
		
		}
	}
	
	
	

	

}
