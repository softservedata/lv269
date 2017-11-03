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

public class MainReduceFraction {

	public static void main(String[] args) {
		
		InputOutput inOut = new InputOutput();
		ReduceFraction reduceFraction = new ReduceFraction();
		List<Integer> lst1 = inOut.InputTwoNumbers();
		List<Integer> lst2 = reduceFraction.reduced(lst1.get(0), lst1.get(1));
		inOut.print(lst1.get(0), lst1.get(1), lst2.get(0), lst2.get(1));
		
	}

}
