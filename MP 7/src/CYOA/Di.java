package CYOA;

public class Di {
	private int numSides;
	
	public Di(int side){
		this.numSides = side;
	}
	
	/**
	 * Returns a random value on [1,numSides]
	 * 
	 */
	public int roll() {
		double value = Math.random() * numSides;
		return ((int) value) + 1; 
	}
}
