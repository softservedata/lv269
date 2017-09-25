/*
* @UserInterface.java 2017/09/25
*/
package home.olex.task1;

import java.util.Scanner;


/**
* Class UserInterface implements interface for application #559
*
* @version 25 Sep 2017
* @author Oleksandr Kutaiev
*/
public class UserInterface {
	/** Get task number
	 * @return task number */
	public static int getTaskNumber() {
		System.out.print("Please choose # of task, should be 1..3 only: ");

		int n = getValue();

		if (n<1 || n>3) {
			System.out.println("Incorrect number of task, should be as 1..3 only");
			return n;
		}
		
		return n;
	}
	
	/** Get integer value from user
	 * @return integer natural number*/
	public static int getValue() {
		Scanner reader = new Scanner(System.in);
		int result = 0;
		try {
			result = reader.nextInt();
		} catch (Exception e) {
			System.out.print("Something entered wrong: " + e.toString());
		}
		
		if (result < 0) {
			System.out.println("Entered value is less than 0, so it's not a natural value, changed this value to 1");
			result = 1;
		}
		
		return result;
	}
	
	/** Choose task number 1..3 and run it
	 * @param taskNumber - Number of task */
	public static void startTask(int taskNumber) {
		switch (taskNumber) {
		case 1:  
			FirstTask FT = new FirstTask();
			FT.getResult();
			break;
			
		case 2:
			SecondTask ST = new SecondTask();
			ST.getResult();
			break;
			
		case 3:
			ThirdTask TT = new ThirdTask();
			TT.GetResult();
			break;
			
		default :
				System.out.print("No tasks here with this number, exit...\n");
				break;
		}
	}
}