package com.softserve.edu.exercise1;
/**
 * Class for know quantity and sum.
 * @author Andrii Kravtsov.
 *
 */
public class Work1 {
	private final int seven = 7;
	private final int five = 5;
	/**
	 * Method work with integers and enumerate quan and sum.
	 * @param mas massive with numbers
	 */
	public void outwork(final int[] mas) {
		int i = 0;
		int quantity=0;
		int sum=0;
		while (i < mas.length) {
			if ((mas[i] % five == 0) && (mas[i] % seven != 0)) {
				quantity++;
				sum += mas[i];
			}
			i++;
		}
		System.out.println("Quantity of number = " + quantity
				+ " and their sum = " + sum);
	}
}
