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
public class DigitsSum {

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
		
		if (number < 0) {
			throw new ArithmeticException("Number is not natural");
		}
		
		if (getDigitsCount(number) >= lastDigitCount) {
			for (int i = 1; i <= lastDigitCount; i++) {
				digitsSum += number % 10;
				number = number / 10;
			}
		} else {
			throw new ArithmeticException("Not enough digits");
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
		if (number < 0) {
			throw new ArithmeticException("Number is less than 0");
		}
		int counter = 0;
		while (number > 0) {
			number = number / 10;
			counter++;
		}

		return counter;
	}
}