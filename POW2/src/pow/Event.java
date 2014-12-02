package pow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Event {

	//Names the card, such as "You find a chocolate bar!"
	String title;
	
	/* 
	 * How it affects the overall prison-guard anger.
	 * Can be positive or negative. Higher is angrier.
	 * 
	 */
	int guardAggression;
	
	/*
	 * If this is true, the event will display the title and
	 * instantly free a prisoner.  The card will not be added
	 * to the Player's inventory.
	 * 
	 */
	boolean freesAPrisoner;
	
	/*
	 * If this is true, the card can be stored in your inventory
	 * and used when a "bribable" card comes up.  (E.g. "Chocolate Bar"
	 * would be a bribe and could be used on an "Aggressive Guard" card
	 * which would be "bribable")
	 * 
	 */

	int inventoryPosition = 0;
	
	public Event() throws FileNotFoundException {
		//event reads in an event from "events.txt"
		Scanner event = new Scanner(new File("data/events.txt"));
		//Test call of the event.txt file
		int x = (int)(Math.random()*3);
		for(int i = 0; i< x; i++){
			event.nextLine();
		}
		
		inventoryPosition = event.nextInt();
		
		title = event.next().replace('_', ' ');

		guardAggression = event.nextInt();

		
		boolean freesAPrisoner = event.nextBoolean();

		
		
	}
	
	public String getTitle(){
		return title;
	}
	public int getGuardAggression(){
		return guardAggression;
	}
	public boolean getFreesAPrisoner(){
		return freesAPrisoner;
	}
	public int getInventoryPosition(){
		return inventoryPosition;
	}
	
}



