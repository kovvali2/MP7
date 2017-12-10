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
	private Di dice;
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
	
	public Node(String line, Di die, Node[] cont) {
		this.type = NodeType.DICE;
		this.text = line;
		this.dice = die;
		this.next = cont;
	}
	
	
	public int getUserInput(int numOptions) {
		int choice = 0;
		while (choice < 1 || choice > numOptions) {
			try {
				choice = myScan.nextInt();
				if (choice < 1 || choice > numOptions) {
					System.out.println("Please enter a number between 1 and " + numOptions);
				}
			} catch (Exception e) {
				System.out.println("Invalid Input. Please enter the number corresponding to your choice.");
			}
		}
		return choice;
	}
	
	public void setNext(Node[] next) {
		this.next = next;
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
				System.out.println("Rolling a die with " + this.dice.numSides + " sides and a target number of " + this.dice.target);
				if(this.dice.check()) {
					return this.next[1].play();
				}
				return this.next[0].play();
				
		case CHOICE:
			for (int i = 0; i < this.choices.length; i++) {
				System.out.println("	" + (i+1)+":"+" "+this.choices[i]);
			}
			int choice = getUserInput(this.next.length);
			return this.next[choice-1].play();
			
		default: return null;
		}
	}

}
