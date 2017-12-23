import java.util.ArrayList;
import java.util.Scanner;
public class Game {
	/*
	 * just a main method with some instances of other classes
	 */
	public static int steps;
	public static void start()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("how many steps would you like to see?");
		int input = keyboard.nextInt(); //input will be re-used. Steps will be a constant value 
		steps = input;
	}
	
	public static ArrayList <Animal> totalPopulation;
	public static ArrayList <Predator> totalPredators;
	public static ArrayList<Prey> totalPrey;
	public static ArrayList<Actor> everything;
	public static ArrayList<Minnow> totalMinnows;
	public static ArrayList<Shark> totalSharks;
	public static ArrayList<Actor> totalFood;
	//all of these I can use to record data
	public static int[] sharks;
	public static int[] minnows;
	public static int[] algae;

	public static void main(String[] args) {
		//initializing variables

		sharks = new int[steps];
		minnows = new int[steps];
		algae = new int[steps];
		int stepsTaken = 0;
		do
		{
			stepsTaken++; //increase the number of steps taken
			for (int i = 0; i < totalPopulation.size(); i++)
			{
				//loops through all the animals and has them move and do things based on their decision trees
				totalPopulation.get(i).doThings(); //also take care of reproduction here?
				if(totalPopulation.get(i).getIsAlive() == false)
				{
					totalPopulation.remove(i); //this should kill off the thing
				}
				
				//now to loop through all the algae to check if they were eaten. This will make sure that no animal can eat the same algae twice. 
				//this is not the most effecteve way to do it. Open to new ideas 
				
				for (int j = 0; j< totalFood.size(); j++)
				{
					if(totalFood.get(j).getIsAlive() == false)
					{
						totalFood.remove(j);
						//if the food was eaten get rid of it
					}
				} //I do not like this way of doing it because it is not very effective and will take up a lot of computing pwoer
				
			}
			
		}while(stepsTaken < steps); //while you have not taken as many steps as you wanted
		
		//at the end of every cycle make a check to see who got eaten. When someone is eaten or dead remove them. 
		//call the checkAlive method on every actor
		
		
		// TODO Auto-generated method stub

	}

}
