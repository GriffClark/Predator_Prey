import java.awt.image.BufferedImage;
import java.util.ArrayList;
//all things that move are animals
public class Animal extends Actor{
	
	public enum Edibles
	{
		Shark, Minnow
	}
	
	protected int speed;	
	protected int nutrition; //for how much food it has eaten
	protected Edibles thingsICanEat;

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
	
	public void subtractNutrition()
	{
		nutrition--;
	}

	

	@Override
	public void doThings()
	{
			ArrayList<Actor> thingsNearBy = new ArrayList<Actor>(); //I don't want to keep actors here because I only want each actor to be stored in one location, and animals do not need a running memory of what is around them, since they will always be making this check
			//need a way to scan all locations within your speed, which is also how far you can see around you
			
			//in order for this to work, need to make each actor self-aware. This might also work, though
			
			for(int i = 0; i < GameMethods.getActorArrayList().size(); i++)
			{
				if(GameMethods.getDistance(((Actor) GameMethods.getActorArrayList().get(i)).getLocation(), location) <= speed && ((Actor) GameMethods.getActorArrayList().get(i)).getLocation() != location) //if the distance between this actor and other actor is <= speed && it is not at your current location...
				{
					thingsNearBy.add((Actor) GameMethods.getActorArrayList().get(i));
					//if there is a thing that you can move to, you are aware that it's there
				}
			}
			//just laying the groundwork. This will be used later by Shark and Minnow
	}
	
	public Animal(int nutrition)
	{
		this.nutrition=nutrition;
	}
	
	public void reproduce(Animal otherParent, int distance) //this int distance should be GameMethods.getDistance
	{
		if(otherParent.getName().equals(name) && distance ==1) //if animal a and animal b are the same and they are close enough
		{
			int passedInNutrition= (otherParent.getNutrition() + nutrition + 1) / 2;
			
			String species = otherParent.getName(); //could be A or B because they should have the same name

			switch(species)
			{
			
			//need a way to find valid location to spawn new child. Search all adjacent squares
			case "Minnow": 
				Minnow minnowBaby = new Minnow(passedInNutrition);
				GameMethods.placeSpawn(minnowBaby, otherParent, location);
				Controller.actorsThatNeedAHome.add(minnowBaby);
				break;
			case "Shark":
				Shark sharkBaby = new Shark (passedInNutrition);
				GameMethods.placeSpawn(sharkBaby, otherParent, location);
				Controller.actorsThatNeedAHome.add(sharkBaby);
				break;
				
				//this should create a new child then add it to actorsThatNeedAHome, which will be passed into localActors, which will be passed into Model
					
					//think this works
					
				}
			
			}
			//need to make shark case too
			
		
		
		}
	public void move(Location target)
	{
		/*
		 * input the location you would like to move to (you need to check validity first. After double checking to make sure there are no bugs, you move there
		 */
		
		if(GameMethods.getDistance(location, target) <= speed)
		{
			boolean isLocationEmpty = true;
			ArrayList<Actor> localActors = new ArrayList<Actor>();
			ArrayList<Animal> animalList = new ArrayList<Animal>();
			for(int i = 0; i < localActors.size(); i++)
			{
				if(localActors.get(i).getName().equals("Shark") || localActors.get(i).getName().equals("Minnow")) //not sure how to syntax this
				{
					animalList.add((Animal) localActors.get(i));
				}
			}
			
			for(int i =0; i < animalList.size(); i++)
			{
				if( animalList.get(i).getLocation() == target) //not sure why this doesn't work
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
