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
	public static ArrayList <Predator> totalPredators;
	public static ArrayList<Prey> totalPrey;
	public static ArrayList<Actor> everything;
	public static ArrayList<Minnow> totalMinnows;
	public static ArrayList<Shark> totalSharks;
	public static ArrayList<Actor> totalFood;
	//all of these I can use to record data [time][number of ___ ] 
	public static int[][] sharks;
	public static int[][] minnows;
	public static int[][] algae;
	
	//storing the gameStatus here
	
	public static ArrayList<GameStatus> gameStatus;
	/*
	 * should I be doing all of this data management in the core or should it be done during the graphing phase?
	 * does it matter?
	 */
	
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
	private static GameModel theSingletonGameModel = null;
	
    public static GameModel getGameModel()
    {
      if (theSingletonGameModel == null)
      {
        theSingletonGameModel = new GameModel();
      }
      
      return GameModel.theSingletonGameModel; //refrencing static SingletonGameModel
     }
    
    /* private contstuctor used only by singleton accessor GetGameModel */
    private GameModel()
    {

	}
	
	private void addMinnow(int x, int y, int nutrition)
	{
		
		//same method should be created for minnow and algae
		
		Minnow minnow = new Minnow(x, y, nutrition);
	  totalMinnows.add(minnow);
	}
	
	/* put the rest of the "Add.." methods here for minnows, algae, etc */
	
	
	
	public ArrayList<Minnow> getMinnowList()
	{
		//designed to replace the Minnow ArrayList<>... and for all other actors
	  ArrayList<Minnow> copyOfMinnowList = new ArrayList<Minnow>();
	  for (int i = 0; i < everything.size(); i++) //do I want to be using everything here
	  {
	    if(everything.get(i).getName().equals("minnow"))
	    {
	    	copyOfMinnowList.add((Minnow) everything.get(i)); //the cast shouldn't have any effect but eclipse insists on it
	    	//searches all actors to figure out which are minnows. Adds the minnows
	    }
	  }
	  return copyOfMinnowList;
	}
	
	/* put the rest of the "getter" functions here...*/
	
	public void CompleteStep(int step)
	{
	  GameStatus newStatus = new GameStatus(step, totalSharks.size(), totalMinnows.size(), totalFood.size()); //if those ArrayLists are getting cut out then the method here needs to be changed, but core functionality remains the same
	  gameStatus.add(newStatus); //stores newStatus
	}
	

	

}
