package CYOA;
import java.util.*;

public class MedievalAdventure implements Adventure {
	Scanner scan;
	public void embark() {
		scan = new Scanner(System.in);
		System.out.println("Welcome to medieval times! What would you like to do?\n"
							+ "\t 1. Go home\n"
							+ "\t 2. Go to the castle\n"
							+ "\t 3. Go to the pub\n"
							+ "\t 4. Stay here");
		int choice = getUserInput(4);
		System.out.println("You chose choice " + choice);
		/*REST OF ADVENTURE GOES HERE. WE CAN ADD IN RANDOM STUFF WITH THE DI CLASS AS WELL AS ATTACKS AND OTHER THINGS*/
	}
	
	public int getUserInput(int numOptions) {
		int choice = 0;
		while (choice < 1 || choice > numOptions) {
			try {
				choice = scan.nextInt();
				if (choice < 1 || choice > numOptions) {
					System.out.println("Please enter a number between 1 and " + numOptions);
				}
			} catch (Exception e) {
				System.out.println("Invalid Input. Please enter the number corresponding to your choice.");
			}
		}
		return choice;
	}
}
