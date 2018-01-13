/**
 * should each Actor have it's own unique ID? Is that necessary?
 */
import java.awt.image.BufferedImage;

public class Actor {
	protected int nutritionValue; //for when it is eaten
	protected BufferedImage image;
	protected String name;
	protected boolean isAlive;
	protected Location location;
	protected char askiiRep; //this will give a rough visualization for what it will look like
	
	/*
	 * getting unhandled exception IOException and not sure how to handle it
	 */

	
	public Actor(Location location)
	{
		
	}
	
	public Actor()
	{
		
	}

	public char getAskiiRep()
	{
		return askiiRep;
	}
	public int getNutritionValue()
	{
		return nutritionValue;
	}
	
	public void getEaten()
	{
		isAlive = false;
		//so from here though I need to find a way to remove the dead thing
	}
	
	public boolean getIsAlive()
	{
		return isAlive;
	}
	
	public void setLocation(int x, int y)
	{
		this.location = new Location(x, y);
	}
	
	public void setLocation(Location location)
	{
		this.location = location;
	}
	
	public Location getLocation()
	{
		return location;
		//what is this returning, specifically?
	}
	
	public int getX()
	{
		assert(location != null); //I want the assertion to file when 
		return location.getX();
	}
	
	public int getY()
	{
		return location.getY();
	}
	
	public String getName()
	{
		return name;
	}
	
	public void doThings()
	{
		//only has an effect in Animal. Doesn't do anything here..3
		
	}
	
	public String toString()
	{
		return name + " " + location;
	}
	

}
