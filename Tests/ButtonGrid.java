import javax.swing.JFrame; //imports JFrame library
import javax.swing.ImageIcon;
import javax.swing.JButton; //imports JButton library
import java.awt.GridLayout; //imports GridLayout library
import java.util.ArrayList;
 
public class ButtonGrid {
		public static int x;
		public static int y;
        JFrame frame=new JFrame(); //creates frame
        JButton[][] grid; //names the grid of buttons
 
        
        public ButtonGrid(){ //constructor
        	int width = 10;
        	int length = 10;
                frame.setLayout(new GridLayout(width,length)); //set layout
                grid=new JButton[width][length]; //allocate the size of grid
                int size = StrippedDownModel.actors.size();

                for(int y=0; y<length; y++){
                        for(int x=0; x<width; x++){
                        	size = StrippedDownModel.actors.size();
                        	//don't think this for loop is written correctly. See if there is an actor with location == grid[x][y] and if not put a *
                        	//shouldn't need this for loop at all
                        	boolean foundAnActor = false;
                        	for(int i = 0; i < size; i++)
                        	{
                        			if(StrippedDownModel.actors.get(i).getX() == x && StrippedDownModel.actors.get(i).getY() == y && foundAnActor == false)
                        			{
                        				grid[x][y] = new JButton(new ImageIcon (StrippedDownModel.actors.get(i).image)); //this should put the image on the button
                        				
                        				foundAnActor = true;
                        			}
                        	}
                        	if(foundAnActor == false)
                        	{
                        				grid[x][y]=new JButton("*"); //creates new button 
                        	}
                                frame.add(grid[x][y]); 
                                //tried to add a frame
                        }
                }
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack(); //sets appropriate size for frame
                frame.setVisible(true); //makes frame visible
        }
//        public static void main(String[] args) {
//                new ButtonGrid(ButtonGrid.x,ButtonGrid.y);//makes new ButtonGrid with 2 parameters
//        }
}