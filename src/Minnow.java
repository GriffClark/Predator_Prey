import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
 
public class Minnow extends Animal{
		
	public Minnow(Location location, int nutrition) throws IOException
	{
		super(location, nutrition);
		askiiRep = 'M';
		speed = Model.getGameModel().getSetMinnowSpeed();
		name = "Minnow";
		isAlive = true;
		this.nutrition = nutrition;
		try
		{
			image = ImageIO.read(new File ("minnow.png"));
		}
		catch (IOException e)
		{
			System.out.println("Something went wrong in minnow constructor");
		}
	}
		
		

@Override
public void doThings()
{

	super.doThings();
	//can I use the part of the method in Animal without having to copy paste?
	
	ArrayList<Minnow> minnowsNearBy = new ArrayList<Minnow>(); //I don't want to keep actors here because I only want each actor to be stored in one location, and animals do not need a running memory of what is around them, since they will always be making this check
	//need a way to scan all locations within your speed, which is also how far you can see around you
	ArrayList<Shark> sharksNearBy = new ArrayList<Shark>();
	ArrayList<Algae> algaeNearBy = new ArrayList<Algae>();
	
	//in order for this to work, need to make each actor self-aware. This might also work, though
	
	for(int i = 0; i < GameMethods.getActorArrayList().size(); i++)
	{
		if(GameMethods.getDistance(((Actor) GameMethods.getActorArrayList().get(i)).getLocation(), location) <= speed && ((Actor) GameMethods.getActorArrayList().get(i)).getLocation() != location) //if the distance between this actor and other actor is <= speed && it is not at your current location...
		{
			switch(((Actor) GameMethods.getActorArrayList().get(i)).getName())
			{
			case("Shark"):
				sharksNearBy.add((Shark) GameMethods.getActorArrayList().get(i));
			break;
			case("Minnow"):
				minnowsNearBy.add((Minnow)GameMethods.getActorArrayList().get(i));
			break;
			case ("Algae"):
				algaeNearBy.add((Algae) GameMethods.getActorArrayList().get(i));
			
				
			}
			//if there is a thing that you can move to, you are aware that it's there

		}
	}

	//do I do nested if/else or do i make a bunch of isHungry type booleans and run checks?
	if(nutrition >=4) { //if you have lots of nutrition
	
		if(minnowsNearBy.size() >= 1)
		{ //if there are minnows nearby
			//move so that the distance between the two sharks is less than two
			//create and place a new shark
			for(int i = 0; i < minnowsNearBy.size(); i++)
			{ //for each nearby minnow
				if(GameMethods.getDistance(location, minnowsNearBy.get(i).getLocation()) <= speed)
				{ //if you can move to the nearby minnows
					Location intercept = GameMethods.aquireIntercept(minnowsNearBy.get(i).getLocation(), speed, location);
					move(intercept);
					
						try {
							reproduce(minnowsNearBy.get(i), GameMethods.getDistance(location, minnowsNearBy.get(i).getLocation()));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;	
					} //close if loop 
				} //close for loop
			}
			else
			{//if there are no minnows nearby
				//maybe add a move away from sharks clause if there is time
				GameMethods.moveToRandomLocation(location,speed);
			}
			
		}
	else //needs food
	{
		if(algaeNearBy.size() >= 1)
		{ //there are algae nearby
			int a = algaeNearBy.size();
			for(int i = 0; i < a; i++)
			{ //for each algae nearby
				if (GameMethods.getDistance(algaeNearBy.get(i).getLocation(), location) <= speed)
				{ //you can get to the algae
					Location intercept = GameMethods.aquireIntercept(algaeNearBy.get(i).getLocation(), speed, location);
					move(intercept);
					feed(algaeNearBy.get(i));
					break;
					//make it so that the distance between them is less than 2
					/*
					 * starts searching random locations until it finds one that is less than 2 away from the target
					 * location is then valid if it is movable by shark
					 * location is passed into a move method
					 * eats the minnow
					 */
				}
			}
		} //ends algae nearby
		else //no algae nearby
		{
			GameMethods.moveToRandomLocation(location,speed);

			
	} //ends decision tree

	
}

}
}
		
	
	



	
	//I think this should go in Animal but I don't know how to do it without knowing the animal type before hand
	


