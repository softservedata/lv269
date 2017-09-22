/*
 * #559 Дано натуральное число n. Найти все меньшие n числа
Мерсена. (Простое число называется числом Мерсена, если оно может
быть представлено в виде 2^p – 1, где р – тоже простое число.)
 */

public class ThirdTask 
{
	private int n;
	
	public ThirdTask()
	{
		InitializeItems();
	}
	
	private void InitializeItems()
	{
		System.out.print("\tEnter n value: ");
		this.n = Main.GetValue();
		
		System.out.print("\n");
	}
}
