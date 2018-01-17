/**
 * most important thing to work on here is to make sure that each thing only has one location... right now a single object can be stored in multiple places. This can lead to many errors and make things mroe complicated then they need to be
 */

// C:\Users\Griffin\Documents\GitHub\Predator_Prey
import java.io.IOException;
import java.util.ArrayList;
/**
 *Methods here:
 *	start
 *	main
 */
import java.util.Scanner;
public class Controller {
	
	//C:\Users\Griffin\Documents\GitHub\Predator_Prey 
	
	/*
	 * User enters desired # of steps
	 * grid is generated with all necessary actors
	 * steps are executed
	 * 	predators and prey move 
	 * 	predators can eat prey if in valid location
	 * 	predators and prey reproduce
	 * 	data is collected and stored
	 * graphs are generated and end screen is displayed (not my job hopefully @Griffin) 
	 */

	//this might not want to be a main method
	public static int stepsTaken = 0;
	public static ArrayList<Actor> actorsThatNeedAHome = new ArrayList<Actor>();
	public static void main(String[] args) throws InterruptedException, IOException { //need to throw in ea AssertTest I think or enableassertions AssertTest

		//after everything has been initalized, the game starts...:
		
	new View();
		
		GameMethods.start();
		while(stepsTaken < Model.desiredSteps)
		{
			if(stepsTaken == 0)
			{
				System.out.println("game has started");
			}
			/**
			 * get localModel and localActors
			 * make sure that all the actors are alive
			 * if they are, have the actors do things
			 *debug: prints an ascii grid
			 *
			 */
			GameStatus currentStatus = Model.getCurrentStatus(); //should get the status of Model.singleModel
			Model localModel = Model.getGameModel();
			ArrayList<Actor> localActors = new ArrayList<Actor>(); //make sure all edits that are made are made to localActors
			int actorSize = Model.getActorsSize();
			for (int i = 0; i < actorSize; i++)
			{
				localActors.add((Actor) GameMethods.getActorArrayList().get(i));
			}			
			actorSize = Model.getActorsSize();
			
			for (int i = 0; i < actorSize; i++)
			{
				//loops through all the animals and has them move and do things based on their decision trees
				
				if(localActors.get(i).getIsAlive() == false)
				{
					localActors.remove(i); //this should kill off the thing
				}
				
				else 
				{
					localActors.get(i).doThings(); 
				}
				
			}		
			int homeSize = Controller.actorsThatNeedAHome.size();
			for(int i = 0; i < homeSize; i++)
			{
				localActors.add(actorsThatNeedAHome.get(i));
			}
			actorsThatNeedAHome = new ArrayList<Actor>(); //should wipe it

			localModel.CompleteStep(stepsTaken, localActors); //makes a record of what step you are on and what actors exist
			//I am not confident that the handoff between completing a step and starting a new step is solid
			
			System.out.println("Step complete");
			System.out.println("there are currently " + GameMethods.getActorOfSpecifiedType("Minnow").size() + " minnows");
			Thread.sleep(50);
			System.out.println("there are currently " + GameMethods.getActorOfSpecifiedType("Shark").size() + " sharks" );
			Thread.sleep(50);
			System.out.println("there are currently " + GameMethods.getActorOfSpecifiedType("algae").size() + " algae");
			Thread.sleep(500);
	
		} 
		Scanner s = new Scanner (System.in);
	
		System.out.println("done. all " + Controller.stepsTaken + " steps were shown");
		
		System.out.println("would you like to see view full record list? 'y''n'");
		String input = s.nextLine();

		if(input.equals("y"))
		{
			
		}
		
		

	}
	
	public View getMainJFrame() {
		return mainJFrame;
	}

}
