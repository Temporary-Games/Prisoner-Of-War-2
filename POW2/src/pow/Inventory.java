package pow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Inventory {
	// inventory instantiation
	public int[] inventory = new int[5];
	Scanner scan;
	public Inventory() {
		
	}
	// inventory constructor
	public Inventory(int a1, int a2, int a3, int a4, int a5) throws FileNotFoundException{
		inventory[0] = 0;
		inventory[1] = 0;
		inventory[2] = 0;
		inventory[3] = 0;
		inventory[4] = 0;
		scan = new Scanner(new File("data/events.txt"));
	}
	
	private finalize(){
		
	}

	// adds item to empty space
	public void addItem(int item) {
		for (int x = 0; x < 4; x++) {
			if (inventory[x] == 0) {
				inventory[x] = item;
				break;
			}
		}
	}

	// removes item called and when I know the system used to call items, will
	// call the item to be used
	public void useItem(int item) {
		Scanner scan = new Scanner(System.in);
		for (int x = 0; x < 4; x++) {
			if (inventory[x] == item) {
				this.readItem(item);
				System.out.println("Do you want to use this item? (y/n)");
				String answer = scan.next();
				if (answer.equals("y")) {
					inventory[x] = 0;
					break;
				}
			}
		}
		scan.close();
	}

	// reads an int and displays the corresponding item as a string
	public void readItem(int item) {
		String output = "";
		Scanner scan = new Scanner("data/events.txt");
		do {
			if (scan.nextInt() == item)
				output = scan.next().replace('_', ' ');
			scan.nextLine();
		} while (scan.hasNext());
		System.out.println(output);
	}

	// prints the inventory
	public String toString(){
		String output = "";
		int check = 0;
		inventory[0] = 1;
		for (int x = 0; x < inventory.length; x++) {
			if (inventory[x] == 0) 
				output += "-EMPTY- ";
			
			do {	

				if(scan.hasNextInt()){
					check = scan.nextInt();
				System.out.println("IN:" + check);
				}
				if(check!=-1)
					scan.nextLine();
				System.out.println("CONFIRMATION_CONTROL_STATION_ALPHA_PROTOCOL_6");
				
			} while (check!=-1);
		}
		System.out.println("Output");
		return output;
	}
}
