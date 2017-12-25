
public class Minnow extends Prey{
	
	public Minnow(int[][] location, int nutrition)
	{
		askiiRep = 'M';
		speed = 1;
		name = "Minnow";
		isAlive = true;
		this.location = location; //location needs to be passed in
		this.nutrition= nutrition; //nutrition needs to be passed in because it is a function of the parents, or a default
	}
	
	public Minnow(int nutrition)
	{
		askiiRep = 'M';
		speed = Game.setMinnowSpeed;
		name = "Minnow";
		isAlive = true;
		this.nutrition= nutrition; //nutrition needs to be passed in because it is a function of the parents, or a default
	}
	
	//I think this should go in Animal but I don't know how to do it without knowing the animal type before hand
	public Minnow reproduce(Animal a, Animal b, int distance) //this int distance should be GameMethods.getDistance
	{
		if(a.getName().equals(b.getName()) && distance < 2) //if animal a and animal b are the same and they are close enough
		{
			int n= (a.getNutrition() + b.getNutrition() + 1) / 2;
			Minnow minnow = new Minnow(n);
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
