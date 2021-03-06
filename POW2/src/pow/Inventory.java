package pow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Inventory {

	int a = 0;
	int b = 0;
	int c = 0;
	int d = 0;
	int e = 0;

	// declare scanner
	Scanner scan;

	public Inventory() {

	}

	// inventory constructor
	public Inventory(int a1, int a2, int a3, int a4, int a5)
			throws FileNotFoundException {

		a = a1;
		b = a2;
		c = a3;
		d = a4;
		e = a5;
		// set all the inventory slots empty

		// read in the file of events
		scan = new Scanner(new File("data/events.txt"));
	}

	public void addItem(int item) {
		if (a == 0) {
			a = item;
		} else if (b == 0) {
			b = item;
		} else if (c == 0) {
			c = item;
		} else if (d == 0) {
			d = item;
		} else if (e == 0) {
			e = item;
		}
	}

	public String printInventory(int q) {
		switch (q) {
		case 0:
			return "EMPTY";
		case 1:
			return "Chocolate Bar";
		case 2:
			return "Cigar Box";
		}
		return "ERROR";
	}
}

/*package pow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Inventory {
	// inventory array instantiation
	public int[] inventory = new int[5];

	// declare scanner
	Scanner scan;

	public Inventory() {

	}

	// inventory constructor
	public Inventory(int a1, int a2, int a3, int a4, int a5)
			throws FileNotFoundException {

		// set all the inventory slots empty
		inventory[0] = 0;
		inventory[1] = 0;
		inventory[2] = 0;
		inventory[3] = 0;
		inventory[4] = 0;

		// read in the file of events
		scan = new Scanner(new File("data/events.txt"));
	}

	// adds item to empty space
	public void addItem(int item) {
		for (int x = 0; x < 5; x++) {
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
	public String readItem(int item) {
		String output = "";
		Scanner scan = new Scanner("data/events.txt");
		do {
			int fladoodle = scan.nextInt();
			if (fladoodle == item)
				output = scan.next().replace('_', ' ');
			scan.nextLine();
		} while (scan.hasNext());
		//System.out.println(output);
		return output;
	}

	// prints the inventory
	public String toString() {
		String output = "";
		int check = 0;
		//inventory[0] = 1;  //Essential Starting Pack
		for (int x = 0; x < inventory.length; x++) {
			if (inventory[x] == 0)
				output += "-EMPTY- ";

			do {
				
				if (scan.hasNextInt()) {
					check = scan.nextInt();
					if(check == inventory[x]){
						String ip = scan.next().replace('_', ' ');
						ip = ip.substring(11, ip.length()-1);
						output+=("-"+ip+"- ");
						System.out.println(output);
						
					}
					//System.out.println("IN:" + check);
				}
				//if(check == -1){
					//break;
			*
}*/
