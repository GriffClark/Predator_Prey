import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import java.awt.Dimension;

public class LineGraph extends ApplicationFrame {
	
	private Record population = new Record(1,2,1,1); //put numbers in here or use a different record object
	private Dimension chartSize = new Dimension(560,367);
	private int steps = population.getStep();

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
		/* series1.add(0, 3);
		series1.add(1, 6);
		series1.add(2, 9);
		series1.add(3, 12);
		series1.add(4, 15);
		series1.add(5, 18);
		series1.add(6, 21);
		series1.add(7, 24); */
		for (steps = 0; steps < 100; steps++ ) {
			series1.add(steps, population.getShark());
		}
		
		final XYSeries series2 = new XYSeries("Minnows");
		/* series2.add(0, 5);
		series2.add(1, 10);
		series2.add(2, 15);
		series2.add(3, 20);
		series2.add(4, 25);
		series2.add(5, 30);
		series2.add(6, 35);
		series2.add(7, 40); */
		for (steps = 0; steps < 100; steps++ ) {
			series2.add(steps, population.getMinnow());
		}
		
		final XYSeriesCollection testset = new XYSeriesCollection();
		testset.addSeries(series1);
		testset.addSeries(series2);
		return testset;
	/* private DefaultCategoryDataset createDataset() {
		DefaultCategoryDataset testset = new DefaultCategoryDataset();
		testset.addValue(7, "Population", "Step 0");
		testset.addValue(14, "Population", "Step 1");
		testset.addValue(21, "Population", "Step 2");
		testset.addValue(28, "Population", "Step 3");
		testset.addValue(35, "Population", "Step 4");
		testset.addValue(42, "Population", "Step 5");
		testset.addValue(49, "Population", "Step 6");
		testset.addValue(56, "Population", "Step 7");
		return testset; */
	}
	
	public static void main (String[] args) {
		LineGraph testChart = new LineGraph("Sharks and Minnows Simulation", "Shark/Minnow Population over time");
		testChart.pack();
		RefineryUtilities.centerFrameOnScreen(testChart);
		testChart.setVisible(true);
	}
}


/* Things To Do
 * 1. Figure out how to use the getter methods in the record class to make the graph work (requires a predefined Record object)
 * 2. Maybe use a for loop to initialize each XYSeries. To do this, use index or steps for x-variable and getter methods of sharks/minnows for y-variable*/
