package pow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Event {

	// Names the card, such as "You find a chocolate bar!"
	String title;

	/*
	 * How it affects the overall prison-guard anger. Can be positive or
	 * negative. Higher is angrier.
	 */
	public static int guardAggression;

	/*
	 * If this is true, the event will display the title and instantly free a
	 * prisoner. The card will not be added to the Player's inventory.
	 */
	boolean freesAPrisoner;

	// Inventory Position of an item (This instance variable is useless until
	// set, in the Event constructor
	int inventoryPosition = 0;

	// Number of Prisoners
	public static final int prisoners = 10;

	// Number of prisoners killed
	public static int killedPrisoners;

	// Number of saved prisoners.
	public static int savedPrisoners;

	public Event() throws FileNotFoundException {
		// event reads in an event from "events.txt"
		Scanner event = new Scanner(new File("data/events.txt"));
		// Test call of the event.txt file
		int x = (int) (Math.random() * 7);
		for (int i = 0; i < x; i++) {
			event.nextLine();
		}

		inventoryPosition = event.nextInt();

		title = event.next().replace('_', ' ');

		guardAggression += event.nextInt();

		freesAPrisoner = event.nextBoolean();

	}

	public String getTitle() {
		return title;
	}

	public boolean getFreesAPrisoner() {
		return freesAPrisoner;
	}

	public int getInventoryPosition() {
		return inventoryPosition;
	}

	public int getGuardAggression() {
		return guardAggression;
	}

	public void killSavePrisoners() {
		System.out.println("Guard Aggression: " + guardAggression);
		int save = 0;
		int kill = 0;
		// Kill Prisoners
		if (guardAggression >= 10) {
			for (int x = guardAggression; x >= 10; x -= 10) {
				killedPrisoners++;
				kill++;
			}
			System.out.println(kill + " prisoner(s) were killed.");
			guardAggression = 0;
		}

		// Save Prisoners
		else if (guardAggression <= -10) {
			for (int y = guardAggression; y < -10; y += 10) {
				savedPrisoners++;
				save++;
			}
			System.out.println(save + " prisoner(s) were freed.");
			guardAggression = 0;
		}

		// If not above 10 or below 10
		else {
		}
	}

}
