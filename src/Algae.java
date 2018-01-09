import java.awt.image.BufferedImage;

public class Algae extends Actor{

	public Algae(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void doThings()
	{
		String specification = "Algae";
		int numberOfAlgae = GameMethods.getActorOfSpecifiedType(specification).size(); //should get the number of algae
		
		for(int i = 0; i < numberOfAlgae; i++) //stupid question but is it < or <=
		{
			boolean foundGoodLocation = false;
			while(foundGoodLocation == false)
			{
				int randomX = (int)(Math.random() * Model.gridSize.length) +1;
				int randomY = (int)(Math.random() * Model.gridSize[0].length) +1;
				
				boolean good = true;
				for(int j = 0; j < GameMethods.getActorArrayList().size(); j++)
				{
					if(((Actor) GameMethods.getActorArrayList().get(j)).getName().equals("Algae"))
					{
						if(((Actor) GameMethods.getActorArrayList().get(j)).getX() == randomX || ((Actor) GameMethods.getActorArrayList().get(j)).getY() == randomY)
						{
							good = false;
						}
					}
				}
				if(good == true)
				{
					foundGoodLocation = true;
				}
				
			}

			
			
			Algae al = new Algae(randomX, randomY);
		}
		
	}
}
