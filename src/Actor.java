import java.awt.image.BufferedImage;

public class Actor {
	protected int nutritionValue; //for when it is eaten
	protected BufferedImage image;
	protected String name;
	protected boolean isAlive;
	protected int[][] location;
	protected char askiiRep; //this will give a rough visualization for what it will look like

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
		this.location = new int[x][y];
	}
	
	public void setLocation(int[][] location)
	{
		this.location = location;
	}
	
	public int[][] getLocation()
	{
		return location;
	}
	
	public int getX()
	{
		return location.length;
	}
	
	public int getY()
	{
		return location[0].length;
	}
	
	public String getName()
	{
		return name;
	}
	
	
}
