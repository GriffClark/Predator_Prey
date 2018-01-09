import java.util.ArrayList;

/**
 * 
 * @author Griffin 
 *
 */
public class Model {
	
	public static ArrayList <Animal> totalPopulation; //is the combined populations of TotalPredator and TotalPrey
	// make sure Snubby isn't in 2 places.  You probably don't need "totalPopulation" or "everything"  
	// each animal must only be in 1 list
	//reduce
	
	/**
	 * also while this is getting cleaned up note that these shouldn't be static or public
	 */
	private ArrayList<Actor> actors;
	private ArrayList<Record> recordLibrary;
	private int stepsComplete;
	public static int desiredSteps;

	
	//trying to make this easy to see
	public static int nutritionMinnowsStartWith = 2;
	public static int nutritionSharksStartWith = 4;
	public static int setSharkSpeed = 2;
	public static int setMinnowSpeed = 1;

	
	/**
	 * is this method easier than just finding where to set it in the code? I think it is but not sure
	 */
	
	/* use the "singleton" design pattern to ensure that there is one one GameModel which is shared across the entire process.
     * this makes it impossible to create 2 GameModel instances by accident.
     */
	private static Model singleModel = null;
	
    public static Model getGameModel()
    {
      if (singleModel == null)
      {
        singleModel = new Model();
      }
      
      return Model.singleModel; //refrencing static SingletonGameModel
     }
    
    /* private contstuctor used only by singleton accessor GetGameModel */
    private Model()
    {     

	}
	
	private void addActor(String specification, int x, int y, int nutrition)
	{
		
		switch(specification)
		{
		case "Minnow": Minnow minnow = new Minnow(x,y,nutrition); 
		singleModel.actors.add(minnow);
		break;
		
		case "Shark": Shark shark = new Shark (x,y,nutrition);
		singleModel.actors.add(shark);
		break;
		
		case "Algae": Algae algae = new Algae(x,y);
		singleModel.actors.add(algae);
		break;
		}
		
		
		
		//same method should be created for minnow and algae
		
		Minnow minnow = new Minnow(x, y, nutrition);
	  actors.add(minnow);
	}
	
	public ArrayList copyOfActors()
	{
		ArrayList<Actor> returnActors = new ArrayList<Actor>();
		
		for (int i = 0; i < singleModel.actors.size(); i++)
		{
			returnActors.add( singleModel.actors.get(i));
		}
		
		return returnActors;
	}
	
	public static int getActorsSize()
	{
		//dont't want actors getting accessed directly
		return singleModel.actors.size();
	}
	
	
	/* put the rest of the "getter" functions here...*/
	
	public void CompleteStep(int step, ArrayList<Actor> localActors)
	{
		
		int sharks = 0;
		int minnows = 0;
		int algae = 0;
		
		for(int i = 0; i < localActors.size(); i++)
		{
			switch(localActors.get(i).getName())
			{
			case "Minnow": minnows++; break;
			case "Shark": sharks++; break;
			case "Algae": algae++; break;
			
			}
		}
		
	  Record newRecord = new Record(step, sharks, minnows, algae);
	  recordLibrary.add(newRecord); //stores newStatus
	}
	
	public static GameStatus getCurrentStatus()
	{
		GameStatus newStatus = new GameStatus(singleModel.stepsComplete, singleModel.copyOfActors());
		return newStatus;
		//makes a copy of the current gameStatus and returns it 
			
	}
	

	

}
