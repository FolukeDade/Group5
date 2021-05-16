package lottery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main 
{
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int rand = 0;
		
		// Note:  Update this array 
		
		String[] prizes = {"Null", "The Academy Awards", "The Golden Globes", "The Pulitzer Prize"};
		
		Common c2 = new Common();
		
		// ============================================
		// Read a text file and load it into an array
		// ============================================
		
		// Note: The new participants will have more data (all members from our class)
		
		ArrayList<String> participants = new ArrayList<String>();
		ArrayList<Integer> ticketNumber = new ArrayList<>();
		participants = c2.getParticipants();
		
		int idx = 0;
		for (String temp : participants) 
			{
				ticketNumber.add(idx);
				idx++;
			}
		
		// Note: Change the code below and ask for Prizes to give away.
		//       Include a Do while Loop.
		//       If Number of give away = 0 then exit else continue with the program
		//       Include a validation ... The number of give away can't be higher that elements in prize array.
		
		Scanner sc = new Scanner(System.in);    //System.in is a standard input stream  
		System.out.println("Enter Min number: ");  
		int value1 = sc.nextInt();  
		System.out.println("Enter the Max number: ");  
		int value2 = sc.nextInt();  
		
		// ============================================
		// Get a random number
		// ============================================
		
//        rand = c2.getRandom(value1, value2);
//        System.out.println("Random Number: " + rand);  
        
        // ============================================
     	// Pick the winner(s)
     	// ============================================
        
		   int wins = 0;
           for (int counter = 0; counter < participants.size(); counter++) 
           {
        	//   wins++;
        	   rand = c2.getRandom(value1, value2);
               
//        	   try 	{
//        		    	list.get( index );
//        			} 
//        	   		catch ( IndexOutOfBoundsException e ) 
//        	   		{
//        		    	list.add( index, new Object() );
//        			}
//        	   
            	   if (ticketNumber.get(rand) == rand) 
            	   	{
            		   wins++;
            		   if (wins <= 3)
            		   		{
            			   		System.out.println("The Winner number is: " + rand + " The winner is: " + participants.get(rand) + " The PRIZE!!! " + prizes[wins] );
            		   		}
            		   else
            		   		{
            			    	break;
            		   		}
            	   	}
            	   		else
            	   			{
            	   				System.out.println("Nobody has the number: " + rand);
            	   			}
           }     // End for
           System.out.println("=====================================================================================");
           System.out.println("End of the raffle!!!");
		
			// Note: ask for a new try
            // If yes loop again else exit the loop
	}
}
