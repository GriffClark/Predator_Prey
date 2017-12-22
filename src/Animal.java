import java.awt.image.BufferedImage;

public class Animal {
	
	protected BufferedImage image;
	protected int speed;
	protected String speciesName;
	protected int nutrition;
	
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


}
