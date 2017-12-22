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
	//all of these I can use to record data
	public static int[] sharks;
	public static int[] minnows;
	public static int[] algae;

	public static void main(String[] args) {
 

		
		sharks = new int[steps];
		minnows = new int[steps];
		algae = new int[steps];
		//creates 2 int[] that store the total number of Sharks and Minnows
		
		/**
		 * 2 possible design options here:
		 * 1. Build ArrayLists for each animal & food in addition to ones containing predator and prey
		 * 2. Just have ArrayLists for animal&food and do the math to figure out how many predators and prey
		 */
		//create ArrayLists for each species and type of food
		
		//at the end of every cycle make a check to see who got eaten. When someone is eaten or dead remove them. 
		//call the checkAlive method on every actor
		
		
		// TODO Auto-generated method stub

	}

}
