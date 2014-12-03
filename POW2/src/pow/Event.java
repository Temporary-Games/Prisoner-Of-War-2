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

	/*
	 * Number of Prisoners
	 */
	public int prisoners = 100;

	int inventoryPosition = 0;

	public Event() throws FileNotFoundException {
		// event reads in an event from "events.txt"
		Scanner event = new Scanner(new File("data/events.txt"));
		// Test call of the event.txt file
		int x = (int) (Math.random() * 3);
		for (int i = 0; i < x; i++) {
			event.nextLine();
		}

		inventoryPosition = event.nextInt();

		title = event.next().replace('_', ' ');

		guardAggression += event.nextInt();

		boolean freesAPrisoner = event.nextBoolean();

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
	
	public int getGuardAggression(){
		return guardAggression;
	}

	
	//unfinished method!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public void killSavePrisoners() {
		System.out.println("Guard Aggression: " + guardAggression);
		int save = 0;
		int kill = 0;
		// Kill Prisoners
		if (guardAggression >= 10) {
			int count = 0;
			for (guardAggression -= 10; guardAggression == 0; guardAggression -= 10) {
				prisoners -= 1;
				kill++;
			}
		}

		// Save Prisoners
		if (guardAggression <= -10) {
			int count = 0;
			for (guardAggression += 10; guardAggression == 0; guardAggression += 10) {
				prisoners += 1;
				save++;
			}
		}
		
		System.out.println(save + " prisoners were saved.");
		System.out.println(kill + " prisoners were killed.");
		
	}

	public int getNumPrisoners() {
		return prisoners;
	}

}
