/*
* @Main.java 2017/09/25 
*/

package home.olex.task2;

import home.olex.tools.UI;

/**
 * Class Main has entry point of application
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
		System.out.print("Enter n value: ");
		int n = UI.getValueFromKeyboard();
		System.out.print("Enter m value: ");
		int m = UI.getValueFromKeyboard();
		
		SecondTask st = new SecondTask(n, m);
		
		UI.showResult(st.getTaskResult());
	}
}