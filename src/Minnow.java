
public class Minnow extends Animal{
	
	public Minnow(int x, int y) 
	{
		super(x, y);
		askiiRep = 'M';
		speed = Model.setMinnowSpeed;
		name = "Minnow";
		isAlive = true;
		nutrition = Model.nutritionMinnowsStartWith;
	}
	
	public Minnow(int x, int y, int nutrition)
	{
		super(x,y);
		askiiRep = 'M';
		speed = Model.setMinnowSpeed;
		name = "Minnow";
		isAlive = true;
		this.nutrition = nutrition;
		
	}

	
	//I think this should go in Animal but I don't know how to do it without knowing the animal type before hand
	

}
