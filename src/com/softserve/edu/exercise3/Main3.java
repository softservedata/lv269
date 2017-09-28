package com.softserve.edu.exercise3;

/**
 * The main class of exercise3.
 * 
 * @author Andrii Kravtsov
 *
 */
public final class Main3 {
	/**
	 * Constructor for main.
	 */
	public Main3() {
	}

	final static int min = 200;
	final static int max = 300;

	public static void main(String[] args) {
		int a = min;
		int b = a + 1;
		sumDIV Summer = new sumDIV();
		while (a < max) {
			while (b <= max) {
				if ((a == Summer.findDivSum(b)) && (b == Summer.findDivSum(a))) {
					System.out.println("Number " + a + " and number " + b + " are friendly");
				}
				b++;
			}
			a++;
			b = a + 1;
		}

	}

}
