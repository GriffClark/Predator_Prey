/**
 * should each Actor have it's own unique ID? Is that necessary?
 */
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Actor {
	protected int nutritionValue; //for when it is eaten
	protected BufferedImage image;
	protected String name;
	protected int nutrition;
	protected boolean isAlive;
	protected Location location;
	protected char askiiRep;
	protected int UID;
	
	/*
	 * getting unhandled exception IOException and not sure how to handle it
	 */

	
	public Actor(Location location, int nutrition)
	{
		this.location = location;
		this.nutrition = nutrition;
	}

	public Actor() {
		// TODO Auto-generated constructor stub
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

	public Location getLocation()
	{
		return location;
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
		nutrition--;
	}
	
	public String toString()
	{
		return name + " " + location;
	}
	

}
