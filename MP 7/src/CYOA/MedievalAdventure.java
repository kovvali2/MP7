package CYOA;
import java.util.*;

public class MedievalAdventure implements Adventure {
	private String playerName;
	private static Scanner myScan = new Scanner(System.in);
	
	public void embark() {
		String[] startOptions = new String[]{"Go home", "Go to the castle", "Go to the pub", "Stay here"};
		Node start = new Node(Node.NodeType.CHOICE, "Welcome to medieval times " + playerName +"!\n"
				+             "You are a knight who is currently in the town square.\n"
				+ "What do you want to do?", startOptions, null);
		start.printOptions();
		int choice = getUserInput(start.choices.length);
		
		switch (choice) {
			case 1: goHome();
					break;
			case 2: goToCastle();
					break;
			case 3: goToPub();
					break;
			case 4: stayHere();
					break;
		}
	}
	
	public void goHome() {
		Node home = new Node(Node.NodeType.TEXT, "You are at your home.", null);
		String[] choices = {"Yes", "No"};
		Node goHome = new Node(Node.NodeType.CHOICE, "You go home and see that your wife has left a cake for you on the table. Do you eat it?", choices, null);
		goHome.printOptions();
		int choice = getUserInput(choices.length);
		switch (choice) {
		case 1: eatCake();
				break;
		case 2: dontEatCake();
				break;
		}
	}
	
	public void eatCake() {
		Node cake = new Node(Node.NodeType.TEXT, "You sit down and eat the cake. You start to feel queasy! You see a note next to the cake! \n It says: \"Greetings from your enemies! Please enjoy our poison!\" You die on the floor", null);
		endGame();
	}
	
	public void dontEatCake() {
		Node noCake = new Node(Node.NodeType.TEXT, "You choose to go to bed instead. You get a good night's sleep and go to work the next day. You live happily ever after.", null);
		endGame();
	}
	
	public void goToCastle() {
		Node castle = new Node(Node.NodeType.TEXT, "You are at the castle", null);
		String[] choices = {"Yes", "No"};
		Node visitKing = new Node(Node.NodeType.CHOICE, "You see the King sitting on his throne. Do you go and say hi?", choices, null);
		visitKing.printOptions();
		int choice = getUserInput(choices.length);
		switch (choice) {
		case 1: seeKing();
				break;
		case 2: dontSeeKing();
				break;
		}
	}
	
	public void seeKing() {
		Node die = new Node(Node.NodeType.TEXT, "You go and see the King. However, you forgot that you are still carrying your knife in your hand from earlier. \n The guards think you are trying to assassinate the King! You are then arrested.", null);
		endGame();
	}
	
	public void dontSeeKing() {
		Node live = new Node(Node.NodeType.TEXT, "You choose not to see the king and instead attend the feast. You eat lots of food and go home that night feeling happy", null);
		endGame();
	}
	
	public void goToPub() {
		Node pub = new Node(Node.NodeType.TEXT, "You are at the pub", null);
		String[] choices = {"Yes", "No"};
		Node sing = new Node(Node.NodeType.CHOICE, "You notice there is a small stage inside and remember you have exceptional singing skills. Do you go up and sing?", choices, null);
        sing.printOptions();
        int choice = getUserInput(choices.length);
        switch (choice) {
        case 1: sing();
        			break;
        case 2: dontSing();
        			break;
        }
	}
	
	public void sing() {
		Node voice = new Node(Node.NodeType.TEXT, "You go up to the stage and sing a popular song. Everyone in the pub claps for you and you live a happy life.", null);
		endGame();
	}
	
	public void dontSing() {
		Node loser = new Node(Node.NodeType.TEXT, "You decide not to sing and walk out of the bar. A wild bear is running wild through the town and it runs you over!", null);
		endGame();
	}
	public void stayHere() {
		Node stay = new Node(Node.NodeType.TEXT, "You stay where you are", null);
		String[] choices = {"Yes", "No"};
		Node here = new Node(Node.NodeType.CHOICE, "You are in the town square, another knight challenges you to a duel. Do you accept?", choices, null);
		here.printOptions();
		int choice = getUserInput(choices.length);
		switch (choice){
		case 1: challengeKnight();
				break;
		case 2: scaredycat();
				break;
		}
	}
	
	public void challengeKnight() {
		Di fight = new Di(12, 8);
		Node challenge = new Node(Node.NodeType.DICE, "You challenge the knight", fight, null);
		if (challenge.dice.check()) {
			Node win = new Node(Node.NodeType.TEXT, "You beat the knight in a duel! The crowd carries you off to the castle to be rewarded.", null);
			endGame();
		}
		else {
			Node lose = new Node(Node.NodeType.TEXT, "The knight killed you :( The crowd leaves your body on the ground until the end of time", null);
			endGame();
		}
	}
	
	public void scaredycat() {
		Node wimp = new Node(Node.NodeType.TEXT, "The crowd boos as you walk away from a challenge. You get forced out of the village and you receive a letter from the crown that says you are forever banished from this region.", null);
		endGame();
	}
	
	public void endGame() {
		System.out.println("THE END");
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
	
	public MedievalAdventure(String playerName) {
		this.playerName = playerName;
	}
	
}
