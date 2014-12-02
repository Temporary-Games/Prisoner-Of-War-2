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
	boolean bribe;
	
	/*
	 * If this is true the card can be used to free a prisoner when
	 * provided with a "bribe" card.  See "bribe" comment for description
	 * 
	 */
	boolean bribeable;
	
	/*
	 * If not 0, if it has a non-zero number, it will equal to a certain value
	 * of the inventory class array
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
		int inventoryPos = event.nextInt();
		if(inventoryPos!=0)
			System.out.print("Name: You found a ");
		else
			System.out.print("Name: ");
		
		System.out.println(event.next().replace('_', ' ')); 
		System.out.println("Guard Aggression: " + event.nextInt()); 
		bribe = event.nextBoolean();
		System.out.println("Bribe: " + bribe); 
		
		bribeable = event.nextBoolean();
		System.out.println("Bribeable: " + bribeable); 
		
		boolean freesAPrisoner = event.nextBoolean();
		System.out.println("Does it Free A Prisoner: " + freesAPrisoner); 
		
		//int inventoryPos = event.nextInt();
		System.out.println("Inventory Number: " + inventoryPos);
		
		
	}
	
	public String getTitle(){
		return title;
	}
	public int getGuardAggression(){
		return guardAggression;
	}
	public boolean getBribe(){
		return bribe;
	}
	public boolean getBribeable(){
		return bribeable;
	}
	public boolean getFreesAPrisoner(){
		return freesAPrisoner;
	}
	public int getInventoryPosition(){
		return inventoryPosition;
	}
	
}



