package edu.appstate.compsci;

/**
 * Model an automatic popcorn maker (butter not included).
 * 
 * @author Mark Hills
 * @version 0.1
 */
public class PopOMatic {

	/** The amount of popped popcorn that the Pop-O-Matic can hold, in servings */
	private int capacity;
	
	/** The number of servings of popped popcorn produced per clock tick */
	private int servingsProducedPerTick;
	
	/** The current amount of popped popcorn held in the Pop-O-Matic */
	private int currentServings;
	
	/**
	 * Create a new, empty Pop-O-Matic instance.
	 * 
	 * @param cap the capacity, in servings, for this Pop-O-Matic
	 * @param servings the number of servings of popcorn popped per clock tick
	 */
	public PopOMatic(int cap, int servings) {
		capacity = cap;
		servingsProducedPerTick = servings;
		currentServings = 0;
	}
	
	/**
	 * Retrieve the total capacity of the Pop-O-Matic
	 * 
	 * @return the capacity of the Pop-O-Matic
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/**
	 * Retrieve the current number of servings of popcorn held by the Pop-O-Matic
	 * 
	 * @return the current number of popcorn servings in the Pop-O-Matic
	 */
	public int getCurrentServings() {
		return currentServings;
	}
	
	/**
	 * Check to see if the machine will overflow on the next clock tick.
	 * 
	 * @return true if we will overflow, false otherwise
	 */
	public boolean willOverflow() {
		return (currentServings + servingsProducedPerTick) > capacity;
	}
	
	/**
	 * Compute the number of overflow servings we would produce on the next clock tick.
	 * 
	 * @return the amount of popcorn that would overflow the machine
	 */
	public int overflowAmount() {
		return (currentServings + servingsProducedPerTick) - capacity;
	}
	
	/**
	 * Check to see if the machine has enough popcorn to serve. 
	 * 
	 * @param amountToServe the amount of popcorn we want to serve
	 * @return true if we have enough popcorn, false otherwise
	 */
	public boolean hasEnough(int amountToServe) {
		return currentServings >= amountToServe;
	}
	
	/**
	 * Serve popcorn from the machine, decreasing the amount stored.
	 * 
	 * @param amountToServe the amount of popcorn to serve
	 */
	public void servePopcorn(int amountToServe) {
		currentServings -= amountToServe;
	}
	
	/**
	 * Pop popcorn, and update the amount held.
	 */
	public void popPopcorn() {
		if (willOverflow()) {
			currentServings = capacity;
		} else {
			currentServings += servingsProducedPerTick;
		}
	}
}
