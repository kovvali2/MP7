package CYOA;

import java.util.Random;

public class Roll {
	//private String info;
	private int sides;
	private int number = 2;
	private int[] target;
	private Random myRand = new Random();
	
	public Roll(int side, int[] targets){
		this.sides = side;
		this.target = targets;
	}
	public int check() {
		return this.standard();
	}
	
	public int standard() {
		int count = 0;
		String result = "";
		for (int i = 0; i < number; i++) {
			int num = (myRand.nextInt(sides) + 1);
			count += num;
			result += " " + num;
			if (i < number - 1) {
				result += " " + "+";
			}
		}
		result += " = "+ count;
		System.out.println("	" + "You rolled:" + "\n		" + result);
		for(int i = this.target.length -1; i >= 0; i--) {
			if(count >= target[i]) {
				return i + 1;
			}
		}
		return 0;
	}
	
	public String toString() {
		String result = "	" + "Roll: " + number + "d" + sides + "\n";
		result += "	" + "Target";
		if(target.length > 1) {
			result += "s";
		}
		result += "(the higher the target you match, the better your result):";
		for (int i = 0; i < target.length; i++) {
			result += "\n" +"		" + target[i];
		}
		return result;
	}
}
