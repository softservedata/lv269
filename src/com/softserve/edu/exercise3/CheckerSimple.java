package com.softserve.edu.exercise3;
/**
 * Class for checking are integer's friendly or not.
 * @author Andrii Kravtsov
 *
 */
public class CheckerSimple {
	/**
	 * The Checking method for Simple Integer's.
	 * @param min min value of int.
	 * @param max max value of int.
	 */
	public void Checking(final int min, final int max) {
		int a = min;
		int b = a + 1;
		sumDIV Summer = new sumDIV();
		while (a < max) {
			while (b <= max) {
				if ((a == Summer.findDivSum(b)) && (b == Summer.findDivSum(a))) {
					System.out.println("Number " + a + " and number "
							+ b + " are friendly");
				}
				b++;
			}
			a++;
			b = a + 1;
		}
	}
}
