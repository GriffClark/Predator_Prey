import javax.swing.JFrame; //imports JFrame library
import javax.swing.ImageIcon;
import javax.swing.JButton; //imports JButton library
import java.awt.GridLayout; //imports GridLayout library
import java.util.ArrayList;

import java.awt.*;
import javax.swing.*;

public class ButtonGrid {

	/**
	 * need to make it so that it makes the same edits to one grid not makes
	 * multiple grids but thats later. It works!
	 */

	public ButtonGrid() { // constructor
		JPanel panel = new JPanel(); // creates frame
		JButton[][] grid; // names the grid of buttons
		int width = Model.getGrid().length;
		int length = Model.getGrid()[0].length;
		panel.setLayout(new GridLayout(width, length)); // set layout
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
				panel.add(grid[x][y]);
				// tried to add a frame
			}
		}

	}
	// public static void main(String[] args) {
	// new ButtonGrid(ButtonGrid.x,ButtonGrid.y);//makes new ButtonGrid with 2
	// parameters
	// }
}