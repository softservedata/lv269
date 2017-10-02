/*
* @ThirdTask.java 2017/09/25
*/
package home.olex.task3;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ThirdTask implements task #559
 *
 * @version 25 Sep 2017
 * @author Oleksandr Kutaiev
 */
public class ThirdTask {
	private int n;

	/**
	 * Initialize n number
	 * 
	 * @param n
	 *            - Number.
	 */
	public ThirdTask(int n) {
		this.n = n;
	}

	/** Print list of Mersen's numbers */
	public List<Integer> getTaskResult() {
		List<Integer> list = new ArrayList<Integer>();
		int candidate = 0;
		for (int p = 2;; p++) {
			if (IsPrime(p)) {
				candidate = this.getCandidate(p);

				if (candidate >= this.n) {
					break;
				}

				if (IsPrime(candidate)) {
					list.add(candidate);
				}
			}
		}

		return list;
	}

	public int getCandidate(int p) {
		return (getPow(2, p) - 1);
	}

	public int getPow(int number, int b) {
		if (b == 0 && number != 0) {
			return 1;
		}
		int res = number;
		for (int i = 1; i < b; i++) {
			res *= number;
		}

		return res;
	}

	/**
	 * Check whether some number is prime.
	 * 
	 * @param number
	 *            - Number.
	 * @return true if number is prime.
	 */
	public boolean IsPrime(int number) {
		if (number < 2) {
			return false;		}
		
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Getter for n value.
	 * 
	 * @return - n.
	 */
	public int getN() {
		return this.n;
	}
}
