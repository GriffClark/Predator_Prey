import java.awt.image.BufferedImage;

public class Algae extends Actor{

	public Algae(Location location) {
		super(location);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void doThings()
	{
		//for each algae make another algae at a location that does not already contain an algae
		String specification = "Algae";
		int numberOfAlgae = GameMethods.getActorOfSpecifiedType(specification).size(); //should get the number of algae
		
		for(int i = 0; i < numberOfAlgae; i++) //stupid question but is it < or <=
		{
			int randomX = 0;
			int randomY = 0;
			boolean foundGoodLocation = false;
			while(foundGoodLocation == false)
			{
				randomX = (int)(Math.random() * Model.gridSize.length) +1;
				randomY = (int)(Math.random() * Model.gridSize[0].length) +1;
				
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
				//should keep searching for new valid location until it finds one
			}

			
			
			Algae al = new Algae(randomX, randomY);
			
			Model.algaeHolder.add(al);
		}
		
	}
}
