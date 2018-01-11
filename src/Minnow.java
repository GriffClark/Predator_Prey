
public class Minnow extends Animal{
		
	public Minnow(Location location, int nutrition)
	{
		super(location, nutrition);
		askiiRep = 'M';
		speed = Model.setMinnowSpeed;
		name = "Minnow";
		isAlive = true;
		this.nutrition = nutrition;
	}
	
	public Minnow(int nutrition)
	{
		super(nutrition);
		askiiRep = 'M';
		speed = Model.setMinnowSpeed;
		name = "Minnow";
		isAlive = true;
		this.nutrition = nutrition;
	}
		
		}

	
	//I think this should go in Animal but I don't know how to do it without knowing the animal type before hand
	


