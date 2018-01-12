/**
 * most important thing to work on here is to make sure that each thing only has one location... right now a single object can be stored in multiple places. This can lead to many errors and make things mroe complicated then they need to be
 */

import java.io.IOException;
import java.util.ArrayList;
/**
 *Methods here:
 *	start
 *	main
 */
import java.util.Scanner;
public class Controller {
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
	public static void main(String[] args) throws InterruptedException, IOException {

		
		
		
		//after everything has been initalized, the game starts...:
//		new View();
		GameMethods.start();
		do 
		{
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
			
			for (int i = 0; i < Model.getActorsSize(); i++)
			{
				localActors.add((Actor) GameMethods.getActorArrayList().get(i)); //cast should have no effect
			}			
			
			for (int i = 0; i < Model.getActorsSize(); i++)
			{
				//loops through all the animals and has them move and do things based on their decision trees
				
				if(localActors.get(i).getIsAlive() == false)
				{
					localActors.remove(i); //this should kill off the thing
				}
				
				else 
				{
					localActors.get(i).doThings(); 
					Thread.sleep(50); //slows things down a little to take a bit of the load off the processor by 50 millisecods 
				}
				
			}			
			
			
		
			
			
			//algae reproduce
			
			//print out a rough grid of what things look like
			
		
			
			 
			
			
			localModel.CompleteStep(stepsTaken, localActors); //makes a record of what step you are on and what actors exist
			//I am not confident that the handoff between completing a step and starting a new step is solid
	
		}while(stepsTaken < Model.desiredSteps); 

		

	}

}
