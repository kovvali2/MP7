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
		this.start = new Node("Welcome to medieval times " + playerName +"!\n"
				+             "You are a knight who is currently in the town square.\n"
				+ "What do you want to do?", startOptions, null);
		Node home = new Node("You are at your home.");
		Node castle = new Node("You are at the castle");
		Node pub = new Node("You are at the pub");
		Di townSquare = new Di(20, 7);
		Node win = new Node("You won the duel");
		Node lose = new Node("You lost the duel");
		Node[] hereOptions = {lose, win};
		Node here = new Node("You are in the town square, another knight challenges you to a duel.", townSquare, hereOptions);
		Node[] startContinue = new Node[] {home, castle, pub, here};
		this.start.setNext(startContinue);
		

		
	}
	
}
