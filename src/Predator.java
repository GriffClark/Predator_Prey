
public class Predator extends Animal{
	
	/*
	 * Needs to eat prey 
	 * Can move faster then prey (prey can move 1 and predator can move 2)
	 * 
	 */
	
	@Override
	public void eat(Actor deadThing)
	{
		nutrition += (deadThing.getNutritionValue() + 1) / 2; //only gets half as much energy from eating living things
		deadThing.getEaten();
	}
	

}
