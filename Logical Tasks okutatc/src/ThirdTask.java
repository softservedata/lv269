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
		
		//looking candidates on line [2 .. n)
		for(int candidate = 2; candidate < this.n; candidate++)
		{			
			if(!IsPrime(candidate)) // whether mersen-candidate is prime
				continue;
			
			if (IsMersen(candidate)) //whether mersen-candidate is truly Mersen
				System.out.print(" " + candidate);
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
	
	private boolean IsMersen(int number)
	{
		int p = 1; // (first prime number) - 1
		while((int)(Math.pow(2, p) - 1) <= number)
		{
			p++;
			if(!IsPrime(p)) //whether index p prime
				continue;
			
			if ((int)(Math.pow(2, p) - 1) == number)
				return true;
		}
		return false;
	}	
}
