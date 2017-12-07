package CYOA;
import java.util.*;

public class MedievalAdventure implements Adventure {
	private Node start;
	private String playerName;
	static Scanner myScan = new Scanner(System.in);
	
	public void embark() {
		System.out.println(this.start.play());
	}
	
	public void namePlayer() {
		System.out.println("Please enter a name for your character");
		this.playerName = myScan.nextLine();
	}
	
	public MedievalAdventure() {
		this.namePlayer();
		String[] startOptions = new String[]{"Go home", "Go to the castle", "Go to the pub", "Stay here"};
		Node home = new Node("You are at the castle");
		Node castle = new Node("You are at the castle");
		Node pub = new Node("You are at the pub");
		Node here = new Node("You are here");
		Node[] startContinue = new Node[] {home, castle, pub, here};
		this.start = new Node("Welcome to medieval times " + playerName +"!\n"
				+             "You are a knight who is currently in the town square.\n"
				+ "What do you want to do?", startOptions, startContinue);
		
	}
	
}
