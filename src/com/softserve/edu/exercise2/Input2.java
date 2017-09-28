package com.softserve.edu.exercise2;

import java.util.Scanner;

/**
 * Method for input info for exercise2.
 * 
 * @author Andrii Kravtsov
 *
 */
public class Input2 {
	/**
	 * Method scan for take input data.
	 * 
	 * @return number
	 */
	public int scan() {
		Scanner in = new Scanner(System.in);
		int n = 0;
		System.out.println("Input your number");
		if (in.hasNextInt()) {
			n = in.nextInt();
		} else {
			System.out.println("This is not natural number!");
			scan();
		}
		in.close();
		return n;
	}

}
