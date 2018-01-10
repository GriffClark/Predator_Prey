/**
 * 
 * @author Griffin 
 *building everything in Minnow first then will write one for Shark
 */
public class Shark extends Animal{
	
	public Shark( Location location, int nutrition)
	{
		super(location, nutrition);
		askiiRep = 'S';
		speed = Model.setSharkSpeed;
		name = "Shark";
		isAlive = true;
		nutrition= Model.nutritionSharksStartWith; //nutrition needs to be passed in because it is a function of the parents, or a default
		thingsICanEat = Animal.Edibles.Minnow;  //not sure how to use this but I know I need it
	}
	
	@Override
	public void doThings()
	{
		//do I do nested if/else or do i make a bunch of isHungry type booleans and run checks?
		if(nutrition >=10)
		{
			if(/*some way to tell if there is another full shark nearby*/)
			{
				//reproduce
			}
			
			else
			{
				//move in a random direction
			}
		}
		else
		{
			if(/*there is food nearby*/)
			{
				//go eat the food
			}
			else
			{
				//move in a random direction
			}
		}
	}


}

