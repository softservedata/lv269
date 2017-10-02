/*
* @SecondTask.java 2017/09/25
*/
package home.olex.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * Class SecondTask implements task #226
 *
 * @version 25 Sep 2017
 * @author Oleksandr Kutaiev
 */
public class SecondTask {
	private int n;
	private int m;
	private int mn;

	/**
	 * Initialize n, m and mn numbers, mn number is result of n*m.
	 * 
	 * @param n
	 *            - First number.
	 * @param m
	 *            - Second number.
	 */
	public SecondTask(int n, int m) {
		this.n = n;
		this.m = m;

		this.mn = n * m;
	}

	/**
	 * Get result of task.
	 * 
	 * @return - list with items
	 */
	public List<Integer> getTaskResult() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < mn; i++) {
			if ((m != 0) && (i % m) == 0) {
				if ((n != 0) && (i % n) == 0) {
					list.add(i);
				}
			}
		}

		return list;
	}

	/**
	 * Getter for n value.
	 * 
	 * @return - n.
	 */
	public int getN() {
		return this.n;
	}

	/**
	 * Getter for m value.
	 * 
	 * @return - m.
	 */

	public int getM() {
		return this.m;
	}

	/**
	 * Getter for mn value.
	 * 
	 * @return - mn.
	 */
	public int getMN() {
		return this.mn;
	}
}