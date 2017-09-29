package com.softserve.edu.exercise2;

/**
 * Class , which say are numbers simple or not.
 * 
 * @author Andrii Kravtsov.
 *
 */
public class AreSimple {
	/**
	 * method checking are int's simple or not.
	 */
	public void Simpler() {
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
