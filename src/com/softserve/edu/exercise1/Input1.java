package com.softserve.edu.exercise1;

import java.util.Scanner;

/**
 * Method for input info for exercise1.
 * 
 * @author Andrii Kravtsov
 *
 */
public class Input1 {
	/**
	 * Method scan for take input data.
	 * @return mas with integers.
	 */
	public int[] scan() {
		Scanner in = new Scanner(System.in);
		int quantity = 0;
		int[] integers = {0};
		System.out.println("Input quantity of number's");
		if (in.hasNextInt()) {
			quantity = in.nextInt();
		}
		else {
			System.out.println("This is not natural number!");
			scan();
		}
		integers = new int[quantity];
		System.out.println("Input your integer's:");
		int i = 1;
		int qt = 0;
		while (i <= quantity) {
			if (in.hasNextInt()) {
				integers[qt] = in.nextInt();
				i++;
				qt++;
			} else {
				System.out.println("You wrote not natural number!");
				in.next();
			}
		}
		in.close();
		return integers;
	}

}
