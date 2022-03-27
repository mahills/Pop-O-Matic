package edu.appstate.compsci;

/**
 * Track simulation metrics for the Pop-O-Matic simulator.
 * 
 * @author Mark Hills
 * @version 0.1
 */
public class Metrics {
	/** Clock ticks during which we count not serve anyone */
	private int timesNotServed;
	
	/** Number of times the Pop-O-Matic overflowed */
	private int overflowTimes;
	
	/** Total amount of overflowed popcorn, in servings */
	private int overflowAmount;
	
	/**
	 * Create a new Metrics object to track simulation metrics
	 */
	public Metrics() {
		timesNotServed = 0;
		overflowTimes = 0;
		overflowAmount = 0;
	}
	
	/**
	 * Return the number of times we could not serve a customer.
	 * 
	 * @return the number of times we could not serve a customer.
	 */
	public int getTimesNotServed() {
		return timesNotServed;
	}
	
	/**
	 * Return the number of times the Pop-O-Matic overflowed.
	 * 
	 * @return the number of times the Pop-O-Matic overflowed.
	 */
	public int getOverflowTimes() {
		return overflowTimes;
	}
	
	/**
	 * Return the total amount of overflowed popcorn, in servings.
	 * 
	 * @return the total amount of overflowed popcorn, in servings.
	 */
	public int getOverflowAmount() {
		return overflowAmount;
	}
	
	/**
	 * Increment the number of times we could not serve a customer.
	 */
	public void increaseTimesNotServed() {
		timesNotServed++;
	}
	
	/**
	 * Report an overflow event, which should increase the count and total amount.
	 * 
	 * @param overflow the amount we overflowed this time.
	 */
	public void reportOverflow(int overflow) {
		overflowAmount += overflow;
		overflowTimes += 1;
	}
}
