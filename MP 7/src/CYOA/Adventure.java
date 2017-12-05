package CYOA;

import CYOA.Node.NodeType;

public class Adventure {
	private Node start;
	public Adventure(Node first) {
		this.start = first;
	}
	
	public void embark() {
		System.out.println(this.start.play());
	}
	
	public static void main(String[] args) {
		Node b1 = new Node("Bad Ending");
		Node b2 = new Node("Good Ending");
		String[] choices = new String[]{"Bad","Good","Roll"};
		Node[] next = new Node[] {b1,b2};
		int[] target = {5};
		Roll sixer = new Roll(6, target);
		Node b3 = new Node("Roll for your ending", sixer, next);
		Node[] next1 = new Node[] {b1,b2,b3};
		Node a1 = new Node("Pick an Ending", choices, next1);
		Node c1 = new Node("Thanks for playing this!!!", a1);
		Adventure fun = new Adventure(c1);
		fun.embark();
	}
}
