package com.softserve.edu.lv269;

/**
 * The Main class is the entry point of the program.
 *
 * @author Yura Ivanytsky
 *
 * @version 1.0
 *
 */

public class MainReversNumber {

	public static void main(String[] args) {
		
		InputOutput inOut = new InputOutput();
		ReversNumber reversNumber = new ReversNumber();
		int n = inOut.InputOneNumber();
		int invert = reversNumber.invertedNumber(n);
		inOut.print(n, invert);

	}

}
