package com.softserve.edu.exercise2;
/**
 * Main class for execise2.
 * @author Andron
 *
 */
public final class Main2 {
	/**
	 * constructor.
	 */
	private Main2() {
	}
	/**
	 * main method of the package.
	 * @param args
	 */
	public static void main(final String[] args) {
		Input2 Inputter = new Input2();
		NCD NCD1 = new NCD();
		int a = Inputter.scan();
		int b = a - 1;
		while (b != 0) {
			if (NCD1.progNCD(a, b) == 1) {
				System.out.println("Number " + a + " and number "
						+ b + " are simple");
			}
			b--;
		}

	}

}
