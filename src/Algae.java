import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Algae extends Actor{
	public Algae(Location location, int nutrition) throws IOException {
		super(location, nutrition);
		try
		{
			name = "Algae";
			askiiRep = 'A';
			nutrition = 5;
			
			image = ImageIO.read(new File ("algae.jpg")); 

		}
		catch (IOException e)
		{
			System.out.println("Something went wrong in algae constructor");
		}
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void doThings() throws IOException
	{
		try {
			//try catch figure this out
			if(Controller.stepsTaken % Model.halfLife == 0)
			{
				int numberOfAlgae = GameMethods.getActorOfSpecifiedType("Algae").size();
				for(int i = 0; i < numberOfAlgae; i++)
				{
					GameMethods.generateActorAtRandomLocation("Algae"); //need to check if this generateAtRandomLocation works as intended
				}
			}
		}
		catch (IOException e)
		{
			System.out.println("error in algae doThings");
		}
	
	}
	
		
}

