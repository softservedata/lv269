/*
 * #226 ƒаны натуральные числа m, n. ѕолучить все их натуральные общие кратные, меньшие mn.
 */

public class SecondTask 
{
	private int n;
	private int m;
	private int mn;
	
	public SecondTask()
	{
		InitializeItems();
	}
	
	private void InitializeItems()
	{
		System.out.print("\tEnter n value: ");
		this.n = Main.GetValue();
		
		System.out.print("\tEnter m value: ");
		this.m = Main.GetValue();
		
		this.mn = m * n;
		
		System.out.print("\n");
	}
	
	public void GetResult()
	{
		System.out.print("\nResult is:");
		for (int i = 1; i < mn; i++)
        {
            if ((m != 0) && (i % m) == 0)
            {
                if ((n != 0) && (i % n) == 0)
                {
                    System.out.print("  " + i);
                }
            }
        }
	}
}