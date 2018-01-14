import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Algae extends Actor{

	int nutrition = 5; //after 5 turns they should die
	public Algae(Location location) throws IOException {
		super(location);
		try
		{
			name = "Algae";
			askiiRep = 'A';
			
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
					GameMethods.generateActorAtRandomLocation("Algae");
					//algae will not generate on any actors and also actors will never generate on any algae
				}
			}
		}
		catch (IOException e)
		{
			System.out.println("error in algae doThings");
		}
	
	}
	
		
}

