import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
		
		//this is to balance out too many algae
		ArrayList<Actor> totalAlgae = Model.getGameModel().getActorOfSpecificType("Algae");
		
		if(totalAlgae.size() > 75)
		{
			nutrition --;
		}
		
		if(totalAlgae.size() > 120 )
		{
			nutrition --;
		}
		
		if(totalAlgae.size() > 150)
		{
			nutrition --;
		}
		
		//the more algae there are the more nutrition it loses each turn
		
		if(totalAlgae.size() < 200 && nutrition > 0)
		{
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
	
		
}

