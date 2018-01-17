import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
//all things that move are animals
public class Animal extends Actor{
	
	public enum Edibles
	{
		Shark, Minnow
	}
	
	protected int speed;	
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
		super(location,nutrition);
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
	//need to see if this is still doing what I told it to do in Actor
	public void doThings()
	{
         super.doThings();
         /*
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
			}*/
			//just laying the groundwork. This will be used later by Shark and Minnow
	}
	
	public void reproduce(Animal otherParent, int distance) throws IOException //this int distance should be GameMethods.getDistance
	{
		if(otherParent.getName().equals(name) && distance <=2) //if animal a and animal b are the same and they are close enough
		{
			int passedInNutrition = (otherParent.getNutrition() + nutrition + 1) / 2;
			nutrition /= 2;
			otherParent.nutrition /= 2;
			
			String species = otherParent.getName(); //could be A or B because they should have the same name
			boolean foundLocation = false;
			Location babyLocation = null;
			while(foundLocation == false)
				try {
					{
						babyLocation = GameMethods.generateValidLocation();
						
						if (GameMethods.getDistance(location, babyLocation) <= 2)
						{
							foundLocation = true;
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			Actor baby = new Actor();

			try {
				switch(species)
				{
				
				//need a way to find valid location to spawn new child. Search all adjacent squares
				case "Minnow": 
					try {
					 baby = new Minnow (babyLocation, passedInNutrition);
					}
					 catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Controller.actorsThatNeedAHome.add(baby);
					break;
				case "Shark":
					 
					try {
						baby = new Shark(babyLocation, passedInNutrition);
					}
					catch(IOException e)
					{
						e.printStackTrace();
					}
					Controller.actorsThatNeedAHome.add(baby);
					break;
						
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
			
		
		}
	public void move(Location target)
	{
		
		
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
