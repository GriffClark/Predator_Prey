import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
//import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.awt.Dimension;
import javax.swing.JFrame;

public class LineGraph extends JFrame {//ApplicationFrame {
	
	private Record population = Model.getGameModel().getRecentRecord(); //put numbers in here or use a different record object
	private Dimension chartSize = new Dimension(560,367);
	//private int steps = population.getStep();

	public LineGraph(String applicationTitle, String chartTitle) {
		super(applicationTitle);
		JFreeChart lineChart = ChartFactory.createXYLineChart(chartTitle, "Number of Steps", "Population", 
				createDataset(), PlotOrientation.VERTICAL, true, true, false);
		
		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(chartSize);
		setContentPane(chartPanel);
	}
	
	private XYDataset createDataset() { //add population/step numbers to this method, maybe use for loops?
		final XYSeries series1 = new XYSeries("Sharks");
		for (int i = 0; i < Model.getGameModel().getDesiredSteps(); i++ ) {
			series1.add(i, population.getSharkNo());
			//series1.updateByIndex(i, population.getSharkNo());
		}
		
		final XYSeries series2 = new XYSeries("Minnows");
		for (int i = 0; i < Model.getGameModel().getDesiredSteps(); i++ ) {
			series2.add(i, population.getMinnowNo());
			//series2.updateByIndex(i, population.getMinnowNo());
		}
		
		final XYSeriesCollection testset = new XYSeriesCollection();
		testset.addSeries(series1);
		testset.addSeries(series2);
		return testset;
	}
	
	public void showGraph() {
		LineGraph testChart = new LineGraph("Sharks and Minnows Simulation", "Shark/Minnow Population over time");
		testChart.pack();	
		RefineryUtilities.centerFrameOnScreen(testChart);
		testChart.setVisible(true);
		
	}
}

/* Things To Do
 * 1. Figure out how to use the getter methods in the record class to make the graph work (requires a predefined Record object)
 * 2. Link LineGraph and its method to the Controller class
 * 3. Might have to reinstall JFreeChart libraries on school computer */
