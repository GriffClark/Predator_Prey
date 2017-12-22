import java.awt.image.BufferedImage;

public class WaterBug extends Food{
	
	public WaterBug()
	{
		nutritionValue = (int)(Math.random() * 3) + 1;
//		image = new BufferedImage();
	}
}
