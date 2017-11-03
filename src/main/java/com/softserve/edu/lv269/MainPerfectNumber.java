package com.softserve.edu.lv269;

import java.util.List;

/**
 * The Main class is the entry point of the program.
 *
 * @author Yura Ivanytsky
 *
 * @version 1.0
 *
 */
public class MainPerfectNumber {

	public static void main(String[] args) {
		
		InputOutput inOut = new InputOutput();
		PerfectNumber perfectNumber = new PerfectNumber();
		int n = inOut.InputOneNumber();
		List<Integer> lst = perfectNumber.findPerfectNumber(n);
		inOut.print(lst);
		
	}

}
