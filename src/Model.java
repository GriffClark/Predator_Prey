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
	private ArrayList<Actor> actors = new ArrayList<Actor>();
	private ArrayList<Record> recordLibrary = new ArrayList<Record>();
	private int stepsComplete=0;
	public static int desiredSteps=0;

	public Record getRecentRecord()
	{
		if(recordLibrary.size() > 0)
		{
			Record r;
			r = (recordLibrary.get(recordLibrary.size() - 1)); //should get the last record 
			return r;
			
		}
		else
		{
			return null;
		}
		
	}
	//trying to make this easy to see
	public static int[][] gridSize = new int[50][50];
	public static int nutritionMinnowsStartWith = 2;
	public static int nutritionSharksStartWith = 4;
	public static int setSharkSpeed = 2;
	public static int setMinnowSpeed = 1;
	public static int numberOfSharks = 0;
	public static int numberOfMinnows =0;
	public static int numberOfAlgae = 0; //a function of the number of Minnows?
	public static int halfLife = 3; //how many steps it takes algae to reproduce	

	
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
	
	public static void addActor(Actor actor)
	{
		singleModel.actors.add(actor);
		
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
		//nullPointerException error here
		if(singleModel.actors.size() > 0)
		{
			return singleModel.actors.size();

		}
		return 0;
	}
	
	
	
	public void CompleteStep(int step, ArrayList<Actor> localActors)
	{
		
		Controller.stepsTaken += 1;
		GameMethods.subractNutrition();
		
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
			
			
			actors.removeAll(actors); //this should clear actors
			
			for(int j = 0; i < localActors.size(); i++)
			{
				actors.add(localActors.get(i));
				//updates actors
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
