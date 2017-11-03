/*
* @UserInterface.java 2017/09/25
*/
package home.olex.tools;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Class UserInterface implements user interface for application
 *
 * @version 25 Sep 2017
 * @author Oleksandr Kutaiev
 */
public class UI {

	/**
	 * Get integer value from user.
	 * 
	 * @return integer natural number.
	 */
	public int getValueFromKeyboard() {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int result = 0;
		while (true) {
			try {
				System.out.print("Enter natural number: ");
				result = reader.nextInt();
			} catch (InputMismatchException e) {
				System.out.print("\nEntered value isn't integer. Try again.");
				reader.nextLine();
				continue;
			} catch (Exception e) {
				System.out.print("\nEntered something wrong." + e.getMessage() + "\n\n\n\tTry again.");
				reader.nextLine();
				continue;
			}

			if (result <= 0) {
				System.out.println("\nEntered value isn't natural. Try again.");
			} else {
				return result;
			}
		}
	}
	
	public void showResult(int result) {
		System.out.print("\nResult is: " + result);
	}

	public void showResult(List<Integer> result) {
		System.out.print("\nResult is:");
		for (Integer data : result) {
			System.out.print(" " + data);
		}
	}
}