import java.io.IOException;
import java.util.ArrayList;

public class StrippedDownModel {
	
	public static int[][] gridSize = new int [5][5];
	
	public static ArrayList<Actor> actors = new ArrayList<Actor>();
	
	public static void addMinnow() throws IOException {
		Minnow m = new Minnow (StrippedDownModel.generateValidLocation(),Model.getGameModel().getNutritionMinnowsStartWith());
		StrippedDownModel.actors.add(m);
	}
	
	public static void addShark() throws IOException{
		Shark s = new Shark (StrippedDownModel.generateValidLocation(),Model.getGameModel().getNutritionSharksStartWith());
		StrippedDownModel.actors.add(s);
	}
	
	public static void addAlgae() throws IOException
	{
		Algae a = new Algae (StrippedDownModel.generateValidLocation(), 5);
		StrippedDownModel.actors.add(a);
	}
	
	public static Location generateValidLocation() //have a second version that takes a location and will test for only valid locations. Pass in current location and speed
	{
		int[][] useMe = StrippedDownModel.gridSize;
		int rows = useMe.length; 
		int cols = useMe[0].length;
		
		ArrayList<Actor> localActors = new ArrayList<Actor>();
		int numberOfActors = StrippedDownModel.actors.size();
		for(int i = 0; i < numberOfActors; i++)
		{
			localActors.add((Actor) StrippedDownModel.actors.get(i));
		}
		Location finalLocation = null;
		
		while(finalLocation == null)
		{
			int randomX = (int)(Math.random() * rows);
			int randomY = (int)(Math.random() * cols);
			Location testLocation = new Location(randomX, randomY );
			boolean isTestLocationValid = true;
			
			for(int i = 0; i < localActors.size(); i++)
			{
				if(testLocation == localActors.get(i).getLocation())
				{
					isTestLocationValid = false;
				}
				
			}
			if(isTestLocationValid == true)
			{
				finalLocation = testLocation;
			}
			
		}

		return finalLocation;
		
	}

}
