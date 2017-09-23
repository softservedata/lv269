import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		int result = GetTask(); //Get Number of Task
		
		switch (result) //switch to task number
		{
		case 1:  
			FirstTask FT = new FirstTask();
			FT.GetResult();
			break;
			
		case 2:
			SecondTask ST = new SecondTask();
			ST.GetResult();
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
	
	public static int GetTask() //Get number of task, possible correct values only from 1..3
	{
		System.out.print("Please choose # of task, should be 1..3 only: ");

		int n = GetValue();

		if(n<1 || n>3)
		{
			System.out.println("Incorrect number of task, should be as 1..3 only");
			return n;
		}
		return n;
	}
	
	public static int GetValue() //Get value from user, user should enter natural int digit
	{
		Scanner reader = new Scanner(System.in);
		int result = 0;
		try
		{
			result = reader.nextInt();
		}
		catch(Exception e)
		{
			System.out.print("Something entered wrong: " + e.toString());
		}
		
		if(result < 0)
		{
			System.out.println("Entered value is less than 0, so it's not a natural value, changed this value to 1");
			result = 1;
		}
		
		return result;
	}
}