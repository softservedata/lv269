package com.softserve.edu.exercise1;

public class Work1 {
	public int quantity;
	public int sum;

	public void outwork(int[] mas) {
		int i = 0;
		while (i < mas.length) {
			if (mas[i] % 5 == 0 && mas[i] % 7 != 0) {
				quantity++;
				sum += mas[i];
			}
			i++;
		}
	}
}
