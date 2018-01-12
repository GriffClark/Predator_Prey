import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Algae extends Actor{

	public Algae(Location location) throws IOException {
		super(location);
		image = ImageIO.read(new File ("algae.jpg")); 
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void doThings()
	{
		if(Controller.stepsTaken % Model.halfLife == 0)
		{
			int numberOfAlgae = GameMethods.getActorOfSpecifiedType("Algae").size();
			for(int i = 0; i < numberOfAlgae; i++)
			{
				GameMethods.generateActorAtRandomLocation("Algae");
				//algae will not generate on any actors and also actors will never generate on any algae
			}
		}
	}
	
		
}

