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
	private int digitsSum = 0;
	
	/**Initialize n and m numbers */
	public FirstTask() {
		initializeItems(); //Get n and m values
	}
	
	/**Initialize n and m numbers */
	private void initializeItems() {
		System.out.print("\tEnter n value: ");
		this.n = UserInterface.getValue();
		
		System.out.print("\tEnter m value: ");
		this.m = UserInterface.getValue();
		
		System.out.print("\n");
	}
	
	/** Get sum of last digits */
	public void getResult() {
		if (getDigits(this.n) < this.m) {
			System.out.println("Entered n value should contains more digits than entered m value");
			return;
		}
		
		for (int i = 1; i <= m; i++) {
			digitsSum += n%10;
			n = (int) (n/10);
		}
		
		System.out.println("Sum is: " + this.digitsSum);
	}
	
	/** Get count of digits from number
	 * @return count of digits */
	public int getDigits(int n) {
		int counter = 0;		
		while(n > 0) {
			n = (int) (n / 10);
			counter++;
		}
		
		return counter;
	}
}