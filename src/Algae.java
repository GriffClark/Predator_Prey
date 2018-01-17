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
			this.nutrition = nutrition;	
			isAlive = true;
			image = ImageIO.read(new File ("algae.jpg")); 

		}
		catch (IOException e)
		{
			System.out.println("Something went wrong in algae constructor");
		}
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void doThings()
	{
		super.doThings();
		try {
			//try catch figure this out
			if(Controller.stepsTaken % Model.getGameModel().getHalfLife() == 0)
			{
				Algae al = new Algae(GameMethods.generateValidLocation(), 5); 
			    Controller.actorsThatNeedAHome.add(al);
			}
		}
		catch (IOException e)
		{
			e.getStackTrace();
		}
	
	}
	
		
}

