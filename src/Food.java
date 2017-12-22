import java.awt.image.BufferedImage;

//note that food is Not an animal
public class Food {
	
	protected int nutritionValue;
	protected BufferedImage image;
	
	public int getNutritionValue()
	{
		return nutritionValue;
	}
	
	
	/*
	 * just here to be eaten by prey
	 * should have a nutrition value and an image... and that's it?
	 * Does not take up it's space-animals can walk on it
	 */

}
