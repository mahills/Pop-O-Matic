package edu.appstate.compsci;

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class Simulator {

	public static void simulate(int totalTicks, int capacity, int servingsProducedPerTick) {
		PopOMatic popper = new PopOMatic(capacity, servingsProducedPerTick);
		Queue<Integer> orders = new LinkedList<>();
		Servings servings = new Servings();
		Metrics metrics = new Metrics();
		
		System.out.println("Running new Pop-O-Matic Simulation");
		System.out.println("Time to run: " + totalTicks);
		System.out.println("Total Pop-O-Matic capacity, in popcorn servings: " + capacity);
		System.out.println("Popcorn Popped Per Tick, in popcorn servings: " + servingsProducedPerTick);
		
		int amountNeededThisTick = 0; // How much do we need to serve this clock tick?
		
		for (int i = 0; i < totalTicks; i++) {
			// Step 1: Every clock tick, someone gets in line. Compute the number
			// of servings of popcorn they will needed, based on a probability
			// distribution given in Servings. Note: this may be 0.
			int newServingsThisTick = servings.howManyServings();
			orders.add(newServingsThisTick);
			
			// Step 2: If amountNeededThisTick is 0, we can serve the next customer,
			// assuming we have one.
			if (amountNeededThisTick == 0) {
				if (!orders.isEmpty()) {
					amountNeededThisTick = orders.remove();
				}
			}
			
			// Step 3: If we have enough popcorn, we can serve the customer.
			// If we don't have enough, the customer needs to wait.
			if (amountNeededThisTick > 0) {
				if (popper.hasEnough(amountNeededThisTick)) {
					popper.servePopcorn(amountNeededThisTick);
					amountNeededThisTick = 0;
				} else {
					metrics.increaseTimesNotServed();
				}
			}
			
			// Step 4: We now will pop more popcorn, and we can see if we
			// overflow this step.
			int overflowAmount = 0;
			if (popper.willOverflow()) {
				overflowAmount = popper.overflowAmount();
				metrics.reportOverflow(overflowAmount);
			}
			
			// Step 5: Pop the popcorn!
			popper.popPopcorn();
			
			// Visualize what happened
			char tickChar = '.';
			if (overflowAmount > 0) {
				tickChar = 'O';
			} else if (amountNeededThisTick > 0) {
				tickChar = 'W';
			}
			System.out.print(tickChar);			
		}
		
		// Print the total results
		System.out.println(); // Finish the status line above
		System.out.println("We made customers wait " + metrics.getTimesNotServed() + " times");
		System.out.println("We overflowed the machine " + metrics.getOverflowTimes() + " times");
		System.out.println("We lost " + metrics.getOverflowAmount() + " servings of popcorn to overflow");
		System.out.println("We ended with " + popper.getCurrentServings() + " servings left in the Pop-O-Matic");
	}
	
	public static void main(String args[]) {		
		System.out.println("Welcome to the Pop-O-Matic Simulator!");
		
		Scanner stdin = new Scanner(System.in);
		
		System.out.println("How long (in clock ticks) should the simulation run?");
		int totalRunTime = stdin.nextInt();
		
		System.out.println("How many servings can the Pop-O-Matic hold?");
		int capacity = stdin.nextInt();
		
		System.out.println("How much popcorn should we pop per clock tick?");
		int servingsPerTick = stdin.nextInt();
		
		simulate(totalRunTime, capacity, servingsPerTick);
	}
}
