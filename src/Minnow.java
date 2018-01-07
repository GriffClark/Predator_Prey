
public class Minnow extends Prey{
	
	public Minnow(int x, int y, int nutrition) 
	{
		super(x, y, nutrition);
		askiiRep = 'M';
		speed = 1;
		name = "Minnow";
		isAlive = true;
	}

	
	//I think this should go in Animal but I don't know how to do it without knowing the animal type before hand
	public Minnow reproduce(Animal a, Animal b, int distance) //this int distance should be GameMethods.getDistance
	{
		if(a.getName().equals(b.getName()) && distance < 2) //if animal a and animal b are the same and they are close enough
		{
			int passedInNutrition= (a.getNutrition() + b.getNutrition() + 1) / 2;
			Minnow minnow = new Minnow(x, y,  passedInNutrition); //not sure how to get this xy value pair. Needs to be adjacent to parents I think but not sure what to do past that
			while(minnow.getLocation() == null)
			{
				//need to write a method that will check all valid locations around the two parents until it finds a place to put the new minnow
			}
			return minnow;
			
		}
		
		else
		{
			return null;
			//is this what I want to do?
		}
	}

}
