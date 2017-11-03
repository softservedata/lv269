package com.softserve.edu.lv269;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputOutput {

	/**
	 * This method scans the number from the keyboard.
	 *
	 * @return int "temp".
	 */
	public int InputOneNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter natural number:");
		int temp = 0;
		if (sc.hasNext()) {
			temp = sc.nextInt();
		} else {
			System.out.println("Input error!");
		}
		sc.close();
		return temp;
	}

	/**
	 * This method scans two numbers from the keyboard.
	 * 
	 * @return List lst.
	 */
	public List<Integer> InputTwoNumbers() {
		List<Integer> lst = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int temp1 = 0;
		int temp2 = 0;
		System.out.println("Enter 1st natural number:");
		if (sc.hasNext()) {
			temp1 = sc.nextInt();
			System.out.println("Enter 2st natural number:");
			temp2 = sc.nextInt();
		} else {
			System.out.println("Input error!");
		}
		lst.add(temp1);
		lst.add(temp2);
		sc.close();
		return lst;
	}

	/**
	 * This method print list of numbers to the console.
	 * 
	 * @param lst
	 */
	public void print(List<Integer> lst) {
		if (!lst.isEmpty()) {
			System.out.println("Perfect number: " + lst);
		} else {
			System.out.println("List is empty!");
		}
	}

	/**
	 * This method print result console.
	 * 
	 * @param m
	 * @param n
	 * @param p
	 * @param q
	 */
	public void print(int m, int n, int p, int q) {
		System.out.println("m/n = p/q:");
		System.out.println(m + "/" + n + " = " + p + "/" + q);
	}

	/**
	 * This method print result console.
	 * 
	 * @param n
	 * @param invert
	 */
	public void print(int n, int invert) {
		System.out.println("Input number: " + n);
		System.out.println("Inverse number: " + invert);
	}
}
