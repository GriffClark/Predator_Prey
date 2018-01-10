import java.awt.image.BufferedImage;
import java.util.ArrayList;
//all things that move are animals
public class Animal extends Actor{
	
	protected int speed;	
	protected int nutrition; //for how much food it has eaten

	/*Things animals need:
	 * Image
	 * Speed
	 * Name
	 * Nutrition variable when it hits 0 animal dies
	 * Decision tree to determine movement (this will be different for predators and prey)
	 * System for animals to reproduce
	 * colissions - no 2 animals can occupy the same space
	 * 
	 */

	
	public Animal(Location location, int nutrition)
	{
		super(location);
		this.nutrition = nutrition;
	}
	
	public int getNutrition()
	{
		return nutrition;
	}

	

	
	@Override //this method is slightly different for animals then for Algae
	public boolean getIsAlive()
	{
		if(nutrition == 0)
		{
			return false;
		}
		return isAlive; //if you have nutrition returns whether or not you are alive. If nutrition is 0 then you are dead
	}
	
	public int getSpeed()
	{
		return speed;
	}
	

	@Override
	public void doThings()
	{
		
		//all the code for this is going to be pushed down to the children
		
		/**
		 * move method
		 * reproduce check
		 * feed
		 * 
		 */
	}
	
	public Animal reproduce(Animal a, Animal b, int distance) //this int distance should be GameMethods.getDistance
	{
		if(a.getName().equals(b.getName()) && distance ==1) //if animal a and animal b are the same and they are close enough
		{
			int passedInNutrition= (a.getNutrition() + b.getNutrition() + 1) / 2;
			
			String species = a.getName(); //could be A or B because they should have the same name
			
			switch(species)
			{
			
			//need a way to find valid location to spawn new child. Search all adjacent squares
			case "Minnow": 
				Minnow minnow = new Minnow(x, y,  passedInNutrition); //not sure how to get this xy value pair. Needs to be adjacent to parents I think but not sure what to do past that
				while(minnow.getLocation() == null)
				{
					//need to write a method that will check all valid locations around the two parents until it finds a place to put the new minnow
				}
				return minnow;
			
			}
			
			
		
		
		}
	}
	
	public void move(ArrayList localActors, Location target)
	{
		ArrayList<Animal> animalList = new ArrayList<Animal>();
		boolean isLocationEmpty = true;
		
		if(GameMethods.getDistance(location, target) <= speed)
		{
			for(int i = 0; i < localActors.size(); i++)
			{
				if(localActors.get(i)/*need a way to tell if it is an animal*/)
				{
					animalList.add((Animal) localActors.get(i));
				}
			}
			
			for(int i =0; i < animalList.size(); i++)
			{
				if(animalList.getLocation() == target) //not sure why this doesn't work
				{
					isLocationEmpty = false;
				}
			}
			
			if(isLocationEmpty == true)
			{
				this.location = target;
			}
			
		}
		
	}
	//do I need some way to check that the move was valid? Maybe there should also be a checkValidMove(location,target)

	public void feed(Actor deadThing)
	{
		nutrition += deadThing.getNutritionValue();
		deadThing.getEaten();
	}

}
