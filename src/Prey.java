
public class Prey extends Animal{

	/*
	 * gets eaten
	 * nutrition value for predators when they are eaten based on half of the nutrition it has rounded up
	 */
	public void eatFood(Food food)
	{
		nutrition += (food.getNutritionValue() + 1)/ 2;
	}
	
	
	public int getNutritionValue()
	{
		return nutrition;
	}
}
