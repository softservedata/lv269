/*
 * #559
 */

public class ThirdTask 
{
	private int n;
	
	public ThirdTask()
	{
		InitializeItems();
	}
	
	public void GetResult()
	{
		System.out.print("Mersen's numbers is: ");
		int candidate = 0;
		for(int p = 2; ; p++)
		{
			if(IsPrime(p))
			{
				candidate = (int)(Math.pow(2, p) - 1);
				if (candidate >= this.n)
					break;
				if (IsPrime(candidate))
					System.out.print(" " + candidate);
			}
		}
	}
	
	private void InitializeItems()
	{
		System.out.print("\tEnter n value: ");
		this.n = Main.GetValue();
		
		System.out.print("\n");
	}
	
	private boolean IsPrime(int number)
	{
		for (int i = 2; i < number; i++)
		{
			if (number%i == 0)
				return false;
		}
		return true;
	}
}
