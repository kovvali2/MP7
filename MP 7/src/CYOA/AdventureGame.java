package CYOA;

import java.util.Scanner;

public class AdventureGame {

	static Scanner scan;
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.println("Please enter a name for your character");
		String playerName = scan.nextLine();
		MedievalAdventure medieval = new MedievalAdventure(playerName);
		medieval.embark();
	}

}
