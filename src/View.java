import java.util.ArrayList;

public class View {

	/**
	 * using grid class figure out how to generate a view based on what the controller spits out
	 */
	
	public static void printGrid()
	{
		Grid charGrid = new Grid(Model.gridSize);
		GameStatus currentStatus = Model.getCurrentStatus(); //should get the status of Model.singleModel
		Model localModel = Model.getGameModel();
		ArrayList<Actor> localActors = new ArrayList<Actor>();
		
		for (int i = 0; i < Model.getActorsSize(); i++)
		{
			localActors.add((Actor) localModel.copyOfActors().get(i)); //cast should have no effect
		}
		
		for(int i = 0; i < localActors.size(); i++)
		{
			charGrid.placeCharAtLocation(localActors.get(i).getAskiiRep(), localActors.get(i).getX(), localActors.get(i).getY());
		}
		
		charGrid.printGrid();
	}
}
