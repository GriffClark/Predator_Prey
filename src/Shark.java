/**
 * 
 * @author Griffin 
 *building everything in Minnow first then will write one for Shark
 */
public class Shark extends Animal{
	
	public Shark(int x, int y)
	{
		super(x,y);
		askiiRep = 'S';
		speed = Model.setSharkSpeed;
		name = "Shark";
		isAlive = true;
		nutrition= Model.nutritionSharksStartWith; //nutrition needs to be passed in because it is a function of the parents, or a default
	}
	
	public Shark(int x, int y, int nutrition)
	{
		super(x,y);
		askiiRep = 'S';
		speed = Model.setSharkSpeed;
		name = "Shark";
		isAlive = true;
		this.nutrition = nutrition;
		
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

