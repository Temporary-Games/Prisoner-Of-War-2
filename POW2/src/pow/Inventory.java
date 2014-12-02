package pow;

import java.util.Scanner;

public class Inventory {
	// inventory instantiation
	public int[] inventory = new int[5];

	// inventory constructor
	public Inventory(int a1, int a2, int a3, int a4, int a5) {
		inventory[0] = a1;
		inventory[1] = a2;
		inventory[2] = a3;
		inventory[3] = a4;
		inventory[4] = a5;
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
		scan.close();
		System.out.println(output);
	}

	// prints the inventory
	public String toString() {
		String output = "";
		for (int x = 0; x < inventory.length; x++) {
			if (inventory[x] == 0) 
				output += "-EMPTY- ";
			//System.out.println("TEST");
			Scanner scan = new Scanner("data/events.txt");
			do {
				//System.out.println("TEST 2");
				if (scan.nextInt()==inventory[x])
					//System.out.println("TEST 3");
					output += scan.next().replace('_', ' ') + " ";
				scan.nextLine();
			} while (scan.hasNext());

			scan.close();
		}
		return output;
	}
}
