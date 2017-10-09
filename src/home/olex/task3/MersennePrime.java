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
public class MersennePrime {

	/** Print list of Mersen's numbers */
	public List<Integer> getMersennNumbers(int number) {
		if (number < 0) {
			throw new ArithmeticException("Invalid argument");
		}
		List<Integer> list = new ArrayList<Integer>();
		int candidate = 0;
		for (int p = 2; candidate < number; p++) {
			if (isPrime(p)) {
				candidate = getCandidate(p);

				if (candidate >= number) {
					break;
				}

				if (isPrime(candidate)) {
					list.add(candidate);
				}
			}
		}

		return list;
	}

	public int getCandidate(int p) {
		return (getPow(2, p) - 1);
	}

	public int getPow(int number, int b) throws ArithmeticException{
		if (number < 0 || b < 0) {
			throw new ArithmeticException("Invalid arguments for get power");
		}
		if (b == 0 && number > 0) {
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
	public boolean isPrime(int number) {
		if (number < 2) {
			return false;		
		}
		
		for (int i = 2; i <= (Math.sqrt(number) + 1); i++) {
			if (i != number && number % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}