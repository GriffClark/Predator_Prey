import java.awt.image.BufferedImage;
//all things that move are animals
public class Animal extends Actor{
	
	protected int speed;	
	protected int nutrition; //for how much food it has eaten

	/*Things animals need:
	 * Image
	 * Speed
	 * Name
	 * Nutrition variable when it hits 0 animal dies
	 * Decision tree to determine movement (this will be different for predators and prey)
	 * System for animals to reproduce
	 * colissions - no 2 animals can occupy the same space
	 */
	
	public int getNutrition()
	{
		return nutrition;
	}
	
	public void Animal()
	{
		
	}
	
	public void eat(Actor deadThing)
	{
		nutrition += deadThing.getNutritionValue();
		deadThing.getEaten();
	}
	
	@Override //this method is slightly different for animals then for Algae
	public boolean getIsAlive()
	{
		if(nutrition == 0)
		{
			return false;
		}
		return isAlive; //if you have nutrition returns wheter or not you are alive. If nutrition is 0 then you are dead
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public int[][] generateMoveRequest(int x, int y)
	{ //takes a desired X and Y value and returns a request to go to that spot (or at least this int[][] will be turned into a request in GameMethods
		int[][] movement = new int[x][y];
		return movement;
		//so this will store your positive or negative movement along the grid
	}
	
	public Animal reproduce(Animal a, Animal b)
	{
		if(a.getName().equals(b.getName())) //if animal a and animal b are the same
		{
			/*
			 * without knowing what type animal a and b are, I need to create a new Animal of that same type. Not sure how to do that
			 */
		}
	}


}
