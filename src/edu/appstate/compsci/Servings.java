package edu.appstate.compsci;

/**
 * Compute the number of new servings we need this clock tick.
 * 
 * Customers can order no popcorn (they may be getting the big
 * box of Twizzlers), a small popcorn with one serving, a medium
 * popcorn with three servings, a large popcorn with five servings,
 * or a family-size popcorn with eight servings.
 * 
 * The number to return is based on a given probabilty distribution.
 * 
 * It would be nice to parameterize all of this in a future version...
 * 
 * @author Mark Hills
 * @version 0.1
 *
 */
public class Servings {
	private static final double ZERO_BOUNDARY = 0.6;
	private static final double ONE_BOUNDARY = 0.7;
	private static final double THREE_BOUNDARY = 0.8;
	private static final double FIVE_BOUNDARY = 0.9;
	
	private static final int NO_POPCORN = 0;
	private static final int SMALL_POPCORN = 1;
	private static final int MEDIUM_POPCORN = 3;
	private static final int LARGE_POPCORN = 5;
	private static final int FAMILY_SIZE_POPCORN = 8;
	
	/**
	 * Compute the number of new servings of popcorn needed. 
	 * 
	 * @return the number of new servings of popcorn that are needed.
	 */
	public int howManyServings() {
		double p = Math.random();
		
		if (p < ZERO_BOUNDARY) {
			return NO_POPCORN; // No popcorn
		} else if (p < ONE_BOUNDARY) {
			return SMALL_POPCORN; // A small popcorn, 1 serving
		} else if (p < THREE_BOUNDARY) {
			return MEDIUM_POPCORN; // A medium popcorn, 3 servings
		} else if (p < FIVE_BOUNDARY) {
			return LARGE_POPCORN; // A large popcorn, 5 servings
		} else {
			return FAMILY_SIZE_POPCORN; // A family-size popcorn, 8 servings
		}
	}
}
