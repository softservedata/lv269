/*
* @ThirdTask.java 2017/09/25
*/
package home.olex.task1;

/**
* Class ThirdTask implements task #559
*
* @version 25 Sep 2017
* @author Oleksandr Kutaiev
*/
public class ThirdTask {
	private int n;
	
	/** Initialize n number */
	public ThirdTask() {
		initializeItems();
	}
	
	/** Print list of Mersen's numbers */
	public void GetResult() {
		System.out.print("Mersen's numbers is: ");
		int candidate = 0;
		for(int p = 2; ; p++) {
			if(IsPrime(p)) {
				candidate = (int)(Math.pow(2, p) - 1);
				
				if (candidate >= this.n) {
					break;
				}
				
				if (IsPrime(candidate)) {
					System.out.print(" " + candidate);
				}
			}
		}
	}
	
	/**Initialize n number */
	private void initializeItems() {
		System.out.print("\tEnter n value: ");
		this.n = UserInterface.getValue();
		
		System.out.print("\n");
	}
	
	/** Check whether some number is prime 
	 * @return true if number is prime*/
	private boolean IsPrime(int number) {
		for (int i = 2; i < number; i++) {
			if (number%i == 0) {
				return false;
			}
		}
		return true;
	}
}
