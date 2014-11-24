package pow;

public class Player {

	/*
	 * How many saved prisoners? This keeps track.
	 */
	int prisonersSaved;

	/*
	 * inventory is the instance variable of the inventory. All the players
	 * items are stored here.
	 */
	Event[] inventory;

	/*
	 * Create a new playerInv array. playerInv is the inventory of the player.
	 * The Inventory is 5 items that are stored in an inventory array.
	 */
	Inventory playerInv = new Inventory(0, 0, 0, 0, 0);

}