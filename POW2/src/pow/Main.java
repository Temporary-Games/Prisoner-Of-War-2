package pow;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		// rounds of the game
		int rounds = 30;

		// Used and essential
		String check;

		// The players inventory
		Inventory playerInv = new Inventory(0, 0, 0, 0, 0);

		// Receives user input
		Scanner scan = new Scanner(System.in);

		do {
			System.out.println(" ----------------------");
			System.out.println("|    Prisoner of War   |");
			System.out.println(" ----------------------");
			System.out.println("");
			System.out.println("Type \"Rules\" to view the rules.");
			System.out.println("If you already know how to play type \"Play\"");
			System.out.println("");

			check = scan.nextLine();
			// Rules and Instructions
			if (check.equalsIgnoreCase("rules")) {
				System.out
						.println("The goal of this game is to free more prisoners than are killed");
				System.out
						.println("This is achieved by going through rounds and using items.");
				System.out
						.println("When you get an item, it is placed in your inventory. Items can be used to decrease guard aggression.");
				System.out
						.println("Guard agression increases when you draw a card that has something bad on it. Ex: Riot");
				System.out
						.println("Prisoners are freed when Guard Agression gets low enough, and killed when it gets high enough.");
			}
		} while (!(check.equalsIgnoreCase("play")));

		// Core of the game. Makes new rounds.
		for (int currentRound = 1; currentRound <= rounds; currentRound++) {

			// create a new event card for this round
			Event stuff = new Event();

			// Prints out the Round Box and the Number of Freed/Killed
			// prisoners.
			System.out.println(" ----------------------");

			if (currentRound < 10) {
				System.out.println("|      Round: " + currentRound
						+ "        |");
			} else {
				System.out
						.println("|      Round: " + currentRound + "       |");
			}
			System.out.println("| Freed Prisoners: " + Event.savedPrisoners
					+ "   |");
			System.out.println("| Killed Prisoners: " + Event.killedPrisoners
					+ "  |");
			System.out.println(" ----------------------\n");

			// Prints out the number of prisoners in the camp at the
			// beginning of the round (value for prisoners).
			System.out
					.println("Number of prisoners still in the camp at the beginning of the round: "
							+ (Event.prisoners - Event.killedPrisoners - Event.savedPrisoners));

			// Prints out the name of the event card.
			System.out.println(stuff.getTitle());

			// If the num for inventory position is not zero, the item
			// will be placed into the players inventory.
			if (stuff.getInventoryPosition() != 0) {
				playerInv.addItem(stuff.getInventoryPosition());
			}

			// If the event card automatically frees a prisoner, Save one
			// prisoner, and print it out.
			if (stuff.getFreesAPrisoner() == true) {
				Event.savedPrisoners++;
				System.out.println("A prisoner was freed.");
			}

			// Kill or Save Prisoners
			stuff.killSavePrisoners();

			// Print the inventory
			System.out.print("Inventory :: ");
			for (int i = 0; i < 5; i++) {
				if (i == 0)
					System.out.print("-"
							+ playerInv.printInventory(playerInv.a) + "- ");
				if (i == 1)
					System.out.print("-"
							+ playerInv.printInventory(playerInv.b) + "- ");
				if (i == 2)
					System.out.print("-"
							+ playerInv.printInventory(playerInv.c) + "- ");
				if (i == 3)
					System.out.print("-"
							+ playerInv.printInventory(playerInv.d) + "- ");
				if (i == 4)
					System.out.print("-"
							+ playerInv.printInventory(playerInv.e) + "- ");
			}
			System.out.println("");

			// Use item (Only if the inventory is not empty)
			if (!(playerInv.a == 0 && playerInv.b == 0 && playerInv.c == 0
					&& playerInv.d == 0 && playerInv.e == 0)) {
				System.out.println("Do you want to use an item?(y/n)");
				check = scan.next();
				if (check.equalsIgnoreCase("y")) {
					System.out
							.println("Enter a number corresponding to the position of the inventory item.");
					int x = scan.nextInt();
					if (x == 1)
						playerInv.a = 0;
					else if (x == 2)
						playerInv.b = 0;
					else if (x == 3)
						playerInv.c = 0;
					else if (x == 4)
						playerInv.d = 0;
					else if (x == 5)
						playerInv.e = 0;
					Event.guardAggression -= 3;
					System.out.println("Guard Aggression has decreased by 3.");
				}
			}

			// If there are no more prisoners left, end the game.
			if (Event.prisoners <= 0
					|| (Event.killedPrisoners + Event.savedPrisoners) >= 10) {
				System.out
						.println("There are no more prisoners in the camp.\nPress y to end the game.");
				currentRound = 31;
			}

			// Else, Do you want to go to the next turn?
			else {
				System.out.println("Do you want to go to the next turn?(y/n)");
			}
			check = scan.next();
			if ((check.equalsIgnoreCase("n"))) {
				currentRound = 31;
			}

		}
		System.out.println(" ----------------------");
		System.out.println("|     - Game Over -    |");
		System.out.println(" ----------------------");

		if (Event.savedPrisoners + Event.killedPrisoners > 10) {
			Event.killedPrisoners = 10 - Event.savedPrisoners;
		}

		System.out.println("|  Freed Prisoners: " + Event.savedPrisoners
				+ "  |");
		System.out.println("|  Dead Prisoners: " + Event.killedPrisoners
				+ "   |");
		System.out.println(" ----------------------");
		if (Event.savedPrisoners > Event.killedPrisoners) {
			System.out.println("|       You Win!       |");
		} else {
			System.out.println("|       You Lose!      |");
		}
		System.out.println(" ----------------------");
		scan.close();
	}
}
