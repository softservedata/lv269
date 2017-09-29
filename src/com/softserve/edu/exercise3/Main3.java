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
	private Main3() {
	}
	/**
	 * Constant's with min and max value of massive.
	 */
	final static int min = 200;
	final static int max = 300;
	/**
	 * main method of third program.
	 * @param args const string from cmd
	 */
	public static void main(final String[] args) {
		CheckerSimple Check1=new CheckerSimple();
		Check1.Checking(min, max);
	}

}
