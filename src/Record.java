
public class Record {
	public int step;
	public int sharkNo;
	public int minnowNo;
	public int algaeNo;


	public Record(int step, int sharks, int minnows, int algae) {

		this.step = step;
		this.sharkNo = sharks;
		this.minnowNo = minnows;
		this.algaeNo = algae;
	}
	public int getStep() {
		return step;
	}
	
	public int getShark() {
		return sharkNo;
	}
	
	public int getMinnow() {
		return minnowNo;
	}
	
	public String toString()
	{
		return "at step " + step + " there were " + sharkNo  + " sharks, " + minnowNo + " minnows, and " + algaeNo + " algae";
	}

}
