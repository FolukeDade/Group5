package lottery;
	import java.lang.Math;
	import java.io.File;
	import java.io.FileNotFoundException;

	import java.util.*;  
	
public class Common {

		
    // Read a Text File (Participants and Prizes)
	public static ArrayList<String> loadTextFiles(String fileName) {
		ArrayList<String> textFile = new ArrayList<String>();
		try {
		Scanner scanner = new Scanner(new File(fileName)); 
		while (scanner.hasNextLine()) {
			textFile.add(scanner.nextLine());
		}
		scanner.close();
		if (fileName.contains("Participants")) {
		     System.out.println("===> Participants file was loaded");
		}
		else {
			System.out.println("===> Prizes file was loaded");	
		}
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
		
		return textFile;
	}
	
    
	// Get the Participant's winner number 
	public static int getRandom(int minNum, int maxNum) {
			// minNum = First Participant number, participants ArrayList first = 0   
		    // maxNum = Last Participant number, participants ArrayList last element

		return (int) ((Math.random() * (maxNum - minNum)) + minNum); 
	}
}

/*package lottery;

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
		// min = 0,  
	    // max = 10
		return (int) ((Math.random() * (num2 - num1)) + num1); 
		}
}*/
