/**
 * 
 * @author Griffin 
 *
 *
 *Methods here:
 *	isLocationEmpty
 *	getLength
 *	get0Length
 *	generateInitialGrid
 *	placeObject
 *	makeValidMove
 *	printGrid
 *
 *also this grid needs to be reworked to follow MVC. It should be nothing more then a visual representation of the model
 */
public class Grid {
	import javax.swing.*;
	import java.awt.*;
	/**
	 * 
	 * @author Griffin 
	 *
	 *
	 *Methods here:
	 *	isLocationEmpty
	 *	getLength
	 *	get0Length
	 *	generateInitialGrid
	 *	placeObject
	 *	makeValidMove
	 *	printGrid
	 *
	 *also this grid needs to be reworked to follow MVC. It should be nothing more then a visual representation of the model
	 */

	//https://docs.oracle.com/javase/tutorial/uiswing/layout/border.html


	public class Grid {
		public JPanel grid = new JPanel();
		public JButton test = new JButton();
		public void grid() {
			grid.setBounds(200, 200, 1200, 1200);
			test.setBounds(0, 0, 1199, 1199);
			getf().add(grid);
			getf().add(test);
			//		btnPanelPlay.setBounds(157, 12, 201, 81);
			//      play.setBounds(0, 0, 200, 80);
			
		}
		
		}




}



