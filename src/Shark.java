import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * 
 * @author Griffin 
 *building everything in Minnow first then will write one for Shark
 */
public class Shark extends Animal{
	
	public Shark( Location location, int nutrition) throws IOException
	{
		super(location, nutrition);
		try
		{
			askiiRep = 'S';
			speed = Model.getGameModel().getSetSharkSpeed();
			name = "Shark";
			isAlive = true;
			nutrition= Model.getGameModel().getNutritionSharksStartWith(); //nutrition needs to be passed in because it is a function of the parents, or a default
			thingsICanEat = Animal.Edibles.Minnow;  //not sure how to use this but I know I need it
			image = ImageIO.read(new File ("shark.jpg"));
		}
		catch (IOException e)
		{
			System.out.print("something went wrong in shark constructor");
			
		}
		
	}


	@Override
	public void doThings()
	{
        super.doThings();
		//can I use the part of the method in Animal without having to copy paste?
		
		ArrayList<Minnow> minnowsNearBy = new ArrayList<Minnow>(); //I don't want to keep actors here because I only want each actor to be stored in one location, and animals do not need a running memory of what is around them, since they will always be making this check
		//need a way to scan all locations within your speed, which is also how far you can see around you
		ArrayList<Shark>sharksNearBy = new ArrayList<Shark>();
		ArrayList<Actor> other = new ArrayList<Actor>();
		
		//in order for this to work, need to make each actor self-aware. This might also work, though
		
		for(int i = 0; i < GameMethods.getActorArrayList().size(); i++)
		{
			//giving 
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
				default:
					other.add((Actor) GameMethods.getActorArrayList().get(i));
				
					
				}
				//if there is a thing that you can move to, you are aware that it's there

			}
		}
	
		//do I do nested if/else or do i make a bunch of isHungry type booleans and run checks?
		if(nutrition >=6)
		{
			if(sharksNearBy.size() >= 1)
			{
				//move so that the distance between the two sharks is less than two
				//create and place a new shark
				for(int i = 0; i < sharksNearBy.size(); i++)
				{
					//if there are any sharks right next to you reproduce
					if(GameMethods.getDistance(location, sharksNearBy.get(i).getLocation()) <= speed)
					{
						Location intercept = GameMethods.aquireIntercept(sharksNearBy.get(i).getLocation(), speed, location);
						move(intercept);
						if(sharksNearBy.get(i).getNutrition() >= 5)
						{
							try {
								reproduce(sharksNearBy.get(i), GameMethods.getDistance(location, sharksNearBy.get(i).getLocation()));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
							
						}
					}
				}
			}
			
			else //if no nearby sharks were found
			{
				GameMethods.moveToRandomLocation(location,speed);
			}
		}
		else //needs food
		{
			if(minnowsNearBy.size() >= 1)
			{
				for(int i = 0; i < minnowsNearBy.size(); i++)
				{
					if (GameMethods.getDistance(minnowsNearBy.get(i).getLocation(), location) <= speed)
					{
						Location intercept = GameMethods.aquireIntercept(minnowsNearBy.get(i).getLocation(), speed, location);
						move(intercept);
						feed(minnowsNearBy.get(i));
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
			}
			else //if no nearby minnows were found
			{
				GameMethods.moveToRandomLocation(location,speed);
			}
		}
	}


}

