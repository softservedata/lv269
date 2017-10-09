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
		MersennePrime mp = new MersennePrime();	
		UI ui = new UI();
		
		int n = ui.getValueFromKeyboard();			
		
		ui.showResult(mp.getMersennNumbers(n));
	}
}