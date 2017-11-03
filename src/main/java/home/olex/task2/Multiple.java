/*
* @SecondTask.java 2017/09/25
*/
package home.olex.task2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Class SecondTask implements task #226
 *
 * @version 25 Sep 2017
 * @author Oleksandr Kutaiev
 */
public class Multiple {
	/**
	 * Get result of task.
	 * 
	 * @return - list with items
	 */
	public List<Integer> getMultipleItems(int n, int m) {
		if(!isMulSafe(n, m)) {
			throw new ArithmeticException("Multiple is not safe");
		}
		int mn = n * m;
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
	
	public boolean isMulSafe(int n, int m) {
		BigInteger result = BigInteger.valueOf(n);
		result = result.multiply(BigInteger.valueOf(m));
		if(result.longValue() >= Integer.MIN_VALUE && result.longValue() <= Integer.MAX_VALUE) {
			return true;
		} else {
			return false;
		}
	}
}