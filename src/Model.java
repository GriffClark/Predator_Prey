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
	private int desiredSteps=0;
	private int[][] gridSize = new int[50][50];
	private int nutritionMinnowsStartWith = 2;
	private int nutritionSharksStartWith = 4;
	private int setSharkSpeed = 2;
	private int setMinnowSpeed = 1;
	private int numberOfSharks = 0;
	private int numberOfMinnows =0;
	private int numberOfAlgae = 0; //a function of the number of Minnows?
	private int halfLife = 3; //how many steps it takes algae to reproduce
	
	@SuppressWarnings("static-access")
	public void setDesiredSteps(int desiredSteps)
	{
		singleModel.desiredSteps = desiredSteps;
	}
	
	public void printRecordList()
	{
		for(int i = 0; i < recordLibrary.size(); i++)
		{
			System.out.println(recordLibrary.get(i).toString());
		}
	}

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
	
	public void printRecords()
	{
		for(int i = 0; i < recordLibrary.size();i++)
		{
			System.out.println(recordLibrary.get(i).toString());
		}
	}
	//trying to make this easy to see
	

	
	/**
	 * is this method easier than just finding where to set it in the code? I think it is but not sure
	 */
	
	/* use the "singleton" design pattern to ensure that there is one one GameModel which is shared across the entire process.
     * this makes it impossible to create 2 GameModel instances by accident.
     */
	private static Model singleModel = null;
	
	public static int[][] getGrid()
	{
		return singleModel.gridSize;
	}
	
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

	
	public ArrayList<Actor> copyOfActors()
	{
		ArrayList<Actor> returnActors = new ArrayList<Actor>();
		
		for (int i = 0; i < singleModel.actors.size(); i++)
		{
			returnActors.add( singleModel.actors.get(i));
		}
		
		return returnActors;
	}
	

	
	public int getActorsSize()
	{
		return singleModel.actors.size();
	}
	
	public void addActor (Actor actor)
	{
		singleModel.actors.add(actor);
	}
	
	public Actor getActor(int index)
	{
		return singleModel.actors.get(index);
	}
	
	
	public void CompleteStep(int step, ArrayList<Actor> localActors, int localActorSize)
	{
		
		 ArrayList<Actor> temporaryStorage = new ArrayList<Actor>();
		
		Controller.stepsTaken += 1;
		int sharks = 0;
		int minnows = 0;
		int algae = 0;
		
		
		for(int i = 0; i < localActorSize; i++)
		{
			switch(localActors.get(i).getName())
			{
			case "Minnow": minnows++; break;
			case "Shark": sharks++; break;
			case "Algae": algae++; break;
			
			}
		}
			
		//everything has been accounted for 
		
		for(int j = 0; j < localActorSize; j++)
		{
			temporaryStorage.add(localActors.get(j));
			//updates actors
		}
		int tempSize = temporaryStorage.size();
		
		singleModel.actors.clear();
		for(int q = 0; q < tempSize; q++)
		{
			singleModel.actors.add(temporaryStorage.get(q));
		}
	
		
	  Record newRecord = new Record(step, sharks, minnows, algae);
	  recordLibrary.add(newRecord); //stores newStatus
	}
	
	public ArrayList<Actor> getActorOfSpecificType(String specification)
	{
		ArrayList<Actor> localActors = new ArrayList<Actor>();
		
		for(int i = 0; i < singleModel.actors.size(); i++)
		{
			if(singleModel.actors.get(i).getName().equals(specification))
			{
				localActors.add(singleModel.actors.get(i));
			}
		}
		
		return localActors;
	}
	
	public static GameStatus getCurrentStatus()
	{
		GameStatus newStatus = new GameStatus(singleModel.stepsComplete, singleModel.copyOfActors());
		return newStatus;
		//makes a copy of the current gameStatus and returns it 
			
	}

	public int getNumberOfAlgae() {
		return numberOfAlgae;
	}

	public void setNumberOfAlgae(int numberOfAlgae) {
		this.numberOfAlgae = numberOfAlgae;
	}

	public int getHalfLife() {
		return halfLife;
	}

	public void setHalfLife(int halfLife) {
		this.halfLife = halfLife;
	}

	public int getNumberOfMinnows() {
		return numberOfMinnows;
	}

	public void setNumberOfMinnows(int numberOfMinnows) {
		this.numberOfMinnows = numberOfMinnows;
	}

	public int getNumberOfSharks() {
		return numberOfSharks;
	}

	public void setNumberOfSharks(int numberOfSharks) {
		this.numberOfSharks = numberOfSharks;
	}

	public int getSetMinnowSpeed() {
		return setMinnowSpeed;
	}

	public void setSetMinnowSpeed(int setMinnowSpeed) {
		this.setMinnowSpeed = setMinnowSpeed;
	}

	public int getSetSharkSpeed() {
		return setSharkSpeed;
	}

	public void setSetSharkSpeed(int setSharkSpeed) {
		this.setSharkSpeed = setSharkSpeed;
	}

	public int getNutritionSharksStartWith() {
		return nutritionSharksStartWith;
	}

	public void setNutritionSharksStartWith(int nutritionSharksStartWith) {
		this.nutritionSharksStartWith = nutritionSharksStartWith;
	}

	public int getNutritionMinnowsStartWith() {
		return nutritionMinnowsStartWith;
	}

	public void setNutritionMinnowsStartWith(int nutritionMinnowsStartWith) {
		this.nutritionMinnowsStartWith = nutritionMinnowsStartWith;
	}

	public int getDesiredSteps() {
		return desiredSteps;
	}
	


	

}
