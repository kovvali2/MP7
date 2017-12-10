package CYOA;

public class Di {
	public int numSides;
	public int target;
	
	public Di(int side, int target){
		this.numSides = side;
		this.target = target;
	}
	
	/**
	 * Returns a random value on [1,numSides]
	 * 
	 */
	public int roll() {
		double value = Math.random() * numSides;
		return ((int) value) + 1; 
	}
	
	public boolean check() {
		int a = this.roll();
		System.out.println("You rolled a "+a);
		if (a >= this.target) {
			return true;
		}
		return false;
	}
}
