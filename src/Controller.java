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
	public static int steps;
	
	/**
	 * a lot of these can be removed, but need to pencil and paper out which ones are aboslutely necessary 
	 */
	
	
	
	//need to build the grid
	

	
	public static void main(String[] args) {
		//initializing variables

		sharks = new int[steps][Game.totalSharks.size()];  //I don't know if this is what I want. What this is intend to do is store a matrix of time and population data in an int[][] ALSO just got a NullPointerException here. Why?
		minnows = new int[steps][Game.totalMinnows.size()];
		algae = new int[steps][Game.totalFood.size()]; //this might be redundant of the ArrayList storage methods but I think it might be helpful to know how many of each type of Actor there is at a give time for graphing
		int stepsTaken = 0;
		
		//generating the grid now
		
		Grid gameGrid = GameMethods.getNewGrid();
		
		//after everything has been initalized, the game starts...:
		GameMethods.start();
		do 
		{
			stepsTaken++; //increase the number of steps taken
			for (int i = 0; i < totalPopulation.size(); i++)
			{
				//loops through all the animals and has them move and do things based on their decision trees
				
				if(totalPopulation.get(i).getIsAlive() == false)
				{
					totalPopulation.remove(i); //this should kill off the thing
				}
				
				else
				{
					totalPopulation.get(i).doThings(); //also take care of reproduction here? Yes but that still needs work
				}
				
				//now to loop through all the algae to check if they were eaten. This will make sure that no animal can eat the same algae twice. 
				//this is not the most effective way to do it. Open to new ideas 
				
				for (int j = 0; j< totalFood.size(); j++)
				{
					if(totalFood.get(j).getIsAlive() == false)
					{
						totalFood.remove(j);
						//if the food was eaten get rid of it
					}
				} //I do not like this way of doing it because it is not very effective and will take up a lot of computing power
				
				
			}
			
			//now need a print statement:
//			
//			for(int row = 0; row < gameGrid.getLength(); row++)
//			{
//				for (int col = 0; col < gameGrid.get0Length(); col++)
//				{
//					System.out.println(gameGrid[row][col].getAskiiRep());
//				}
//				System.out.println();
//			}
		}while(stepsTaken < steps); //while you have not taken as many steps as you wanted
		
		//at the end of every cycle make a check to see who got eaten. When someone is eaten or dead remove them. 
		//call the checkAlive method on every actor
		
		
		// TODO Auto-generated method stub

	}

}
