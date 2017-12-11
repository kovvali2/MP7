package CYOA;

import java.util.Scanner;

public class Node {
	static Scanner myScan = new Scanner(System.in);
	public String text;
	public String[] choices;
	public enum NodeType{
		TEXT,
		DICE,
		CHOICE
	}
	private NodeType type;
	private Node next;
	public Di dice;
	
	public Node(NodeType type, String line, Node next) {
		this.type = NodeType.TEXT;
		this.text = line;
		this.next = next;
		System.out.println(line);
	}
	
	public Node(NodeType type, String line, String[] options, Node next) {
		this.type = NodeType.CHOICE;
		this.text = line;
		this.choices = options;
		this.next = next;
		System.out.println(line);
	}
	
	public Node(NodeType type, String line, Di die, Node next) {
		this.type = NodeType.DICE;
		this.text = line;
		this.dice = die;
		this.next = next;
		System.out.println(line);
	}
	
	public void setNext(Node next) {
		this.next = next;
	}

	public void printOptions() {
		for (int i = 0; i < choices.length; i++) {
			System.out.println(i + 1 + ": " + choices[i]);
		}
	}
}
