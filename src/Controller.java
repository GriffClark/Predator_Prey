/**
 * most important thing to work on here is to make sure that each thing only has one location... right now a single object can be stored in multiple places. This can lead to many errors and make things mroe complicated then they need to be
 */

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
	public static void main(String[] args) {
		int stepsTaken = 0;
		
		//after everything has been initalized, the game starts...:
		GameMethods.start();
		do 
		{
			GameStatus currentStatus = Model.getCurrentStatus(); //should get the status of Model.singleModel
			Model localModel = Model.getGameModel();
			ArrayList<Actor> localActors = new ArrayList<Actor>();
			
			for (int i = 0; i < Model.getActorsSize(); i++)
			{
				localActors.add((Actor) localModel.copyOfActors().get(i)); //cast should have no effect
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
				}
				
			}
			
			localModel.CompleteStep(stepsTaken, localActors); //makes a record of what step you are on and what actors exist
			
			stepsTaken++; //increase the number of steps taken

		}while(stepsTaken < Model.desiredSteps); 

		

	}

}
