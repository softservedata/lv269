package test;
import java.util.Scanner;

public class Task2p1 {

	public static void main(String[] args) {
		// I make it without numbers of integer's :)
		Scanner in = new Scanner(System.in);
		int quantity=0,amount=0;
		System.out.printf("Type your integer's(type not int in the end):");
		while(in.hasNextInt())
		{
			int current=in.nextInt();
			if(current%5==0&&current%7!=0)
			{
				quantity++;
				amount+=current;
			}
		}
		in.close();
		System.out.println("Quantity of integers is:"+quantity+" and amount of them:"+amount);
		
	}

}
