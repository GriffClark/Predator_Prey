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
	
	
	public JFrame f = new JFrame ("Sharks and Minnows"); //create frame
	public JPanel btnPanelPlay = new JPanel();
	public JButton play = new JButton("Play");
	public JPanel btnPanelPause = new JPanel();
	public JButton pause = new JButton("Pause");
	public JPanel btnPanelReset = new JPanel();
	public JButton reset = new JButton("Reset");
	public JPanel btnPanelOptions = new JPanel();
	public JButton options = new JButton("Options");
	
	public void UserInterface()
	{
		
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setSize(1920, 1080);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		 	//add the image to the JFrame "f"
			f.setLayout(new BorderLayout());
		    f.setContentPane(new JLabel(new ImageIcon("UIPNG.png")));
		    f.setLayout(new FlowLayout());
		    //test button/label to make sure they show up as desired on the background, will be deleted later
		    
		    f.setSize(399,399);//refreshes the frame (NEEDS THIS!)
		    f.setSize(1920,1080);
		
		    //play button panel/button creation
			btnPanelPlay.setBounds(157, 12, 201, 81);
			
			
			play.setBounds(0, 0, 200, 80);
			
			//pause button panel/button creation
			
			
			btnPanelPause.setBounds(380, 12, 201, 81);
			
			
			pause.setBounds(0, 0, 200, 80);
			
			//reset button pane/button creation
			
		
			btnPanelReset.setBounds(600, 12, 201, 81);
			
			reset.setBounds(0, 0, 200, 80);
			
			//options menu button panel/button creation
			

			btnPanelOptions.setBounds(1490, 12, 411, 81);
			

			options.setBounds(0, 0, 410, 80);
			
			//initialize and set to absolute layout for each panel
			btnPanelPlay.setLayout(null);
			btnPanelPlay.add(play);
			
			btnPanelPause.setLayout(null);
			btnPanelPause.add(pause);
			
			btnPanelReset.setLayout(null);
			btnPanelReset.add(reset);
			
			btnPanelOptions.setLayout(null);
			btnPanelOptions.add(options);
			
			//actually add them to the frame
			    
			f.setLayout(null);
			f.add(btnPanelPlay);
			f.add(btnPanelPause);
			f.add(btnPanelReset);
			f.add(btnPanelOptions);
			    
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