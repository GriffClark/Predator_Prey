import java.util.ArrayList;
	import java.awt.*;
	import javax.swing.*;
	import java.awt.event.*;
	import javax.swing.JButton; //imports JButton library
	import java.awt.GridLayout; //imports GridLayout library
	import java.util.ArrayList;

	public class View{
		
		public JPanel grid = new JPanel(); // GRID/PANEL FOR GRIFFIN TO MAKE THE GRID, BOUNDARIES CAN BE FOUND UNDER LINE VVVVVV
		
		
		public boolean playbool;
		public boolean pausebool;
		JFrame f2 = new JFrame ("Options"); //options menu frame
		public JFrame f = new JFrame ("Sharks and Minnows"); //create main frame
		public JPanel btnPanelPlay = new JPanel();//play button panel
		public JButton play = new JButton("Play");//play button button
		public JPanel btnPanelPause = new JPanel();//pause button panel
		public JButton pause = new JButton("Pause");//pause button
		public JPanel btnPanelReset = new JPanel();//reset button panel
		public JButton reset = new JButton("Reset");//reset button
		public JPanel btnPanelOptions = new JPanel();//option menu panel
		public JButton options = new JButton("Options");//option menu button
		
		/**
		 * using grid class figure out how to generate a view based on what the controller spits out
		 */
		public View()  {
			UserInterface();
		}
		
		
		public void UserInterface()
		{
			
			f.setLocationRelativeTo(null);
			f.setVisible(true);
			f.setSize(1920, 1080);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			f2.setLocationRelativeTo(null);
			f2.setVisible(false);
			f2.setSize(720, 720);
			f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
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
				
				//play button action listener
				
				options.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						f2.setVisible(true); //open the option frame if the option button is pressed
					}
					
				});
				
				JPanel panelGrid = new JPanel(); // creates frame
				JButton[][] grid; // names the grid of buttons
				int width = Model.getGrid().length;
				int length = Model.getGrid()[0].length;
				panelGrid.setLayout(new GridLayout(width, length)); // set layout
				grid = new JButton[width][length]; // allocate the size of grid
				int size = Model.getGameModel().copyOfActors().size();

				for (int y = 0; y < length; y++) {
					for (int x = 0; x < width; x++) {
						size = Model.getGameModel().copyOfActors().size();
						// don't think this for loop is written correctly. See if there is an actor with
						// location == grid[x][y] and if not put a *
						// shouldn't need this for loop at all
						
						boolean foundAnActor = false;
						
						for (int i = 0; i < size; i++) {
							if (Model.getGameModel().copyOfActors().get(i).getX() == x
									&& Model.getGameModel().copyOfActors().get(i).getY() == y && foundAnActor == false) {
								grid[x][y] = new JButton(new ImageIcon(Model.getGameModel().copyOfActors().get(i).image)); // this
																															// should
																															// put
																															// the
																															// image
																															// on
																															// the
																															// button

								foundAnActor = true;
							}
						}
						if (foundAnActor == false) {
							grid[x][y] = new JButton(String.valueOf(Controller.stepsTaken)); // creates new button
						}
						panelGrid.setBounds(400,400,1000,1000);
						panelGrid.add(grid[x][y]);
						panelGrid.setVisible(true);
						// tried to add a frame
					}
				}
				
				
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
				
				f.add(panelGrid);
	//_______________________________________________________________________________________________________________________________________			
				
			
				

				
			}
		
		//public void grid() {
//			 JPanel grid = new JPanel();
//			 JButton test = new JButton();
//			grid.setBounds(200, 200, 1200, 1200);
//			test.setBounds(0, 0, 1199, 1199);
//			Controller.mainJFrame.getf().add(grid);
//			Controller.mainJFrame.getf().add(test);
//					btnPanelPlay.setBounds(157, 12, 201, 81);
//			      play.setBounds(0, 0, 200, 80);
			
			
		
			

		
		public JFrame getf() {
			return f;
		}

		
		//getters for buttons
		
		public JButton getPlaybtn() {
			return play;
		}
		public JButton getPausebtn() {
			return pause;
			}
		public JButton getResetbtn() {
			return reset;
			}
		public JButton getOptionsbtn() {
			return options;
			}
		
		//getters for panels
		
		public JPanel getPlayPnl() {
			return btnPanelPlay;
			}
		public JPanel getPausePnl() {
			return btnPanelPause;
			}
		public JPanel getResetPnl() {
			return btnPanelReset;
			}
		public JPanel getOptionsPnl() {
			return btnPanelOptions;
			}
		
		
		
	}

