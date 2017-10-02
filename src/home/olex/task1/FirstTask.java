/*
* @FirstTask.java 2017/09/25
*/
package home.olex.task1;

/**
 * Class FirstTask implements task #87
 *
 * @version 25 Sep 2017
 * @author Oleksandr Kutaiev
 */
public class FirstTask {
	private int n;
	private int m;

	/**
	 * Initialize n and m numbers
	 * 
	 * @param n
	 *            - first number
	 * @param m
	 *            - second number
	 */
	public FirstTask(int n, int m) {
		this.n = n;
		this.m = m;
	}

	/**
	 * Get sum of last digits
	 * 
	 * @return - Sum of M last digits in number N
	 */
	public int getTaskResult() {
		return getSum(this.n, this.m);
	}

	/**
	 * Get sum of last digits of number.
	 * 
	 * @param number
	 *            - number.
	 * @param lastDigitCount
	 *            - count of last digits.
	 * @return sum of last digits of number.
	 */
	public int getSum(int number, int lastDigitCount) {
		int digitsSum = 0;
		
		if(number < 0) {
			number *= -1;
		}
		
		if (getDigitsCount(number) >= lastDigitCount) {
			for (int i = 1; i <= lastDigitCount; i++) {
				digitsSum += number % 10;
				number = (int) (number / 10);
			}
		}
		return digitsSum;
	}

	/**
	 * Get count of digits from number.
	 * 
	 * @param number
	 *            - number.
	 * @return count of digits.
	 */
	public int getDigitsCount(int number) {
		if(number < 0) {
			number *= -1;
		}
		
		int counter = 0;
		while (number > 0) {
			number = (int) (number / 10);
			counter++;
		}

		return counter;
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
}