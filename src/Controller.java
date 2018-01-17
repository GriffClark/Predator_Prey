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
//		new View();
		boolean debugMode;
		System.out.println("run in debug mode?");
		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();
		GameMethods.start();
		do
		{			
			if(input.equals("y"))
			{
				debugMode = true;
			}
			else
			{
				debugMode = false;
			}
			if(stepsTaken == 0)
			{
				System.out.println("game has started");
			}
			else if (debugMode == true)
			{
				System.out.println(Model.getGameModel().getRecentRecord());
			}
			/**
			 * get localModel and localActors
			 * make sure that all the actors are alive
			 * if they are, have the actors do things
			 *debug: prints an ascii grid
			 *
			 */
			Model localModel = Model.getGameModel();
			ArrayList<Actor> localActors = new ArrayList<Actor>(); //this should wipe it every time
			int actorSize = Model.getGameModel().getActorsSize();
			for (int i = 0; i < actorSize; i++)
			{
				localActors.add((Actor) Model.getGameModel().getActor(i));
			}			
		
			/**
			 * extra crap being added in here
			 */
			int oneTimeSize =localActors.size();
			for (int i =  oneTimeSize- 1; i >=0; i--)
			{
				if(debugMode == true)
				{
					System.out.println(" i = " + i  +", " + "localActorSize = " + localActors.size());
					System.out.println(localActors.get(i).toString());
				}
				/*
				 * so for each actor is it generating a full set of actors ie there are 4 actors and generates 1 shark 1 minnow and 2 algae for each actor I wanted
				 * and then also it will not go past one step so infinite loop?
				 */
				
				/**
				 * blockchain integration to show full history of where everything came from so I can tell what is falsely generated
				 */
				
				//loops through all the animals and has them move and do things based on their decision trees
				//rangeCheck here unknown source
				if(localActors.get(i).getIsAlive() == false)
				{
					
					localActors.remove(i);
	
				}
			}	
			
			actorSize = localActors.size();
			for(int i = localActors.size() - 1; i >=0; i--)
			{
				localActors.get(i).doThings(); 
				//stops working here
				
			}
		
			int homeSize = Controller.actorsThatNeedAHome.size();
			for(int i = 0; i < homeSize; i++)
			{
				localActors.add(actorsThatNeedAHome.get(i));
			}
			actorsThatNeedAHome.clear(); //should wipe it
			oneTimeSize = localActors.size();
			for(int i =  - 1; i >=0; i--)
			{
				if(localActors.get(i).getIsAlive() == false)
				{
					
					localActors.remove(i);
				}
			}

			localModel.CompleteStep(stepsTaken, localActors, localActors.size()); //makes a record of what step you are on and what actors exist
			//I am not confident that the handoff between completing a step and starting a new step is solid
			
			System.out.println("Step " + Controller.stepsTaken + " complete sucessfully");
			Thread.sleep(500);
		} while(stepsTaken < Model.getGameModel().getDesiredSteps());
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner (System.in);

		System.out.println("done. all " + Controller.stepsTaken + " steps were shown");
		
		System.out.println("would you like to see view full record list? 'y''n'");
		input = s.nextLine();

		if(input.equals("y"))
		{
			 Model.getGameModel().printRecords();
		}
		
		
		
		

	}

}
