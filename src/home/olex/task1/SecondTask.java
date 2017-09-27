/*
* @SecondTask.java 2017/09/25
*/
package home.olex.task1;

/**
 * Class SecondTask implements task #226
 *
 * @version 25 Sep 2017
 * @author Oleksandr Kutaiev
 */
public class SecondTask {
	private int n;
	private int m;
	private int mn;

	/** Initialize n, m and mn numbers */
	public SecondTask() {
		initializeItems();
	}

	/** Initialize n, m and mn numbers */
	private void initializeItems() {
		System.out.print("\tEnter n value: ");
		this.n = UserInterface.getValue();

		System.out.print("\tEnter m value: ");
		this.m = UserInterface.getValue();

		this.mn = m * n;

		System.out.print("\n");
	}

	/** Print result of task */
	public void getResult() {
		System.out.print("\nResult is:");
		for (int i = 1; i < mn; i++) {
			if ((m != 0) && (i % m) == 0) {
				if ((n != 0) && (i % n) == 0) {
					System.out.print("  " + i);
				}
			}
		}
	}
}