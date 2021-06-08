package lottery;
import java.io.File;
import java.io.IOException;


public class Validation {

	
	// Validate if prizes are lower or equal than array size.
	public static boolean validateRange(int prizes , int arraySize)
	{
       	boolean test = true;
       	
       	if (prizes <= arraySize) {
       		test = true;
       	}
       	else {
       		test = false;
	}

	return test;
  }
	
	
  // Validate if any file exists.
	public static boolean fileExists(String fileName)
	{
	   boolean test = false;
	
	   File tempFile = new File(fileName);
	   test = tempFile.exists();
	
       if (tempFile.exists() == true)
       {
    	   test = true;
       }
       else
       {
    	   test = false;
       }
       
    
       return test;
    }
	
}





/*package lottery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Validation {
	// 1. First place winner gets the Nobel Prize.
	// 2. Second place winner gets the Academy Awards.
	// 3. Third place winner gets the Pulitzer Prize.

	public static void main(String[] args) {

		List<Integer> winningNumbers = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < 3; i++) {
			while (true) {
				int winningNumber = random.nextInt(10) + 1;
				if (!winningNumbers.contains(winningNumber)) {
					winningNumbers.add(winningNumber);
					break; 
				}
			}
		}
		
		//System.out.println(winningNumbers);	
		System.out.println("Please enter your 3 numbers between 1 and 10");
		
		Scanner scanner = new Scanner(System.in);

		List<Integer> guessedNumbers = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			System.out.println("Your current numbers are " + guessedNumbers);
			System.out.println("Please enter a number between 1 and 10: ");
			while (true) {
				try {
					String numberString = scanner.nextLine();
					int number = Integer.parseInt(numberString);
					if (number >= 1 && number <= 10) {
						guessedNumbers.add(number);
						break;
					}
					else {
						System.out.println(number + " is not between 1 and 10. Please try again");
					}
				}

					catch (NumberFormatException nfe) {
						System.out.println("Please enter numbers only. Try again");
					}
					System.out.println("The winning numbers were: " + winningNumbers);
					System.out.println("Your numbers are: " + guessedNumbers);
					
					guessedNumbers.retainAll(winningNumbers);
					System.out.println("Your matched numbers are: " + guessedNumbers);
					
					if (guessedNumbers.containsAll(winningNumbers)) {
						System.out.println("You have won the MEGA prize, the NOBEL PRIZE");
					}
					else {
						System.out.println("Sorry you lost");
					}
					
					
	
	// validate the range

	boolean isValidRange = Validation.validRange(value1);
	if (isValidRange == false) {
	    System.out.println("This is an invalid range");  
		}
	else {
	System.out.println("The range is correct");  
	}
}	
	....



	public class Validation {


	public boolean validRange(int numToValidate) {
			boolean test = false;
		    If (numToValidate > 4) {
			    test = false;
			else {
			   test = true;
			}

			}

		return (test); 

				}

			}
		}

	}*/

