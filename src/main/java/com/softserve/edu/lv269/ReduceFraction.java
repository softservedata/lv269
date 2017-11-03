package com.softserve.edu.lv269;

import java.util.ArrayList;
import java.util.List;

/**
 * Task 90.
 *
 * @author Yura Ivanytsky
 *
 * @version 1.0
 *
 */
public class ReduceFraction {

	/**
	 * This method reduces the fraction
	 * 
	 * @param m
	 * @param n
	 * @return List lst.
	 */
	public List<Integer> reduced(int m, int n) {
		List<Integer> lst = new ArrayList<>();
		int commonDiv = commonDivider(m, n);
		if (commonDiv > 1) {
			int p = 0;
			int q = 0;
			do {
				if (m > n) {
					p = (int) (Math.random() * (m - 1) + 1);
					q = (int) (Math.random() * (m - 1) + 1);
				}
				if (n > m) {
					p = (int) (Math.random() * (n - 1) + 1);
					q = (int) (Math.random() * (n - 1) + 1);
				}
			} while ((m * q) != (n * p));
			commonDiv = commonDivider(p, q);
			p /= commonDiv;
			q /= commonDiv;
			lst.add(p);
			lst.add(q);
			return lst;
		} else {
			lst.add(m);
			lst.add(n);
			return lst;
		}
	}

	/**
	 * This method looks for the largest common divider.
	 *
	 * @param p
	 * @param q
	 * @return int variable "divider".
	 *
	 */
	public int commonDivider(int p, int q) {
		int min;
		int divider = 0;
		if (p > q) {
			min = q;
		} else {
			min = p;
		}
		for (int i = 1; i <= min; i++) {
			if ((p % i == 0) && (q % i == 0)) {
				if (i > divider) {
					divider = i;
				}
			}
		}
		return divider;
	}

}
