import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class View{

	/**
	 * using grid class figure out how to generate a view based on what the controller spits out
	 */
	public View()  {
		UserInterface();
	}
	
	
	
	public void UserInterface()
	{
		JPanel p = new JPanel(); //create panel, I don't know if the order of creating of the panel or frame first matters, but it works so

		
		JFrame f = new JFrame ("Sharks and Minnows"); //create frame
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setSize(1920, 1080);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		 	//add the image to the JFrame "f"
			f.setLayout(new BorderLayout());
		    f.setContentPane(new JLabel(new ImageIcon("UIPNG.png")));
		    f.setLayout(new FlowLayout());
		    //test button/label to make sure they show up as desired on the background, will be deleted later
		    JLabel l1=new JLabel("Here is a button");
		    JButton b1=new JButton("I am a button");
		    f.add(l1);
		    f.add(b1);
		    
		    f.setSize(399,399);//refreshes the frame (NEEDS THIS!)
		    f.setSize(1920,1080);
		
		p.add(b1);
		p.add(l1);
		
		f.add(p);
		}
}





















//Grid charGrid = new Grid(Model.gridSize);
//	GameStatus currentStatus = Model.getCurrentStatus(); //should get the status of Model.singleModel
//	Model localModel = Model.getGameModel();
//	ArrayList<Actor> localActors = new ArrayList<Actor>();
	
//	for (int i = 0; i < Model.getActorsSize(); i++)
//	{
//		localActors.add((Actor) localModel.copyOfActors().get(i)); //cast should have no effect
//	}
	
//	for(int i = 0; i < localActors.size(); i++)
//	{
//		charGrid.placeCharAtLocation(localActors.get(i).getAskiiRep(), localActors.get(i).getX(), localActors.get(i).getY());
//	}
	
//	charGrid.printGrid();