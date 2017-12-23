
public class GameMethods {
	
	/*
	 * Holds the methods that Game will use
	 * pause/play
	 * speed up
	 * stop
	 * get info (displays no. of animals)
	 * reset
	 * customize grid
	 * cusomise animals
	 */
	
	public static int getDistance(Actor a, Actor b)
	{
		//returns the distance of two actors from each other
		double dis;
		int x1 = a.getX();
		int y1 = a.getY();
		int x2 = b.getX();
		int y2 = b.getY();
		
		dis=Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
		//double check my math
		
		int valueToBeReturned = (int)(dis + 0.5); //this should take care of rounding properly too
		return valueToBeReturned;
		 
	}
	
	
	public static boolean makeValidMove(Animal animal, int[][] moveRequest) //this methods takes an animal that wants to move and checks if the move it wants to make is valid. If it is, it makes the move and returns true. Otherwise, it returns false
	{//this move request will be the result of calling  Animal.genreateMoveRequest()
		if(Grid.isLocationEmpty(moveRequest) == true) //so if the location on the grid is empty
		{
			animal.setLocation(moveRequest);
			return true;
		}
		else //if there is already someone at that location
		{
			return false;
		}
	} //also not sure that this belongs in GameMethods and not in Animal
	
	public static void record()
	{
		int sharks = 0;
		int minnows = 0;
		int algae = 0;
		for (int i = 0; i < Game.everything.size(); i++)
		{
			String thisString = Game.everything.get(i).getName();
			switch( thisString )
			{
			case "Shark": sharks++; break;
			case "Minnow": minnows++; break;
			case "Algae": algae++; break;			
			} //need to test this
		}
		
		Game.sharks[Game.steps] = sharks;
		Game.minnows[Game.steps] = minnows;
		Game.algae[Game.steps] = algae;
		
		//no idea if this method of accounting data works or not
	}
	

}
