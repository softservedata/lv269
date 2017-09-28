package com.softserve.edu.exercise1;

/**
 * Main class of program.
 * @author Andron
 *
 */
public final class Main1 {

/**
* Constructor.
*/
private Main1() {
}

/**
 * The main method of all program.
 * @param args
 * cmd parametrs.
 */
 public static void main(final String[] args) {
		Input1 Input = new Input1();
		Work1 Exercise = new Work1();
		Exercise.outwork(Input.scan());
		System.out.println("Quantity of number = " + Exercise.quantity
				+ " and their sum = " + Exercise.sum);
	}

}
