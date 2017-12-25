
public class Shark extends Predator{
	
	public Shark(int nutrition)
	{
		askiiRep = 'S';
		speed = Game.setSharkSpeed;
		name = "Shark";
		isAlive = true;
		this.nutrition= nutrition; //nutrition needs to be passed in because it is a function of the parents, or a default
	}

}
