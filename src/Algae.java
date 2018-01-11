import java.awt.image.BufferedImage;

public class Algae extends Actor{

	public Algae(Location location) {
		super(location);
		
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

