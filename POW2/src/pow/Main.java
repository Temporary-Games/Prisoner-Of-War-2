package pow;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	// rounds of game

	public static void main(String[] args) throws FileNotFoundException {
		int rounds = 30;
		int savedPrisoners = 0;
		Inventory playerInv = new Inventory(0, 0, 0, 0, 0);
		for (int currentRound = 1; currentRound <= rounds; currentRound++) {
			Event stuff = new Event();
			Scanner scan = new Scanner(System.in);
			do {
				System.out.println("Round: " + currentRound);
				System.out.println("Freed Prisoners: " + savedPrisoners);
				System.out.println(stuff.getTitle());
				if (stuff.getInventoryPosition() != 0)
					playerInv.addItem(stuff.getInventoryPosition());
				if (stuff.getFreesAPrisoner() == true) {
					savedPrisoners++;
					System.out.println("A prisoner was saved.");
				}

				//System.out.println("Inventory :: " + playerInv.toString());

				// Number of prisoners
				System.out.println("Number of prisoners still alive: "
						+ stuff.getNumPrisoners());

				// Kill or Save Prisoners
				stuff.killSavePrisoners();

				// Do you want to go to the next turn?
				System.out.println("Do you want to go to the next turn?(y/n)");

			} while (!(scan.nextLine().equalsIgnoreCase("y")));

		}

	}
}
