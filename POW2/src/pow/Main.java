package pow;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		// rounds of the game
		int rounds = 30;
		
		//Used and essential
		String check;

		// The players inventory
		Inventory playerInv = new Inventory(0, 0, 0, 0, 0);

		// Core of the game. Makes new rounds.
		for (int currentRound = 1; currentRound <= rounds; currentRound++) {

			// create a new event card for this round
			Event stuff = new Event();

			// recieves user input
			Scanner scan = new Scanner(System.in);
			do {

				// Prints out the Round Box and the Number of Freed/Killed
				// prisoners.
				System.out.println(" ---------------------");

				if (currentRound < 10) {
					System.out.println("|      Round: " + currentRound
							+ "       |");
				} else {
					System.out.println("|      Round: " + currentRound
							+ "      |");
				}
				System.out.println("| Freed Prisoners: " + Event.savedPrisoners
						+ "  |");
				System.out.println("| Killed Prisoners: "
						+ Event.killedPrisoners + " |");
				System.out.println(" ---------------------\n");

				// Prints out the number of prisoners in the camp at the
				// beginning of the round (value for prisoners).
				System.out
						.println("Number of prisoners still in the camp at the beginning of the round: "
								+ (Event.prisoners - Event.killedPrisoners - Event.savedPrisoners));

				// Prints out the name of the event card.
				System.out.println(stuff.getTitle());

				// If the num for inventory position is not zero, the item will
				// be placed into the players inventory.
				if (stuff.getInventoryPosition() != 0)
					playerInv.addItem(stuff.getInventoryPosition());

				// If the event card automatically frees a prisoner, Save one
				// prisoner, and print it out.
				if (stuff.getFreesAPrisoner() == true) {
					Event.savedPrisoners++;
					System.out.println("A prisoner was freed.");
				}

				// Kill or Save Prisoners
				stuff.killSavePrisoners();

				// System.out.println("Inventory :: " + playerInv.toString());

				// If there are no more prisoners left, end the game.
				if (Event.prisoners <= 0
						|| (Event.killedPrisoners + Event.savedPrisoners) >= 10) {
					System.out
							.println("There are no more prisoners in the camp.\nPress y to end the game.");
					currentRound = 31;
				}

				// Else, Do you want to go to the next turn?
				else{
					System.out
							.println("Do you want to go to the next turn?(y/n)");

				}
				check = scan.next();
			} while (!(check.equalsIgnoreCase("y")));
			//scan.close();
		}
		System.out.println(" ---------------------");
		System.out.println("    - Game Over -     ");
		System.out.println(" ---------------------");
		System.out
				.println("|  Freed Prisoners: " + Event.savedPrisoners + " |");
		System.out.println("|  Dead Prisoners: " + Event.killedPrisoners
				+ "  |");
		System.out.println(" ---------------------");
		if(Event.savedPrisoners>Event.killedPrisoners){
			System.out.println("|      You Win!       |");
		}else{
			System.out.println("|      You Lose!      |");
		}
		System.out.println(" ---------------------");
	}
}
