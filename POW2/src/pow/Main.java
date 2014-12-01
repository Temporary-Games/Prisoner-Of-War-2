//Stuff and thingsadick
package pow;
//Coomement

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	// rounds of game

	public static void main(String[] args) throws FileNotFoundException {
		int rounds = 30;
		int guardAgro = 0;
		int savedPrisoners = 0;
		Inventory playerInv = new Inventory(0, 0, 0, 0, 0);
		for (int currentRound = 1; currentRound <= rounds; currentRound++) {
			Event stuff = new Event();
			Scanner scan = new Scanner(System.in);
			do {
				System.out.println("Round: " + currentRound);
				System.out.println("Freed Prisoners: " + savedPrisoners);
				System.out.println(stuff.getTitle());
				if(stuff.getInventoryPosition() != 0)
					playerInv.addItem(stuff.getInventoryPosition());
				if(stuff.getFreesAPrisoner() == true)
				{
					savedPrisoners++;
					System.out.println("A prisoner was saved.");
				}
				guardAgro += stuff.getGuardAggression();
				if(guardAgro < 0)
					guardAgro = 0;
				System.out.println("Guard Agression: " + guardAgro);
				if (guardAgro >= 10) {
					guardAgro = 0;
					savedPrisoners--;
					System.out.println("A prisoner was killed by the guards.");
				}
				
				
				
				
				System.out.println("Do you want to go to the next turn?(y/n)");


			} while (!(scan.nextLine().equalsIgnoreCase("y")));

		}

	}
}
