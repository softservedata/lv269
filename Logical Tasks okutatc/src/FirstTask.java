/*
 * #87
 */


public class FirstTask 
{
	private int n;
	private int m;
	private int digitsSum = 0;
	
	public FirstTask()
	{
		InitializeItems(); //Get n and m values
	}
	
	private void InitializeItems()
	{
		System.out.print("\tEnter n value: ");
		this.n = Main.GetValue();
		
		System.out.print("\tEnter m value: ");
		this.m = Main.GetValue();
		
		System.out.print("\n");
	}
	
	public int GetTaskResult()
	{
		if (getDigits(this.n) < this.m)
		{
			System.out.println("Entered n value should contains more digits than entered m value");
			return -1;
		}
		
		for (int i = 1; i <= m; i++)
		{
			digitsSum += n%10;
			n = (int) (n/10);
		}
		
		return this.digitsSum;
	}
	
	private int getDigits(int n) //get count of digits from number
	{
		int counter = 0;
		while(n > 0)
		{
			n = (int) (n / 10);
			counter++;
		}
		return counter;
	}
}