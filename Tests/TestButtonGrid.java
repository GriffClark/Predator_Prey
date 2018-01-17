import java.io.IOException;
import java.util.ArrayList;

public class TestButtonGrid {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		System.out.println("started");
		
		//a stripped down version of controller to make tests on
		StrippedDownModel.addAlgae();
		StrippedDownModel.addMinnow();
		StrippedDownModel.addShark();
		
		ArrayList<Actor> localActors = new ArrayList<Actor>(); //this should wipe it every time
		int actorSize = StrippedDownModel.actors.size();
		for (int i = 0; i < actorSize; i++)
		{
			Actor newActor =  StrippedDownModel.actors.get(i);
			localActors.add(newActor);
		}	

		int x = Model.getGrid().length;
		int y = Model.getGrid()[0].length;
		new ButtonGrid();
		int step = 0;
		for(int i = 0; i < 3; i++)
		{
			if(localActors.get(i).getIsAlive() == false)
			{
				
				localActors.remove(i);

			}
			actorSize = localActors.size();
			for(int j = actorSize - 1; j >=0; j--)
			{
				
				//can't have them actually doThings because the move method plays on model so I'll leave this blank
				
			}
			//should be a super dumbed down version of taking 3 steps
			Model.getGameModel().CompleteStep(step, localActors, actorSize);
			step++;
		}
		
		for(int i = 0; i < StrippedDownModel.actors.size(); i++)
		{
			//ik its terrible form
			System.out.println(StrippedDownModel.actors.get(i).getName());
		}
		
		System.out.println("done");
		
	}
}
