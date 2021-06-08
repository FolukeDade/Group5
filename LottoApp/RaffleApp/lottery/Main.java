package lottery;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

//		
		int rand = 0;
       
		// Check if database is available
        
        String dbName= "jdbc:sqlite:C:\\LotteryApp\\database\\LotteryDB.db";
        boolean validDB = DatabaseAdmin.ConnectDB(dbName);
           
        if (validDB == false)
        {
     		System.out.println("The Database was not found! Please check for the correct path. "); 
       		System.exit(0);
        }
           
           
        // Check if Participants file is available
        String fileNameParticipants= "C:\\LotteryApp\\Files\\Participants.txt"; 
        boolean validFileName = Validation.fileExists(fileNameParticipants);
        
        if (validFileName == false)
        {
       		System.out.println("The Participants.txt file was not found! Please check for the correct path. "); 
       		System.exit(0);
        }
        
        // Check if Prizes file is available
        String fileNamePrizes= "C:\\LotteryApp\\Files\\Prizes.txt"; 
        validFileName = Validation.fileExists(fileNamePrizes);
        
        if (validFileName == false)
        {
       		System.out.println("The Prizes.txt file was not found! Please check for the correct path. "); 
       		System.exit(0);
        }
        
        
		// Note:  Update this array 
		
		// ==========================================================================
		// Read the Participants.txt file and load it into the participants ArrayLIst
		// ==========================================================================
		ArrayList<String> participants = new ArrayList<String>();
		participants = Common.loadTextFiles(fileNameParticipants);	
		
		
		// ==========================================================================
		// Read the Prizes.txt file and load it into the prizes ArrayLIst
		// ==========================================================================
		ArrayList<String> prizes = new ArrayList<String>();
		prizes = Common.loadTextFiles(fileNamePrizes);	

		
		// ==========================================================================
		// The ticketNumber Arraylist will have a key for every item in the participants ArrayLIst
		// ==========================================================================
		ArrayList<Integer> ticketNumber = new ArrayList<>();
				
		// Assigning a number to each participant
		int idx = 0;
		for (String temp : participants) {
			ticketNumber.add(idx);
			idx++;
         }
		
		// BEGIN
		// 
		
		while (true) {	
			
		  Scanner sc = new Scanner(System.in);    //System.in is a standard input stream  
		  System.out.format("Welcome to our Annual Raffle Drawing!! How many Prizes are we starting with in this round? - there are %d prizes - (0 for exit) : " + "\n", prizes.size() );
		  int giveAways = sc.nextInt();  
          
		  if (giveAways == 0) {  // Exit the while
			  break;                
		  }
		  else {
            // Validate if value typed is in range
		    boolean isValidRange= Validation.validateRange(giveAways, prizes.size() ); // -1
		    if (isValidRange == false)
		    {
			   System.out.println("Sorry but do not have enough to giveaway!!! Please try again... ");
			   continue;
		    }
		    else {
                   // get Prizes (process)
		        // ============================================
		     	// Pick the winner(s)
		     	// ============================================
		    	
		    	 
		    	// Integer max = Collections.max(intValues);
                 
		    	int decreaseIndex = prizes.size() ;
		    	
		         for (int counter = 0; counter <= (giveAways -1) ; counter++)  {
		        	 rand = Common.getRandom(0, participants.size() -1);
		        	 decreaseIndex-- ;
		        	 
		        	 System.out.println("The Winner number is: " + rand + " The winner is: " + participants.get(rand) + " The PRIZE!!! " + prizes.get(decreaseIndex) );


		        	 // Save participant into a data base
	            		boolean isInserted = DatabaseAdmin.sqlInsert(participants.get(rand) ,  prizes.get(decreaseIndex));

	            		
	            		if (isInserted == false) {
	            			System.out.println("Warning!!! Inserting data failed.");
	            		}
	            		
	            		
	                 // Remove the Winner and Prize from ArrayList(s)	            		
	                        prizes.remove(decreaseIndex);            		
	            	
	                        
	           }  // End for
	           System.out.println("=====================================================================================");
		  } // End else
		           continue;
         } // End else
	    } // End While 
            System.out.println("End of the raffle!!!");      
            
	           System.out.println("=====================================================================================");
	           System.out.println("   PULLING HISTORIC DATA FROM SQL DATABASE");
	           System.out.println("=====================================================================================");
            
	       	 // Save participant into a data base
       		boolean isSelected = DatabaseAdmin.sqlSelect();
       		
        	// Call the method using arguments
       		// boolean isSelected = DatabaseAdmin.sqlSelect("2021-06-03");       		
       		
       		if (isSelected == false) {
       			System.out.println("Warning!!! Something failed when retrieveing data from the Database");
       		}


		} 
}







/*package lottery;

import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main 
{
	
	public static void main(String[] args) 
	{
		int rand = 0;
		
		String prizes [] = {"First Prize $1.5M", "Second Prize $1M", "Third Prize $500k", "Fourth Prize $250k", "Fifth Prize $100k"};
		
		Common c2 = new Common();
		Validation v1 = new Validation();
		
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
		System.out.println("Welcome to The Lottery, how many prizes would you like to give away? ");  
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
}*/
