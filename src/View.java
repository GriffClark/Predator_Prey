import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class View extends JFrame{

	/**
	 * using grid class figure out how to generate a view based on what the controller spits out
	 */
	public View()  {
		UserInterface();
	}
	
	
	
	public void UserInterface()
	{
		JPanel p = new JPanel(); //
		
		JButton b1 = new JButton("testaroo");
		JLabel label = new JLabel("This is a testarino");
		
		JFrame f = new JFrame ("Sharks and Minnows"); //create frame
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setSize(1280, 720);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setLayout(new BorderLayout()); //add the background image (Doesn't work yet) work on this!
	    JLabel background = new JLabel(new ImageIcon("UIPNG.png"));
	    f.add(background);
	    background.setLayout(new FlowLayout());
		
		
		p.add(b1);
		p.add(label);
		p.add(background);
		
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