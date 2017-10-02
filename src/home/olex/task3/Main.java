/*
* @Main.java 2017/09/25 
*/

package home.olex.task3;

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
		
		ThirdTask tt = new ThirdTask(n);	
		
		UI.showResult(tt.getTaskResult());
	}
}