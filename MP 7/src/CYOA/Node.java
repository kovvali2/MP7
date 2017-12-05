package CYOA;

import java.util.Scanner;

public class Node {
	static Scanner myScan = new Scanner(System.in);
	private String text;
	private String[] choices;
	public enum NodeType{
		TEXT,
		DICE,
		CHOICE,
		ENDING
	}
	private NodeType type;
	private Node[] next;
	private Roll dice;
	public Node() {
		
	}
	
	public Node(String line) {
		this.type = NodeType.ENDING;
		this.text = line;
	}
	
	public Node(String line, Node cont) {
		this.type = NodeType.TEXT;
		this.text = line;
		this.next = new Node[] {cont};
	}
	
	public Node(String line, String[] options, Node[] cont) {
		this.type = NodeType.CHOICE;
		this.text = line;
		this.choices = options;
		this.next = cont;
	}
	
	public Node(String line, Roll die, Node[] cont) {
		this.type = NodeType.DICE;
		this.text = line;
		this.dice = die;
		this.next = cont;
	}
	
	public int choice() {
		System.out.println("	" + "Please enter the number for your choice.");
		for(int i = 0; i < this.choices.length; i++) {
			System.out.println("	" + "	"+i+": "+this.choices[i]);
		}
		int selection;
		while(true) {
			selection = myScan.nextInt();
			if(selection < this.choices.length) {
				break;
			} else {
				System.err.println("<invalid input please enter again>");
			}
		}

		return selection;
	}
	
	public String play() {
		if(this.type == NodeType.ENDING) {
			return this.text;
		}
		System.out.println(this.text);
		
		switch(type) {
		case TEXT:
			System.out.println("	" + "Press Enter/Return to continue");
			myScan.nextLine();
			return this.next[0].play();
			
		case DICE:
				System.out.println(this.dice);
				myScan.nextLine();
				return this.next[this.dice.check()].play();
				
		case CHOICE:
			return this.next[this.choice()].play();
			
		default: return null;
		}
	}

}
