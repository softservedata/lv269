/*
* @Main.java 2017/09/25 
*/

package home.olex.task1;

import home.olex.tools.UI;

/**
 * Class Main has entry point of first task application.
 *
 * @version 25 Sep 2017
 * @author Oleksandr Kutaiev
 */
public class Main {

	/**
	 * Program's entry point.
	 * 
	 * @param args
	 *            - input arguments.
	 */
	public static void main(String[] args) {
		UI ui = new UI();
		DigitsSum digSum = new DigitsSum();
		
		int n = ui.getValueFromKeyboard();
		int m = ui.getValueFromKeyboard();
		
		ui.showResult(digSum.getSum(n, m));
	}
}