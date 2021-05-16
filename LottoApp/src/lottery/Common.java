package lottery;

	import java.lang.Math;
	import java.io.File;
	import java.io.FileNotFoundException;

	import java.util.*;  

public class Common 
{
	

	public void inputNumbers() 	
	{
		Scanner sc = new Scanner(System.in);
		//System.in is a standard input stream  
		System.out.println("Enter first number- ");  
		int a= sc.nextInt();  
		System.out.println("Enter second number- ");  
		int b= sc.nextInt();  
		int d = (a + b);
		System.out.println("Total= " +d);  
	}

	public ArrayList<String> getParticipants() 
	{
	ArrayList<String> participants = new ArrayList<String>();
	try 
		{
			Scanner scanner = new Scanner(new File("C:\\Users\\edgar\\Downloads\\RaffleFile.txt"));
			while (scanner.hasNextLine()) 
			{
				participants.add(scanner.nextLine());
			}
				scanner.close();
				System.out.println("===> Participants file was loaded");
		} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
				return participants;
	}

		public int getRandom(int num1, int num2) 
		{
		// min = value1,  
	    // max = value2
		return (int) ((Math.random() * (num2 - num1)) + num1); 
		}
}
